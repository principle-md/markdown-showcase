# 04: Autoloaded Core Logic (Lua Module)

This document details the core logic of the Nvim Markdown Slides plugin, which will reside primarily in a Lua module: `lua/nvim-markdown-slides/core.lua`. This module will be `require`d by the main plugin file (`plugin/markdown_slides.lua`) and will handle all significant operations like server management and communication with the React slides library.

## Lua Module: `lua/nvim-markdown-slides/core.lua`

This module encapsulates the plugin's main functionalities.

```lua
-- lua/nvim-markdown-slides/core.lua

local M = {} -- Our module table

local job_id = nil
local rpc_channel = nil
local server_host = "127.0.0.1" -- Or configurable
local server_port = nil -- Will be assigned or configured

-- Utility for sending notifications to the user
local function notify(msg, level)
  vim.notify(msg, level or vim.log.levels.INFO, { title = "MarkdownSlides" })
end

-- Handler for RPC messages from the Node.js server
local function on_rpc_event(err, method, params)
  if err then
    notify("RPC Error: " .. vim.inspect(err), vim.log.levels.ERROR)
    return
  end

  if method == "slideChanged" then
    notify(string.format("Slide changed: %d/%d. Notes: %s", params.currentSlide, params.slideCount, params.notes or "N/A"))
  elseif method == "serverLog" then
    notify(string.format("[Server]: %s", params.message), params.level == "error" and vim.log.levels.ERROR or (params.level == "warn" and vim.log.levels.WARN or vim.log.levels.INFO))
  elseif method == "serverError" then
    notify(string.format("Server Error: %s %s", params.message, params.details or ""), vim.log.levels.ERROR)
  -- Handle other notifications from server
  end
end

local function on_server_exit(jobid, code, event)
  notify(string.format("Markdown Slides server (job %d) exited with code %d.", jobid, code), vim.log.levels.WARN)
  job_id = nil
  rpc_channel = nil
end

--- Starts the Node.js Markdown Slides server.
function M.start_server()
  if job_id then
    notify("Server already running (Job ID: " .. job_id .. ")", vim.log.levels.WARN)
    -- Optionally, try to ping it or re-initialize
    return
  end

  -- TODO: Make path to server script configurable
  local server_script_path = vim.fn.stdpath("config") .. "/lua/nvim-markdown-slides/react_server/server.js" -- Placeholder
  -- TODO: Check if server_script_path exists

  -- TODO: Find a free port or use a configured one
  -- For now, let's assume a fixed port for the Node server to listen on for HTTP (if it hosts a webview)
  -- and it will use stdio for RPC with Neovim.
  local assigned_node_port = 3001 -- Example port for webview, not for RPC.

  local command = {
    "node",
    server_script_path,
    "--port", tostring(assigned_node_port), -- if server needs to serve HTTP
    "--stdio-rpc" -- flag for server to know to use stdio for JSON-RPC
  }

  local opts = {
    rpc = true, -- Enable RPC communication over stdio
    on_stdout = function(err, data, event) if data then vim.print("Server stdout:", data) end end, -- For debugging
    on_stderr = function(err, data, event) if data then notify("Server stderr: " .. data, vim.log.levels.ERROR) end end,
    on_exit = on_server_exit,
  }

  local new_job_id, new_rpc_channel = vim.fn.jobstart(command, opts)

  if new_job_id and new_job_id > 0 then
    job_id = new_job_id
    rpc_channel = new_rpc_channel -- This is the channel ID for vim.rpcnotify/vim.rpcrequest
    notify("Markdown Slides server started (Job ID: " .. job_id .. "). RPC Channel: " .. rpc_channel)

    -- Optional: Send an initialize request after server starts
    vim.rpcrequest(rpc_channel, "initialize", { config = { theme = "dark" } }, function(err_init, result_init)
      if err_init then
        notify("Error initializing server: " .. vim.inspect(err_init), vim.log.levels.ERROR)
        return
      end
      if result_init and result_init.port then
         server_port = result_init.port -- if the server dynamically assigns a port for a webview
         notify("React server initialized and listening for webview on port: " .. server_port)
      else
        notify("React server initialized.")
      end
    end)
  else
    notify("Failed to start Markdown Slides server.", vim.log.levels.ERROR)
    job_id = nil
    rpc_channel = nil
  end
end

--- Stops the Node.js Markdown Slides server.
function M.stop_server()
  if not job_id then
    notify("Server is not running.", vim.log.levels.WARN)
    return
  end

  notify("Stopping Markdown Slides server (Job ID: " .. job_id .. ")")
  -- Attempt graceful shutdown first
  vim.rpcnotify(rpc_channel, "shutdown", {})

  -- Force kill if it doesn't stop after a timeout (omitted for brevity, but important in practice)
  vim.fn.jobstop(job_id)
  -- on_server_exit should handle cleanup of job_id and rpc_channel
end

--- Sends the current buffer's markdown content to the React app.
function M.present_current_buffer()
  if not job_id or not rpc_channel then
    notify("Server is not running. Please start it first.", vim.log.levels.ERROR)
    return
  end

  local current_buffer_content = table.concat(vim.api.nvim_buf_get_lines(0, 0, -1, false), "\n")
  local file_path = vim.api.nvim_buf_get_name(0)

  vim.rpcrequest(rpc_channel, "renderMarkdown", { markdown = current_buffer_content, filePath = file_path }, function(err, result)
    if err then
      notify("Error rendering markdown: " .. vim.inspect(err), vim.log.levels.ERROR)
      return
    end
    if result and result.status == "success" then
      notify(string.format("Markdown sent. Slide count: %d. View at http://%s:%s", result.slideCount or 0, server_host, server_port or "N/A"))
      -- Potentially open the browser automatically: vim.fn.system("open http://" .. server_host .. ":" .. server_port)
    else
      notify("Failed to render markdown. Server response: " .. vim.inspect(result), vim.log.levels.ERROR)
    end
  end)
end

--- Navigates to the next slide.
function M.next_slide()
  if not job_id or not rpc_channel then return notify("Server not running.", vim.log.levels.ERROR) end
  vim.rpcnotify(rpc_channel, "navigate", { direction = "next" })
  notify("Next slide command sent.")
end

--- Navigates to the previous slide.
function M.previous_slide()
  if not job_id or not rpc_channel then return notify("Server not running.", vim.log.levels.ERROR) end
  vim.rpcnotify(rpc_channel, "navigate", { direction = "previous" })
  notify("Previous slide command sent.")
end

-- Add other navigation functions (goto, first, last) as needed.

-- Ensure server is stopped when Neovim exits
vim.api.nvim_create_autocmd("VimLeavePre", {
  pattern = "*",
  callback = function()
    if job_id then
      M.stop_server()
    end
  end,
})

return M
```

### Key Functions and Responsibilities:

*   **`M.start_server()`**:
    *   Checks if the server is already running.
    *   Constructs the command to execute the Node.js server script.
        *   **Configuration needed**: Path to the server script, mechanism to determine a free port or use a configured one.
    *   Uses `vim.fn.jobstart()` with `rpc = true` to establish a JSON-RPC channel over stdio.
    *   Sets up handlers for `on_stdout`, `on_stderr`, and `on_exit` for the job.
    *   Stores `job_id` and `rpc_channel`.
    *   Optionally sends an `initialize` RPC message to the server.
*   **`M.stop_server()`**:
    *   Checks if the server is running.
    *   Sends a `shutdown` RPC notification for graceful termination.
    *   Uses `vim.fn.jobstop()` to forcefully terminate if necessary.
    *   Cleans up `job_id` and `rpc_channel` (likely via `on_server_exit` callback).
*   **`M.present_current_buffer()`**:
    *   Ensures the server is running.
    *   Retrieves the content of the current buffer.
    *   Sends a `renderMarkdown` RPC request to the server with the markdown content and file path.
    *   Handles the response, notifying the user of success (and where to view, e.g., `http://localhost:PORT`) or failure.
*   **`M.next_slide()` / `M.previous_slide()`**:
    *   Ensure server is running.
    *   Send `navigate` RPC notifications to the server.
*   **RPC Event Handler (`on_rpc_event`)**:
    *   A generic callback that would be registered with `vim.fn.jobstart` if the server could initiate arbitrary RPC calls to Neovim (less common for this stdio model unless specifically designed). Neovim's `rpcnotify` and `rpcrequest` handle responses to its own requests. For server-initiated notifications *to* Neovim, the server would need to know Neovim's channel ID, or a more complex setup like a listening server in Neovim would be needed.
    *   *Correction*: `vim.fn.jobstart`'s `on_stdout` is where RPC *responses* and *notifications from the server* will arrive if `rpc=true`. The `rpc*` functions are for *sending*. The example `on_rpc_event` is more conceptual; actual handling of server-to-client notifications will be through parsing messages received on `on_stdout` or a dedicated RPC message handler if `jobstart` provides one directly for incoming messages. Neovim's RPC client handles request/response matching. For server-initiated notifications, the server just sends a JSON-RPC notification object to its stdout. Neovim's RPC mechanism on the channel should be able to dispatch these to a handler if configured (e.g. `vim.rpcrequest(ch, method, params, on_response_cb, {on_notification_cb = ...})` or similar channel setup). For simplicity, the example relies on Neovim's internal dispatch for responses and shows manual parsing for conceptual server->nvim notifications.
    *   *Simplified approach*: Neovim's `jobstart` with `rpc=true` automatically handles the JSON-RPC framing. Callbacks like `on_stdout` will receive already-parsed messages if they are RPC responses. For notifications *from* the server *to* Neovim, we would need to define handlers. The provided `on_rpc_event` is a placeholder for such a handler. The main `vim.rpcnotify` and `vim.rpcrequest` calls from Neovim will have their own callbacks for responses or errors.
*   **`on_server_exit`**: Callback for when the server job terminates, used for cleanup.
*   **`VimLeavePre` Autocommand**: Ensures the server is stopped when Neovim exits.

### Utility Functions:
*   `notify()`: A wrapper around `vim.notify` for consistent user messages.

This Lua module forms the core of the plugin's functionality, keeping the `plugin/markdown_slides.lua` (or Vimscript equivalent) minimal and focused on UI setup.
```

**Note on RPC Handling in `jobstart`**:
The provided Lua example for `core.lua` uses `vim.fn.jobstart` with `rpc = true`.
When `rpc=true`, Neovim handles the msgpack-rpc encoding/decoding.
- `vim.rpcrequest(channel, method, params, callback)`: Sends a request and `callback` handles the server's response.
- `vim.rpcnotify(channel, method, params)`: Sends a notification (no response expected).
- For messages *from* the server *to* Neovim (server-initiated notifications), these would typically be handled by a general message handler you can set up on the channel, or by how `jobstart` itself dispatches them. The `on_stdout` and `on_stderr` are still useful for raw output/debugging, but RPC messages have their own path. The `on_rpc_event` function in the example is a conceptual representation of how one might handle incoming notifications if not directly tied to a request's callback.

The example `M.start_server` initializes `rpc_channel = new_rpc_channel`. This `rpc_channel` is what `vim.rpcrequest` and `vim.rpcnotify` will use. Server-initiated notifications to Neovim would also arrive via this channel and need a handler if they are not direct responses to Neovim's requests. For now, the example focuses on Neovim-initiated requests and their direct callbacks.
