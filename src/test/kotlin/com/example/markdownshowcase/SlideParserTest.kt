package com.example.markdownshowcase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlideParserTest {

    @Test
    fun `parse handles null input`() {
        val slides = SlideParser.parse(null)
        assertTrue(slides.isEmpty())
    }

    @Test
    fun `parse handles empty string input`() {
        val slides = SlideParser.parse("")
        assertTrue(slides.isEmpty())
    }

    @Test
    fun `parse handles blank string input`() {
        val slides = SlideParser.parse("   \n  ")
        assertTrue(slides.isEmpty())
    }

    @Test
    fun `parse single slide without delimiter`() {
        val content = "# Slide 1\nContent"
        val slides = SlideParser.parse(content)
        assertEquals(1, slides.size)
        assertEquals("# Slide 1\nContent", slides[0])
    }

    @Test
    fun `parse multiple slides with delimiter`() {
        val content = """
            # Slide 1
            Content 1
            :::slide
            # Slide 2
            Content 2
            :::slide
            # Slide 3
        """.trimIndent()
        val slides = SlideParser.parse(content)
        assertEquals(3, slides.size)
        assertEquals("# Slide 1\nContent 1", slides[0])
        assertEquals("# Slide 2\nContent 2", slides[1])
        assertEquals("# Slide 3", slides[2])
    }

    @Test
    fun `parse slides with leading and trailing delimiters`() {
        val content = """
            :::slide
            # Slide 1
            :::slide
            # Slide 2
            :::slide
        """.trimIndent()
        val slides = SlideParser.parse(content)
        assertEquals(2, slides.size)
        assertEquals("# Slide 1", slides[0])
        assertEquals("# Slide 2", slides[1])
    }

    @Test
    fun `parse handles extra whitespace around delimiters`() {
        val content = "# Slide 1  \n  :::slide   \n# Slide 2"
        val slides = SlideParser.parse(content)
        assertEquals(2, slides.size)
        assertEquals("# Slide 1", slides[0])
        assertEquals("# Slide 2", slides[1])
    }

    @Test
    fun `parse handles empty slides between delimiters`() {
        val content = """
            # Slide 1
            :::slide
            :::slide
            # Slide 2
        """.trimIndent()
        val slides = SlideParser.parse(content)
        assertEquals(2, slides.size)
        assertEquals("# Slide 1", slides[0])
        assertEquals("# Slide 2", slides[1])
    }

    @Test
    fun `parse content from vscode-tutorials BasicExample`() {
        val content = """
:::slide
# Welcome to PrincipleMD

This is a test slide for the VSCode extension.

- Feature 1: Markdown slides
- Feature 2: Mermaid diagrams
- Feature 3: Theme switching

:::slide
# Mermaid Diagram Example
```mermaid
flowchart TD
    AppState((App State))
    LandingPage --reads/writes--> AppState
    ResizableDeck --reads/writes--> AppState
```

:::slide
# Final Slide

Thank you for testing!

Press `Ctrl+Shift+V` to open the preview.
        """.trimIndent()
        val slides = SlideParser.parse(content)
        assertEquals(3, slides.size)
        assertEquals("""
# Welcome to PrincipleMD

This is a test slide for the VSCode extension.

- Feature 1: Markdown slides
- Feature 2: Mermaid diagrams
- Feature 3: Theme switching
        """.trimIndent().trim(), slides[0])
        assertEquals("""
# Mermaid Diagram Example
```mermaid
flowchart TD
    AppState((App State))
    LandingPage --reads/writes--> AppState
    ResizableDeck --reads/writes--> AppState
```
        """.trimIndent().trim(), slides[1])
        assertEquals("""
# Final Slide

Thank you for testing!

Press `Ctrl+Shift+V` to open the preview.
        """.trimIndent().trim(), slides[2])
    }
}
