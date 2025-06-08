package com.example.markdownshowcase

object SlideParser {

    private const val SLIDE_DELIMITER = ":::slide"

    /**
     * Parses the given markdown content into a list of individual slide strings.
     *
     * @param markdownContent The complete markdown content of a presentation.
     * @return A list of strings, where each string is the raw content of a slide.
     *         Returns an empty list if the input is null or blank.
     *         Slides are separated by ":::slide". Leading/trailing whitespace
     *         from each slide's content (after splitting) will be trimmed.
     *         Empty slides (resulting from consecutive delimiters or delimiters
     *         at the start/end after trimming) will be filtered out.
     */
    fun parse(markdownContent: String?): List<String> {
        if (markdownContent.isNullOrBlank()) {
            return emptyList()
        }

        return markdownContent
            .split(SLIDE_DELIMITER)
            .map { it.trim() } // Trim whitespace from each potential slide
            .filter { it.isNotEmpty() } // Remove empty slides
    }
}
