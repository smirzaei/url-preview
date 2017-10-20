package com.github.smirzaei.urlpreview

import com.github.smirzaei.urlpreview.domain.UrlPreview
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class UrlPreviewExtractor {
    fun extractInfo(html: String, baseUrl: String? = null): UrlPreview? {
        val doc = if (baseUrl == null) Jsoup.parse(html) else Jsoup.parse(html, baseUrl)

        val oembedTag = doc.getElementsByTag("link")
                .find { it.hasAttr("alternate") && it.hasAttr("application/json+oembed") }

        if (oembedTag != null) {
            val oembedUrl = oembedTag.attr("href")
            TODO("Send a request to the oembed link and parse its response")
        } else {
            val metaTags = doc.getElementsByTag("meta")
            val extractFunctions = listOf(
                    this::parseOpenGraph,
                    this::parseTwitterCard,
                    this::parseFromMetaTags
            )

            return extractFunctions
                    .map { it(metaTags) }
                    .first { it != null }
        }
    }

    private fun parseOpenGraph(metaTags: Elements): UrlPreview? {
        TODO()
    }

    private fun parseTwitterCard(metaTags: Elements): UrlPreview? {
        TODO()
    }

    private fun parseFromMetaTags(metaTags: Elements): UrlPreview? {
        TODO()
    }
}