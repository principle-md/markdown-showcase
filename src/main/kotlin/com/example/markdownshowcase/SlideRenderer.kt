package com.example.markdownshowcase

import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

object SlideRenderer {

    private val parser = Parser.builder().build()
    private val renderer = HtmlRenderer.builder().build()

    /**
     * Renders a single slide's markdown content into an HTML string.
     *
     * @param markdownSlideContent The markdown content for a single slide.
     * @return HTML representation of the markdown content. Returns an empty string
     *         if the input is null.
     */
    fun renderToHtml(markdownSlideContent: String?): String {
        if (markdownSlideContent == null) {
            return ""
        }
        val document = parser.parse(markdownSlideContent)
        return renderer.render(document)
    }
}
