# 01: Neovim Plugin Fundamentals

This document covers the basic concepts essential for understanding and developing a Neovim plugin, particularly a global plugin that isn't tied to a specific filetype.

## Plugin Anatomy

A Neovim plugin is essentially a collection of scripts (Vimscript or Lua) that extend Neovim's functionality. These scripts can define new commands, mappings, autocommands, and more. For our project, we are developing a "global" plugin, meaning it will be active regardless of the filetype being edited.

## Common Directory Structures

Neovim plugins typically follow a standard directory structure within the user's configuration directory (e.g., `~/.config/nvim/`) or as part of a plugin manager's controlled directory:

*   **`plugin/`**: Scripts in this directory are automatically sourced by Neovim on startup, after user config (`init.vim` or `init.lua`) and package plugins. This is where the main entry point of a plugin often resides.
*   **`autoload/`**: This directory is for scripts that are loaded on demand. Functions and variables defined in `autoload/scriptname.vim` can be invoked using `scriptname#function()` or `scriptname#variable`. This helps in speeding up Neovim's startup time by only loading code when it's actually needed. This is highly recommended for larger plugins.
*   **`doc/`**: Contains help files for the plugin, written in a specific format (see `:help write-local-help`). Users can access this documentation via `:help plugin-name`.
*   **`ftplugin/`**: For filetype-specific plugins. Scripts here are sourced when a buffer of a matching filetype is opened. (Not our primary focus for this global plugin, but good to know).
*   **`lua/`**: In modern Neovim, Lua code often resides here, organized into modules. An `init.lua` in `lua/plugin-name/` can be `require`d.

## Plugin Loading Mechanism & Guards

To prevent a plugin from being loaded multiple times (which can cause errors or duplicate behavior), a common pattern is to use a global guard variable:

```vimscript
" In plugin/myplugin.vim
if exists("g:loaded_myplugin")
  finish
endif
let g:loaded_myplugin = 1

" Rest of the plugin code...
```

The `finish` command stops sourcing the current script.

## Development Languages: Vimscript and Lua

*   **Vimscript (Vim script, VimL):** The traditional language for Vim and Neovim plugins. It's powerful for editor manipulation but can be quirky. Its documentation is extensive (`:help usr_41.txt`).
*   **Lua:** Neovim has excellent Lua integration, and it has become the preferred language for new plugin development. Lua offers better performance, a more modern syntax, and a rich ecosystem of libraries. Neovim provides a Lua API (`:help lua-api`) to interact with the editor.

For this project, we should consider using Lua for the core logic, especially for interacting with external processes (our React library), potentially using Vimscript for the initial plugin loading and command/mapping setup if preferred for simplicity there.

## Key Concepts for Robust Plugins

These concepts, primarily from Vimscript but with Lua equivalents, are crucial for writing well-behaved plugins:

*   **Scope and Script-Local Items:**
    *   **`s:variable` / `s:Function()` (Vimscript):** Variables and functions prefixed with `s:` are local to the script in which they are defined. They are not accessible outside the script, preventing naming collisions between different plugins.
    *   **`<SID>` (Vimscript Mappings):** Stands for "Script ID." When used in a mapping (e.g., `noremap <SID>MyMapping :call <SID>MyFunction()<CR>`), `<SID>` is replaced by a unique identifier for that script (e.g., `<SNR>123_`). This allows mappings to call script-local functions correctly.
    *   **Lua Modules:** Lua uses `local` variables and functions within files/modules to achieve similar encapsulation. Functions intended for external use are returned from the module.

*   **Mappings:**
    *   **`<Leader>`:** A user-configurable prefix for mappings. Users can set `mapleader` (e.g., `let mapleader = ","`) to customize plugin mappings. Example: `map <Leader>x :echo "Plugin X"<CR>`.
    *   **`<LocalLeader>`:** Similar to `<Leader>`, but intended for mappings local to a buffer (often used in filetype plugins). Users can set `maplocalleader`.
    *   **`<Plug>` Mappings:** Used to define "internal" mappings that users can then map their preferred keys to. Example:
        ```vimscript
        " In plugin code:
        noremap <Plug>MyPluginAction :echo "Action!"<CR>
        " User in their init.vim:
        " nmap <Leader>p <Plug>MyPluginAction
        ```
        This provides a stable interface for plugin actions. The format is typically `<Plug>PluginNameActionName`.
    *   **`noremap` vs. `map`:** `noremap` (and `nnoremap`, `vnoremap`, etc.) defines a non-recursive mapping. This is generally recommended for plugins to avoid unexpected interactions with other mappings. Use `map` only if recursive behavior is explicitly desired.
    *   **`<unique>`:** When defining a mapping with `<unique>` (e.g., `map <unique> <Leader>x ...`), Neovim will error if the mapping already exists, preventing accidental overrides.
    *   **`<script>` (Mappings):** `noremap <script> ...` ensures that only script-local mappings are considered when the right-hand side is evaluated.

*   **User Commands:**
    *   Custom commands can be defined using `:command`.
        ```vimscript
        " :command MyCommand echo "Hello"
        " :command -nargs=1 MyFileCommand echo "File:" .. <q-args>
        ```
    *   It's good practice to check if a command already exists before defining it to avoid errors:
        ```vimscript
        if !exists(":MyCommand")
          command MyCommand echo "Hello from MyCommand"
        endif
        ```

*   **`cpoptions` Handling:**
    *   The `'cpoptions'` setting affects compatibility with Vi. To ensure consistent plugin behavior, it's common to save its value, set it to the Neovim default (`set cpo&vim`), and restore it at the end of the script:
        ```vimscript
        let s:save_cpo = &cpo
        set cpo&vim
        " ... plugin code ...
        let &cpo = s:save_cpo
        unlet s:save_cpo
        ```

These fundamentals provide a solid base for creating a well-structured and robust Neovim plugin that can coexist with other plugins in a user's environment.
