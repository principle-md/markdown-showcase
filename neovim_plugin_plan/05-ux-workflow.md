# 05: User Experience (UX) and Workflow

This document describes the intended user experience and typical workflows when interacting with the Nvim Markdown Slides plugin.

## Core Interaction Points

The user will primarily interact with the plugin via:
1.  **Commands**: For actions like starting/stopping the server, initiating a presentation.
2.  **Mappings**: Keyboard shortcuts for frequent actions like slide navigation.
3.  **Notifications**: Feedback from the plugin and the React server (e.g., status messages, errors).

## Typical Workflow

Here's a step-by-step typical workflow:

1.  **Starting the Presentation Server**:
    *   The user runs `:MarkdownSlidesStart` or uses the `<Leader>ms` mapping.
    *   **Feedback**: Neovim displays a notification:
        *   "Markdown Slides server starting..."
        *   On success: "Markdown Slides server started (Job ID: X). RPC Channel: Y. React server initialized and listening for webview on port: Z" (if port is reported by server).
        *   Or: "Markdown Slides server initialized."
        *   On failure: "Failed to start Markdown Slides server. Error: [details]."
    *   This step launches the background Node.js process. The plugin might also automatically open a web browser to `http://localhost:PORT` where the slides will be rendered, or it will instruct the user to do so. This behavior should be configurable.

2.  **Presenting a Markdown File**:
    *   With a markdown file open in a buffer, the user runs `:MarkdownSlidesPresent` or uses the `<Leader>mp` mapping.
    *   **Action**: The plugin sends the content of the current buffer to the Node.js/React server via RPC.
    *   **Feedback**:
        *   "Sending markdown to presentation server..."
        *   On success from server: "Markdown sent. Slide count: N. View at http://host:port" (if not already opened).
        *   The React application (in the browser or its display window) updates to show the rendered slides from the current buffer.
        *   On failure: "Error rendering markdown: [details]."

3.  **Navigating Slides**:
    *   While the presentation is active, the user can navigate slides using:
        *   `:MarkdownSlidesNext` or `<Leader>mn` (Next Slide)
        *   `:MarkdownSlidesPrev` or `<Leader>mb` (Previous Slide)
        *   (Potentially other commands like `:MarkdownSlidesGoto N`)
    *   **Action**: These commands send navigation RPC messages to the React server.
    *   **Feedback**:
        *   "Next slide command sent." (or similar minimal confirmation)
        *   The React application updates its view to the corresponding slide.
        *   Optionally, the plugin could receive `slideChanged` notifications from the server and display: "Slide: X/Y. Notes: [current slide's notes if available]" via `vim.notify()`. This makes Neovim aware of the current slide state.

4.  **Editing and Re-Presenting**:
    *   The user can edit the markdown file in Neovim.
    *   To update the presentation, they would re-run `:MarkdownSlidesPresent` or use the mapping.
    *   **Future Enhancement**: Implement an autocommand on `BufWritePost` for markdown files to automatically re-present the content after saving, if the presentation server is active for that buffer/file. This should be configurable.

5.  **Stopping the Presentation Server**:
    *   When done, the user runs `:MarkdownSlidesStop` or uses the `<Leader>mq` mapping.
    *   **Action**: The plugin sends a shutdown signal/message to the Node.js server and terminates the job.
    *   **Feedback**:
        *   "Stopping Markdown Slides server..."
        *   "Markdown Slides server stopped."
    *   The browser window showing the slides will likely no longer be active or will show a disconnected state.

## Feedback Mechanisms

*   **`vim.notify()`**: Most feedback (status updates, errors, server messages) will be displayed using Neovim's notification system. This is non-intrusive.
*   **Status Line (Optional Enhancement)**: For more persistent status (e.g., "MarkdownSlides: Active [file.md] - Slide 3/10"), integration with the status line could be considered. This is more advanced and would require compatibility with status line plugins or Neovim's default status line.
*   **Log Messages**: More verbose logging (debug information) can be written to a dedicated log file or viewed using Neovim's logging capabilities for troubleshooting.

## What the User Sees/Gets

*   **Primary Output**: The rendered slides will appear in a web browser window controlled by the React shared library. The plugin's job is to feed this library and control it.
*   **Neovim Interface**: Neovim remains the control center for starting, stopping, sending content, and navigating.
*   **Ease of Use**: The goal is to make the process of presenting markdown slides feel like an integrated part of the Neovim workflow, minimizing the need to manually manage external processes or switch contexts excessively.

## Configuration Options (To be detailed in `06-plugin-documentation.md`)

The user experience will be enhanced by configuration options, such as:
*   Path to the Node.js server script.
*   Default port for the presentation server.
*   Whether to automatically open the browser.
*   Whether to automatically re-present on save.
*   Customizable leader keys for mappings (handled by Neovim's `<Leader>`).

This workflow aims to be intuitive for Neovim users, leveraging familiar command and mapping patterns while providing clear feedback.
```
