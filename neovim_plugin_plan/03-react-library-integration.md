# 03: React Library Integration via Node.js Process

Integrating the React-based markdown slides library requires communication between the Neovim plugin and the React application. This will be achieved by running the React library within its own Node.js process and establishing a clear communication channel.

## Separate Node.js Process

The React markdown slides library will operate as a standalone Node.js server process. This is necessary because:
1.  **Environment Complexity**: React applications have their own build systems, dependencies (Node.js, npm/yarn), and runtime environments that are distinct from Neovim's Lua/Vimscript environment.
2.  **Performance**: Running a web server or a complex React application directly within Neovim's process could degrade editor performance.
3.  **Development Workflow**: Keeping the React application as a separate process aligns with standard web development practices and allows for independent development and testing of the slides library.

## Process Management by Neovim Plugin

The Neovim plugin will be responsible for managing the lifecycle of this Node.js server process.

*   **Starting the Server**:
    *   When the user invokes a command like `:MarkdownSlidesStart` or the first relevant action, the plugin will check if the Node.js server is already running.
    *   If not, the plugin will use Neovim's job control features to start the Node.js server. In Lua, this can be done using `vim.fn.jobstart()` or `vim.loop.spawn()` for more control.
    *   The command to start the server would typically be something like `node path/to/react/slides/server.js --port <port_number>`. The plugin might need to configure an available port or use a default one.
    *   The plugin should handle potential errors during server startup (e.g., Node.js not found, script errors).
*   **Stopping the Server**:
    *   A command like `:MarkdownSlidesStop` will instruct the plugin to terminate the Node.js server process. This could involve sending a specific signal (e.g., SIGTERM) to the job ID or sending a shutdown message via the communication channel.
*   **Error Handling & Monitoring**:
    *   The plugin should monitor the stdout/stderr of the Node.js process to detect crashes or errors, notifying the user accordingly.
    *   It should also gracefully handle cases where the server process dies unexpectedly.

## Communication Mechanism

Direct and efficient communication is key. We'll use Neovim's built-in RPC capabilities, specifically over standard I/O (stdio) with the Node.js process.

1.  **JSON-RPC over Stdio**:
    *   The Node.js server will listen for JSON-RPC messages on its stdin and send JSON-RPC responses/notifications via its stdout.
    *   Neovim's Lua API provides functions like `vim.rpcnotify()` and `vim.rpcrequest()` to send messages to a channel associated with a job.
    *   When `jobstart()` is used, it can be configured to open an RPC channel with the spawned process.
    *   This approach is efficient and avoids the overhead of HTTP for local inter-process communication.

2.  **Alternative (Less Preferred): HTTP API**:
    *   The Node.js server could expose a simple HTTP/WebSocket API (e.g., using Express.js).
    *   The Neovim plugin would then use an HTTP client (e.g., `curl` via `vim.fn.system()` or a Lua HTTP library like `luv-http` or `lua-curl`) to send requests.
    *   While feasible, this adds complexity (port management, HTTP server setup, potential security considerations if exposed beyond localhost) and is generally less direct than stdio RPC for this use case. Stdio RPC is preferred.

## Defined "API" (JSON-RPC Messages)

The following defines the conceptual messages exchanged between the Neovim plugin and the Node.js React server. These would be formalized as JSON-RPC method calls and notifications.

**Plugin -> Node.js Server (Requests/Notifications):**

*   **`initialize` (Request)**
    *   Params: `{ "config": { ... } }` (Optional: any initial configuration for the slides library)
    *   Response: `{ "status": "ready", "port": <port_if_http_server_started_for_webview> }` or error.
*   **`renderMarkdown` (Request)**
    *   Params: `{ "markdown": "...", "filePath": "..." }` (Full markdown content and optionally its path)
    *   Response: `{ "status": "success", "slideCount": N }` or error. This might trigger the React app to update its view.
*   **`navigate` (Notification or Request)**
    *   Params: `{ "direction": "next" | "previous" | "first" | "last" | "goto", "slideNumber": M }`
    *   Response (if request): `{ "status": "success", "currentSlide": K }` or error.
*   **`getCurrentState` (Request)**
    *   Params: None
    *   Response: `{ "currentSlide": K, "slideCount": N, "notes": "..." }` or error.
*   **`shutdown` (Notification)**
    *   Params: None (Instructs the server to gracefully shut down)

**Node.js Server -> Plugin (Notifications):**

*   **`slideChanged`**
    *   Params: `{ "currentSlide": K, "slideCount": N, "notes": "..." }` (When slide changes internally in React app)
*   **`serverLog`**
    *   Params: `{ "level": "info" | "error" | "warn", "message": "..." }`
*   **`serverError`**
    *   Params: `{ "message": "...", "details": "..." }` (For unrecoverable server errors)

This API structure ensures that Neovim can control the presentation flow and receive updates, while the React library handles the actual rendering and slide logic. The choice of JSON-RPC over stdio simplifies the communication layer significantly.
```
