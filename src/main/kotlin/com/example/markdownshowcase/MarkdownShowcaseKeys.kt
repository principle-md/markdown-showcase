package com.example.markdownshowcase

import com.intellij.openapi.util.Key
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.jcef.JBCefBrowser

object MarkdownShowcaseKeys {
    val BROWSER_KEY: Key<JBCefBrowser> = Key.create("MarkdownShowcase.Browser")
    val SLIDES_KEY: Key<List<String>> = Key.create("MarkdownShowcase.Slides")
    val CURRENT_SLIDE_INDEX_KEY: Key<Int> = Key.create("MarkdownShowcase.CurrentSlideIndex")
    val TOOL_WINDOW_KEY: Key<ToolWindow> = Key.create("MarkdownShowcase.ToolWindow")
}
