package com.github.smirzaei.urlpreview.extractors

import com.github.smirzaei.urlpreview.domain.UrlPreviewMappable
import org.jsoup.select.Elements

interface Extractor {
    fun extract(metaTags: Elements): UrlPreviewMappable?
}