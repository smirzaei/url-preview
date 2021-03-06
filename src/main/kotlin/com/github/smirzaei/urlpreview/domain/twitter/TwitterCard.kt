package com.github.smirzaei.urlpreview.domain.twitter

import com.github.smirzaei.urlpreview.domain.LinkUrlPreview
import com.github.smirzaei.urlpreview.domain.UrlPreview
import com.github.smirzaei.urlpreview.domain.UrlPreviewMappable
import com.github.smirzaei.urlpreview.domain.VideoUrlPreview

sealed class TwitterCard : UrlPreviewMappable {
    abstract val card: TwitterCardType
    abstract val site: String?
    abstract val title: String
    abstract val description: String?
}

data class TwitterSummaryCard(
        override val card: TwitterCardType,
        override val site: String?,
        override val title: String,
        override val description: String?,
        val image: String?,
        val imageAlt: String?
) : TwitterCard() {
    override fun toUrlPreview(): UrlPreview {
        return LinkUrlPreview(
                title,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        )
    }
}

data class TwitterPlayerCard(
        override val card: TwitterCardType = TwitterCardType.PLAYER,
        override val site: String?,
        override val title: String,
        override val description: String?,
        val player: String,
        val playerWidth: Int,
        val playerHeight: Int,
        val image: String,
        val imageAlt: String?,
        val playerStream: String?,
        val playerStreamContentType: String?
) : TwitterCard() {
    override fun toUrlPreview(): UrlPreview {
        return VideoUrlPreview(
                title,
                null,
                null,
                null,
                null,
                null,
                image,
                null,
                null,
                player,
                playerWidth,
                playerHeight
        )
    }
}

data class TwitterAppCard(
        override val card: TwitterCardType = TwitterCardType.APP,
        override val site: String?,
        override val title: String,
        override val description: String?,
        val iphoneAppId: String,
        val ipadAppId: String,
        val googlePlayAppId: String,
        val iphoneCustomUrlScheme: String?,
        val ipadCustomUrlScheme: String?,
        val googlePlayCustomUrlScheme: String?,
        val appCountry: String?
) : TwitterCard() {
    override fun toUrlPreview(): UrlPreview {
        return LinkUrlPreview(
                title,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        )
    }
}
