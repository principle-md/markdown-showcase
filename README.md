# Markdown Showcase JetBrains Plugin

The Markdown Showcase plugin allows you to view markdown-based presentations directly within your JetBrains IDE. Slides are defined in a single markdown file, separated by `:::slide` delimiters.

## Features

*   Renders markdown content as slides.
*   Supports basic markdown syntax (headings, lists, code blocks, etc.) via the `commonmark-java` library.
*   Tool window for displaying slides.
*   Navigation controls (Next/Previous slide) in the tool window toolbar.
*   Option to open markdown files via the "Tools" menu.

## Installation

1.  Download the plugin `.zip` file from the [releases page](https://github.com/your-repo/markdown-showcase-jetbrains-plugin/releases) (Note: Replace with actual link when available) or build it manually.
2.  In your JetBrains IDE, go to `Settings/Preferences` > `Plugins`.
3.  Click on the gear icon and choose `Install Plugin from Disk...`.
4.  Select the downloaded `.zip` file.
5.  Restart the IDE if prompted.

Alternatively, this plugin might be available on the JetBrains Marketplace in the future.

## Usage

1.  **Open the Tool Window**: Find the "Markdown Showcase" tool window. You can usually open it from `View` > `Tool Windows` > `Markdown Showcase`.
2.  **Open a Markdown File**:
    *   Go to `Tools` > `Open Markdown Presentation`.
    *   Select a `.md` file that contains your slides (separated by `:::slide`).
3.  **Navigate Slides**:
    *   Use the "Next" and "Previous" arrow buttons on the toolbar within the "Markdown Showcase" tool window to navigate through your slides.
    *   The tool window title will display the name of the opened file and the current slide number (e.g., `MyPresentation.md (1/5)` when opening, and `Slide (x/y)` during navigation).

## Slide Format Example

Create a `.md` file with content like this:

```markdown
:::slide
# Slide 1 Title

This is the content of the first slide.
- Bullet point 1
- Bullet point 2

:::slide
# Slide 2 Title

Content for the second slide.

```
```
