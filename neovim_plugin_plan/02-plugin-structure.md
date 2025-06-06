# 02: Core Plugin Structure and Entry Points

This document outlines the proposed file structure for the Markdown Slides Neovim plugin and details its main entry points, including user commands and mappings. We aim for a modern Neovim plugin structure, leveraging Lua for core logic where beneficial.

## Proposed File Structure

```
nvim-markdown-slides/
├── plugin/
│   └── markdown_slides.lua       # Main entry point, sets up commands/mappings
├── lua/
│   └── nvim-markdown-slides/     # Lua module for core logic
│       ├── init.lua              # Module entry, may load other sub-modules
│       ├── core.lua              # Core logic for server mgmt, React lib interaction
│       └── utils.lua             # Utility functions (optional)
├── autoload/
│   └── markdown_slides.vim       # (Optional) Vimscript helper for very simple initial loading if needed
└── doc/
    └── markdown_slides.txt       # Plugin documentation
```

*   **`plugin/markdown_slides.lua`**: This will be the first file Neovim sources for this plugin. Its primary role is to define user commands and mappings. These will, in turn, call functions from our Lua module (`lua/nvim-markdown-slides/core.lua`).
*   **`lua/nvim-markdown-slides/init.lua`**: This acts as the main file for our Lua module. It can simply return the `core.lua` module or orchestrate multiple sub-modules if the plugin grows complex.
*   **`lua/nvim-markdown-slides/core.lua`**: This is where the substantial plugin logic will reside. Functions for starting/stopping the Node.js server, sending markdown data, and handling communication with the React library will be implemented here.
*   **`autoload/markdown_slides.vim` (Optional)**: If we need any Vimscript-specific bootstrapping that's cleaner than Lua for initial setup (e.g., complex `<SID>` or `<Plug>` setups that are more verbose in Lua, or for `g:loaded_` guard if preferred in Vimscript), we could place it here. However, the goal is to keep most logic in Lua. For a primarily Lua plugin, the guard can also be in `plugin/markdown_slides.lua`.
*   **`doc/markdown_slides.txt`**: Standard help file for users.

## Main Plugin File: `plugin/markdown_slides.lua`

This file will be responsible for setting up the user-facing aspects of the plugin.

```lua
-- plugin/markdown_slides.lua

-- Guard to prevent multiple loads
if vim.g.loaded_nvim_markdown_slides then
  return
end
vim.g.loaded_nvim_markdown_slides = 1

-- Preserve cpoptions (if any Vimscript interaction is anticipated elsewhere, less critical for pure Lua)
-- local save_cpo = vim.o.cpoptions
-- vim.o.cpoptions = vim.env.vim_default_cpoptions -- Or specific flags

-- Require the core logic module
local core = require('nvim-markdown-slides.core') -- Path matches lua/nvim-markdown-slides/core.lua

-- User Commands
vim.api.nvim_create_user_command('MarkdownSlidesStart', core.start_server, {
  desc = 'Starts the Markdown Slides presentation server.'
})

vim.api.nvim_create_user_command('MarkdownSlidesStop', core.stop_server, {
  desc = 'Stops the Markdown Slides presentation server.'
})

vim.api.nvim_create_user_command('MarkdownSlidesPresent', core.present_current_buffer, {
  desc = 'Renders the current buffer with the Markdown Slides library.'
})

vim.api.nvim_create_user_command('MarkdownSlidesNext', core.next_slide, {
  desc = 'Navigates to the next slide.'
})

vim.api.nvim_create_user_command('MarkdownSlidesPrev', core.previous_slide, {
  desc = 'Navigates to the previous slide.'
})

-- Mappings
-- Users can map these themselves, but we can provide defaults.
-- Example using <Plug> style if we want to allow remapping of parts.
-- For Lua, direct calls are often cleaner unless providing <Plug> for Vimscript users.

vim.keymap.set('n', '<Leader>ms', core.start_server, { noremap = true, silent = true, desc = 'MarkdownSlides: Start Server' })
vim.keymap.set('n', '<Leader>mp', core.present_current_buffer, { noremap = true, silent = true, desc = 'MarkdownSlides: Present Buffer' })
vim.keymap.set('n', '<Leader>mn', core.next_slide, { noremap = true, silent = true, desc = 'MarkdownSlides: Next Slide' })
vim.keymap.set('n', '<Leader>mb', core.previous_slide, { noremap = true, silent = true, desc = 'MarkdownSlides: Previous Slide (Back)' })
vim.keymap.set('n', '<Leader>mq', core.stop_server, { noremap = true, silent = true, desc = 'MarkdownSlides: Stop Server (Quit)' })


-- Restore cpoptions (if changed)
-- vim.o.cpoptions = save_cpo

vim.notify('nvim-markdown-slides plugin loaded (basic commands/maps set).', vim.log.levels.INFO)
```

### Key Responsibilities of `plugin/markdown_slides.lua`:

1.  **Initialization Guard**: Implement `vim.g.loaded_nvim_markdown_slides` to prevent multiple loads.
2.  **`cpoptions`**: Handle `cpoptions` if necessary (more relevant if mixing heavily with Vimscript parts that might be affected). For a mostly Lua plugin, this is less of a concern.
3.  **Require Core Logic**: Use `require()` to load the main Lua module from `lua/nvim-markdown-slides/`.
4.  **Define User Commands**: Use `vim.api.nvim_create_user_command()` to expose plugin functionality. These commands will call functions from the loaded Lua module.
    *   `:MarkdownSlidesStart`: To initialize and start the external React slide server.
    *   `:MarkdownSlidesStop`: To stop the server.
    *   `:MarkdownSlidesPresent`: To send the current buffer's markdown to the React library for presentation.
    *   `:MarkdownSlidesNext`: Command to advance to the next slide.
    *   `:MarkdownSlidesPrev`: Command to go to the previous slide.
5.  **Define Mappings**: Use `vim.keymap.set()` to provide default keyboard shortcuts for the common commands. These will also call functions from the Lua module. We'll use `<Leader>` prefixed mappings for easy customization by the user.

## Delegation to Autoloaded/Lua Logic

It's crucial that the `plugin/markdown_slides.lua` file remains lean. Its main job is to set up the interface (commands and mappings). All the heavy lifting—managing the external Node.js process, IPC, handling slide logic—will be delegated to functions within the `lua/nvim-markdown-slides/core.lua` module. This promotes separation of concerns and leverages Lua's strengths for more complex tasks.
```
