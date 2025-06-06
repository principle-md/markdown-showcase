# 06: Plugin Documentation Outline

This document outlines the structure and content for the user documentation of the Nvim Markdown Slides plugin. The help file will be located at `doc/markdown_slides.txt` and adhere to Vim's help file format.

## Help File: `doc/markdown_slides.txt`

The documentation will be structured to provide users with all necessary information to install, configure, and use the plugin effectively.

**Header Section:**

*   `*markdown_slides.txt* Plugin for Presenting Markdown Slides with React` (Standard help file header)
*   Version number and last updated date.
*   Brief description of the plugin.
*   Link to the plugin's repository.

**Table of Contents (Conceptual):**

1.  Introduction `*markdown_slides-introduction*`
2.  Installation `*markdown_slides-installation*`
3.  Requirements `*markdown_slides-requirements*`
4.  Configuration `*markdown_slides-configuration*`
5.  Usage `*markdown_slides-usage*`
    *   Starting and Stopping the Server `*markdown_slides-server*`
    *   Presenting Markdown `*markdown_slides-presenting*`
    *   Navigating Slides `*markdown_slides-navigation*`
6.  Commands `*markdown_slides-commands*`
7.  Mappings `*markdown_slides-mappings*`
8.  Interacting with the React Library `*markdown_slides-react-integration*`
9.  Troubleshooting `*markdown_slides-troubleshooting*`
10. Contributing `*markdown_slides-contributing*`
11. License `*markdown_slides-license*`

---

### 1. Introduction `*markdown_slides-introduction*`
*   What the plugin does: Enables using a React-based shared library to present markdown files as slides, controlled from Neovim.
*   Core features: Server management, sending markdown, slide navigation.
*   Brief overview of the architecture (Neovim plugin + external Node.js React server).

### 2. Installation `*markdown_slides-installation*`
*   Instructions for installing the plugin using common plugin managers (e.g., Packer, vim-plug, lazy.nvim).
    *   Example snippets for each.
*   Manual installation (clone into `pack` directory).

### 3. Requirements `*markdown_slides-requirements*`
*   Neovim version (e.g., 0.7+ or as required by API usage).
*   Node.js installed and accessible in PATH (for the React server).
*   The shared React markdown slides library (mention if it needs to be installed separately or if it's bundled/vendored with the plugin or the Node.js server component).
*   Any other dependencies (e.g., `curl` if HTTP fallback were used, though current plan is RPC).

### 4. Configuration `*markdown_slides-configuration*`
*   How to configure the plugin (e.g., in `init.lua` or `init.vim`).
*   List of available global configuration variables/options:
    *   `g:markdown_slides_node_server_path` (or Lua equivalent): Path to the Node.js server script.
    *   `g:markdown_slides_port` (or Lua equivalent): Default port for the React server's web view. (Explain if it tries to find a free port).
    *   `g:markdown_slides_auto_open_browser` (boolean): Whether to automatically open the browser after starting the server and presenting.
    *   `g:markdown_slides_auto_present_on_save` (boolean): Whether to automatically re-present on saving a markdown buffer.
    *   `g:markdown_slides_react_app_host` (string): Host for the React app (default: `127.0.0.1`).
*   Example configuration snippet.

### 5. Usage `*markdown_slides-usage*`

#### 5.1. Starting and Stopping the Server `*markdown_slides-server*`
    *   Explain the `:MarkdownSlidesStart` command.
    *   Explain the `:MarkdownSlidesStop` command.
    *   Mention the corresponding default mappings.

#### 5.2. Presenting Markdown `*markdown_slides-presenting*`
    *   Explain the `:MarkdownSlidesPresent` command (works on the current buffer).
    *   Mention the corresponding default mapping.
    *   Describe what happens (markdown sent, browser view updates).

#### 5.3. Navigating Slides `*markdown_slides-navigation*`
    *   Explain `:MarkdownSlidesNext`, `:MarkdownSlidesPrev`.
    *   (If implemented) `:MarkdownSlidesGotoSlide {N}`, `:MarkdownSlidesFirst`, `:MarkdownSlidesLast`.
    *   Mention the corresponding default mappings.

### 6. Commands `*markdown_slides-commands*`
*   A detailed list of all user commands provided by the plugin:
    *   `:MarkdownSlidesStart`
    *   `:MarkdownSlidesStop`
    *   `:MarkdownSlidesPresent`
    *   `:MarkdownSlidesNext`
    *   `:MarkdownSlidesPrev`
    *   (And any others)
*   For each command: its purpose, arguments (if any), and behavior.

### 7. Mappings `*markdown_slides-mappings*`
*   List of default mappings provided by the plugin (e.g., `<Leader>ms`, `<Leader>mp`, etc.).
*   Explanation of how users can customize these mappings or disable them.
*   Reference to `<Leader>` and how to set it.

### 8. Interacting with the React Library `*markdown_slides-react-integration*`
*   Brief explanation that the plugin communicates with an external Node.js process running the React library.
*   Mention the communication method (JSON-RPC over stdio).
*   This section is more for user awareness of the architecture rather than direct interaction details, unless there are specific things users need to know about the React server itself (e.g., where its logs might go if not captured by the plugin).

### 9. Troubleshooting `*markdown_slides-troubleshooting*`
*   Common issues and their solutions:
    *   Server not starting (Node.js not found, script path incorrect).
    *   Plugin commands not found (installation issue).
    *   Errors reported from the server.
    *   How to get debug logs from the plugin or server.
*   Where to report issues (e.g., GitHub issues page).

### 10. Contributing `*markdown_slides-contributing*`
*   Information for users who want to contribute to the plugin's development.
*   Link to contribution guidelines if any.

### 11. License `*markdown_slides-license*`
*   The license under which the plugin is distributed (e.g., MIT, GPL).

This structure will ensure the documentation is comprehensive and easy for users to navigate. Tags (`*tag-name*`) will be used throughout to allow quick jumping to specific sections via `:help tag-name`.
```
