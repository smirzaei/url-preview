package com.github.smirzaei.urlpreview.extractors

import com.github.smirzaei.urlpreview.domain.UrlPreview

interface Extractor {
    fun extract(html: String): UrlPreview
}