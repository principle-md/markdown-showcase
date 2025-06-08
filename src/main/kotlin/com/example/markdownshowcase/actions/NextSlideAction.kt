package com.example.markdownshowcase.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware // Make actions available during indexing
import com.example.markdownshowcase.MarkdownShowcaseKeys
import com.example.markdownshowcase.SlideRenderer
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.vfs.VirtualFile

class NextSlideAction : AnAction(), DumbAware {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val browser = project.getUserData(MarkdownShowcaseKeys.BROWSER_KEY)
        var slides = project.getUserData(MarkdownShowcaseKeys.SLIDES_KEY)
        var currentIndex = project.getUserData(MarkdownShowcaseKeys.CURRENT_SLIDE_INDEX_KEY)
        val toolWindow = project.getUserData(MarkdownShowcaseKeys.TOOL_WINDOW_KEY)

        if (browser == null || slides == null || currentIndex == null || toolWindow == null) return

        if (currentIndex < slides.size - 1) {
            currentIndex++
            project.putUserData(MarkdownShowcaseKeys.CURRENT_SLIDE_INDEX_KEY, currentIndex)
            val slideHtml = SlideRenderer.renderToHtml(slides[currentIndex])
            ApplicationManager.getApplication().invokeLater {
                browser.loadHTML(slideHtml)
                // Assuming filename was stored somewhere or can be retrieved if needed for title
                toolWindow.setTitle("Slide (${currentIndex + 1}/${slides.size})")
            }
        }
    }

    override fun update(e: AnActionEvent) {
        val project = e.project
        val slides = project?.getUserData(MarkdownShowcaseKeys.SLIDES_KEY)
        val currentIndex = project?.getUserData(MarkdownShowcaseKeys.CURRENT_SLIDE_INDEX_KEY)
        e.presentation.isEnabled = project != null && slides != null && currentIndex != null && currentIndex < slides.size - 1
    }
}
