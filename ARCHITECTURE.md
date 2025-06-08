# Markdown Showcase JetBrains Plugin Architecture

This document outlines the architecture of the Markdown Showcase JetBrains plugin. The plugin allows users to view markdown-formatted presentations directly within the IDE.

## Core Goals

*   Display markdown slides, where slides are separated by `:::slide`.
*   Provide basic navigation (next/previous slide).
*   Integrate smoothly into the JetBrains IDE environment.

## High-Level Design

The plugin is built around JetBrains' extension points and utilizes JCEF (Java Chromium Embedded Framework) for rendering HTML content.

Key parts:
1.  **Tool Window**: A custom tool window titled "Markdown Showcase" serves as the main UI for displaying slides.
2.  **Markdown Parsing**: Logic to take a `.md` file and split its content into individual slides.
3.  **HTML Rendering**: Logic to convert each slide's markdown content into HTML.
4.  **JCEF Browser**: An embedded Chromium browser instance within the tool window to display the rendered HTML.
5.  **Actions**: Standard JetBrains actions for opening files and navigating slides.

## Detailed Components

### 1. Plugin Configuration (`plugin.xml`)

*   Located in `src/main/resources/META-INF/plugin.xml`.
*   **Responsibilities**:
    *   Declares the plugin's ID, name, version, and vendor details.
    *   Specifies dependencies (e.g., `com.intellij.modules.platform`, `org.jetbrains.kotlin`).
    *   Registers core plugin components using extension points:
        *   `com.intellij.toolWindow`: Registers the `Markdown Showcase` tool window, specifying its ID, anchor, icon, and the factory class (`MarkdownShowcaseToolWindowFactory`).
        *   `com.intellij.action`: Registers user actions:
            *   `MarkdownShowcase.OpenFile`: Allows users to select a markdown file. Added to the "Tools" menu.
            *   `MarkdownShowcase.NextSlide`: Navigates to the next slide.
            *   `MarkdownShowcase.PreviousSlide`: Navigates to the previous slide.

### 2. Tool Window (`MarkdownShowcaseToolWindowFactory.kt`)

*   Class: `com.example.markdownshowcase.MarkdownShowcaseToolWindowFactory` implements `com.intellij.openapi.wm.ToolWindowFactory`.
*   **Responsibilities**:
    *   **UI Initialization**: The `createToolWindowContent` method sets up the tool window's UI.
    *   **JCEF Support Check**: Verifies if JCEF is available. If not, it displays a message to the user.
    *   **Browser Creation**: Instantiates a `JBCefBrowser` component, which is the embedded web browser.
    *   **UI Layout**: Uses a `SimpleToolWindowPanel` to hold the JCEF browser component and a toolbar for navigation actions.
    *   **Toolbar Setup**: Creates an `ActionToolbar` and populates it with the `NextSlideAction` and `PreviousSlideAction`.
    *   **Initial Content**: Loads a welcome message into the browser on startup.
    *   **State Management (via Project UserData)**: Stores references to the `JBCefBrowser` instance, the list of parsed slides, the current slide index, and the `ToolWindow` itself in the `Project`'s UserData store using keys defined in `MarkdownShowcaseKeys.kt`. This allows actions to access and modify the presentation state.

### 3. Markdown Parsing (`SlideParser.kt`)

*   Object: `com.example.markdownshowcase.SlideParser`.
*   **Responsibilities**:
    *   Defines a `parse(markdownContent: String?): List<String>` method.
    *   Takes the entire content of a markdown file as a string.
    *   Splits the content by the delimiter `:::slide`.
    *   Trims whitespace from each resulting slide's content.
    *   Filters out any empty slides that might result from consecutive delimiters or delimiters at the start/end of the file.
    *   Returns a `List<String>` where each string is the raw markdown content of a single slide.

### 4. Markdown to HTML Rendering (`SlideRenderer.kt`)

*   Object: `com.example.markdownshowcase.SlideRenderer`.
*   **Dependencies**: Uses the `org.commonmark:commonmark` library for robust markdown-to-HTML conversion.
*   **Responsibilities**:
    *   Defines a `renderToHtml(markdownSlideContent: String?): String` method.
    *   Takes the raw markdown content of a single slide.
    *   Uses `commonmark`'s `Parser` to parse the markdown and `HtmlRenderer` to render it into an HTML string.
    *   Returns the generated HTML string.

### 5. Actions

Located in the `com.example.markdownshowcase.actions` package. All actions extend `com.intellij.openapi.actionSystem.AnAction`.

*   **`OpenMarkdownFileAction.kt`**:
    *   Triggered from the "Tools" menu.
    *   Uses `FileChooser` to let the user select a `.md` file.
    *   Reads the file content.
    *   Uses `SlideParser` to get the list of slides.
    *   If slides are found:
        *   Updates the `Project` UserData with the new slide list and resets the current index to 0.
        *   Ensures the "Markdown Showcase" tool window is visible.
        *   Uses `SlideRenderer` to convert the first slide to HTML.
        *   Loads the HTML into the `JBCefBrowser`.
        *   Updates the tool window title with the filename and slide count.
    *   If no slides are found, it shows an information message.
*   **`NextSlideAction.kt`**: (Implements `DumbAware`)
    *   Triggered from the tool window toolbar.
    *   Retrieves the current slide list and index from `Project` UserData.
    *   If not on the last slide, increments the index.
    *   Renders the new current slide to HTML and loads it into the browser.
    *   Updates the tool window title (e.g., "Slide (2/3)").
    *   The `update` method enables/disables the action based on whether a next slide exists.
*   **`PreviousSlideAction.kt`**: (Implements `DumbAware`)
    *   Triggered from the tool window toolbar.
    *   Similar to `NextSlideAction`, but decrements the index to show the previous slide.
    *   The `update` method enables/disables the action based on whether a previous slide exists.

### 6. State Management (`MarkdownShowcaseKeys.kt`)

*   Object: `com.example.markdownshowcase.MarkdownShowcaseKeys`.
*   Defines `com.intellij.openapi.util.Key` constants for storing and retrieving shared data within the `Project.UserDataHolder`.
*   This is a lightweight way to share state (like the browser instance, current slides, and index) between the `ToolWindowFactory` (which initializes the state) and the various `AnAction` implementations (which read/modify the state).

## Workflow Example: Opening and Viewing Slides

1.  User clicks "Tools" -> "Open Markdown Presentation".
2.  `OpenMarkdownFileAction` prompts for a file.
3.  User selects `my_slides.md`.
4.  Action reads file, `SlideParser` splits it into slides `s1, s2, s3`.
5.  Action stores `[s1, s2, s3]` and current index `0` in `Project` UserData.
6.  Action gets `JBCefBrowser` from `Project` UserData (initialized by `ToolWindowFactory`).
7.  `SlideRenderer` converts `s1` to HTML.
8.  HTML is loaded into `JBCefBrowser`.
9.  Tool window title becomes "my_slides.md (1/3)". Toolbar updates (Next enabled, Prev disabled).
10. User clicks "Next" button.
11. `NextSlideAction` increments current index to `1`.
12. `SlideRenderer` converts `s2` to HTML, which is loaded into the browser.
13. Title changes to "Slide (2/3)". Toolbar updates (Next/Prev enabled).

## Future Considerations / Potential Improvements

*   **Enhanced Styling**: Apply custom CSS to the rendered HTML for better visual presentation.
*   **Mermaid Diagram Support**: Investigate integrating Mermaid.js or a similar library within the JCEF view to render diagrams.
*   **Theme Sync**: Attempt to synchronize slide appearance with the current IDE theme.
*   **Error Handling**: More robust error handling and user feedback for various scenarios.
*   **State Persistence**: For more complex state, consider using `com.intellij.openapi.components.PersistentStateComponent` if the state needs to persist across IDE restarts (not critical for current MVP).
*   **Code Quality**: Refactor UserData access into a dedicated service for better organization if complexity grows.
