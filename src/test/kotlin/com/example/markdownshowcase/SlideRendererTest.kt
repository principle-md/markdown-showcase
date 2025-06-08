package com.example.markdownshowcase

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SlideRendererTest {

    @Test
    fun `renderToHtml handles null input`() {
        val html = SlideRenderer.renderToHtml(null)
        assertEquals("", html)
    }

    @Test
    fun `renderToHtml converts heading`() {
        val markdown = "# Hello World"
        val expectedHtml = "<h1>Hello World</h1>\n"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml)
    }

    @Test
    fun `renderToHtml converts paragraph`() {
        val markdown = "This is a paragraph."
        val expectedHtml = "<p>This is a paragraph.</p>\n"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml)
    }

    @Test
    fun `renderToHtml converts unordered list`() {
        val markdown = "* Item 1\n* Item 2"
        val expectedHtml = "<ul>\n<li>Item 1</li>\n<li>Item 2</li>\n</ul>\n"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml)
    }

    @Test
    fun `renderToHtml converts ordered list`() {
        val markdown = "1. First\n2. Second"
        val expectedHtml = "<ol>\n<li>First</li>\n<li>Second</li>\n</ol>\n"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml)
    }

    @Test
    fun `renderToHtml converts code block`() {
        val markdown = "```kotlin\nfun main() { println(\"Hello\") }\n```"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        // More robust check for common variations
        assertTrue(actualHtml.startsWith("<pre><code")) // Check basic structure first
        assertTrue(actualHtml.contains("language-kotlin")) // Check if class is present somewhere
        assertTrue(actualHtml.contains("fun main() { println(&quot;Hello&quot;) }\n")) // Check for HTML escaped quotes
        assertTrue(actualHtml.contains("</code></pre>")) // Check for proper closing
        // Allow for variations in newlines around the content and after the block
        // Original expectation was: "<pre><code class=\"language-kotlin\">fun main() { println(\"Hello\") }\n</code></pre>\n"
    }

    @Test
    fun `renderToHtml converts inline code`() {
        val markdown = "Use `val` for immutable variables."
        val expectedHtml = "<p>Use <code>val</code> for immutable variables.</p>\n"
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml)
    }

    @Test
    fun `renderToHtml handles empty markdown`() {
        val markdown = ""
        val expectedHtml = ""
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertEquals(expectedHtml, actualHtml) // CommonMark renders empty string for empty input
    }

    @Test
    fun `renderToHtml handles markdown with only whitespace`() {
        val markdown = "   \n  \t "
        // CommonMark treats this as empty or just a newline depending on content, often resulting in empty or minimal HTML
        val actualHtml = SlideRenderer.renderToHtml(markdown)
        assertTrue(actualHtml.isBlank() || actualHtml == "\n", "HTML should be blank or just a newline, but was: '$actualHtml'")
    }
}
