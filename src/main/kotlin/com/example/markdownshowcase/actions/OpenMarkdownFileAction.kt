package com.example.markdownshowcase.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages
import com.example.markdownshowcase.MarkdownShowcaseKeys
import com.example.markdownshowcase.SlideParser
import com.example.markdownshowcase.SlideRenderer
import java.io.IOException
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.wm.ToolWindowManager

class OpenMarkdownFileAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return

        val descriptor = FileChooserDescriptor(true, false, false, false, false, false)
            .withTitle("Select Markdown File")
            .withFileFilter { it.extension == "md" }
        val file = FileChooser.chooseFile(descriptor, project, null)

        if (file == null) {
            return
        }

        try {
            val markdownContent = String(file.contentsToByteArray())
            val slides = SlideParser.parse(markdownContent)

            if (slides.isEmpty()) {
                Messages.showInfoMessage(project, "No slides found in the selected file.", "Markdown Showcase")
                return
            }

            project.putUserData(MarkdownShowcaseKeys.SLIDES_KEY, slides)
            project.putUserData(MarkdownShowcaseKeys.CURRENT_SLIDE_INDEX_KEY, 0)

            val browser = project.getUserData(MarkdownShowcaseKeys.BROWSER_KEY)
            val toolWindow = project.getUserData(MarkdownShowcaseKeys.TOOL_WINDOW_KEY)

            // Ensure tool window is visible
            ToolWindowManager.getInstance(project).getToolWindow("Markdown Showcase")?.show {}

            if (browser != null) {
                val firstSlideHtml = SlideRenderer.renderToHtml(slides[0])
                // JCEF operations should be on UI thread if they modify UI components directly
                // loadHTML is generally safe but good practice for more complex interactions.
                ApplicationManager.getApplication().invokeLater {
                    browser.loadHTML(firstSlideHtml)
                    toolWindow?.setTitle("${file.name} (1/${slides.size})")
                }
            } else {
                Messages.showErrorDialog(project, "Browser component not available.", "Error")
            }

        } catch (ex: IOException) {
            Messages.showErrorDialog(project, "Error reading file: ${ex.message}", "File Error")
        }
    }
}
