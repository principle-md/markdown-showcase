# 07: Packaging and Distribution

This document covers considerations for packaging and distributing the Nvim Markdown Slides plugin.

## Packaging

*   **Git Repository**: The primary method of packaging will be a Git repository (e.g., hosted on GitHub, GitLab). This is standard for Neovim plugins and allows users to easily install and update it using plugin managers.
*   **Directory Structure**: The repository will follow the standard plugin directory structure outlined in `02-plugin-structure.md`:
    ```
    nvim-markdown-slides/
    ├── plugin/
    │   └── markdown_slides.lua
    ├── lua/
    │   └── nvim-markdown-slides/
    │       ├── init.lua
    │       └── core.lua
    ├── doc/
    │   └── markdown_slides.txt
    └── README.md
    ```
*   **Node.js Server Component**: A critical aspect is how the Node.js server part of the React shared library is handled.
    *   **Option 1: Bundled/Vendored (Preferred for ease of use)**: If feasible and licenses permit, a pre-built or easily runnable version of the Node.js server component could be included within the plugin repository (e.g., in a `server/` subdirectory). This simplifies setup for the end-user significantly, as they wouldn't need to separately clone/install the React library's server part. The plugin would then know the relative path to this server script.
    *   **Option 2: Separate Installation**: If bundling isn't practical, the documentation must clearly state that the user needs to separately install/clone the React shared library and its server component. The plugin would then require a configuration option for the user to specify the path to the server startup script. This adds an extra setup step for the user.
    *   **Recommendation**: Aim for Option 1 if possible, as it makes the plugin much more self-contained.

## Distribution

*   **Plugin Managers**: Users will primarily install the plugin via Neovim plugin managers like:
    *   Packer.nvim
    *   vim-plug
    *   lazy.nvim
    *   The plugin's `README.md` and documentation (`doc/markdown_slides.txt`) will include installation instructions for these popular managers.
*   **Vim.org**: Listing the plugin on [vim.org](https://www.vim.org) can increase its visibility.
*   **GitHub Releases**: If bundling the Node.js server, GitHub releases could be used to provide tagged versions, potentially including pre-built assets if the server part has a build step.

## Compatibility

*   **Neovim Version**: Specify the minimum required Neovim version. This will depend on the Lua API functions used (e.g., `vim.fn.jobstart`, `vim.rpcnotify`, `vim.rpcrequest`, `vim.keymap.set`). A common target might be Neovim 0.7+ or 0.8+. This should be tested.
*   **Node.js**: Users must have Node.js installed and available in their system's PATH for the React server to run. The required Node.js version should also be specified (e.g., LTS versions like 16.x, 18.x, or as required by the React library).
*   **Operating Systems**: The plugin should aim to be cross-platform (Linux, macOS, Windows).
    *   Path separators and shell commands (if any, though `jobstart` helps abstract this) need to be handled carefully. Lua's `package.config:sub(1,1)` can get the OS path separator.
    *   The Node.js server component must also be cross-platform.

## Dependencies

*   **External Dependencies (User-installed)**:
    *   **Node.js**: As mentioned above.
    *   **React Shared Library Server**: If not bundled (Option 2 above), this becomes a critical external dependency the user must manage.
*   **Internal Dependencies (Managed by the plugin or part of Neovim)**:
    *   The plugin relies on Neovim's built-in Lua engine and API.
    *   No external Lua libraries are currently planned, but if they were added (e.g., an HTTP client if RPC wasn't used), they would need to be considered in the packaging (e.g., by vendoring or requiring user installation).

Clear instructions regarding these aspects in the main `README.md` and the plugin's help file will be crucial for a smooth user adoption. The choice of bundling the Node.js server component or requiring a separate installation is the most significant decision affecting packaging and ease of setup.
```
