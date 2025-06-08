package com.example.markdownshowcase

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.ui.content.ContentFactory
import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JLabel
import javax.swing.JButton
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.DefaultActionGroup

class MarkdownShowcaseToolWindowFactory : ToolWindowFactory {

    private var jbCefBrowser: JBCefBrowser? = null
    private var slides: List<String> = emptyList()
    private var currentSlideIndex = -1

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        if (!JBCefApp.isSupported()) {
            val panel = JPanel()
            panel.add(JLabel("JCEF browser is not supported in this environment."))
            val content = ContentFactory.getInstance().createContent(panel, "", false)
            toolWindow.contentManager.addContent(content)
            return
        }

        jbCefBrowser = JBCefBrowser()
        val browserComponent = jbCefBrowser!!.component

        val panel = SimpleToolWindowPanel(true, true)
        panel.setContent(browserComponent)

        // Placeholder: Load initial content or a welcome message
        loadSlideContent("<h1>Welcome to Markdown Showcase</h1><p>Open a file to begin.</p>")

        // Add toolbar for actions
        val actionManager = ActionManager.getInstance()
        val actionGroup = DefaultActionGroup()

        // These actions will be created later. For now, they are just placeholders.
        val openFileAction = actionManager.getAction("MarkdownShowcase.OpenFile") // This can also be added to toolbar if desired
        val nextSlideAction = actionManager.getAction("MarkdownShowcase.NextSlide")
        val prevSlideAction = actionManager.getAction("MarkdownShowcase.PreviousSlide")

        // if (openFileAction != null) actionGroup.add(openFileAction) // Decide if Open is needed in toolbar vs menu only
        if (prevSlideAction != null) actionGroup.add(prevSlideAction)
        if (nextSlideAction != null) actionGroup.add(nextSlideAction)

        val toolbar = actionManager.createActionToolbar("MarkdownShowcaseToolbar", actionGroup, true)
        toolbar.targetComponent = panel // Important for context
        panel.setToolbar(toolbar.component)

        val content = ContentFactory.getInstance().createContent(panel, "", false)
        toolWindow.contentManager.addContent(content)

        // Store references or make them available to actions
        // This is a simplified way; for more complex scenarios, consider Project services or other mechanisms
        project.putUserData(MarkdownShowcaseKeys.BROWSER_KEY, jbCefBrowser)
        project.putUserData(MarkdownShowcaseKeys.SLIDES_KEY, slides)
        project.putUserData(MarkdownShowcaseKeys.CURRENT_SLIDE_INDEX_KEY, currentSlideIndex)
        project.putUserData(MarkdownShowcaseKeys.TOOL_WINDOW_KEY, toolWindow) // To update title or actions
    }

    private fun loadSlideContent(htmlContent: String) {
        jbCefBrowser?.loadHTML(htmlContent)
    }
}
