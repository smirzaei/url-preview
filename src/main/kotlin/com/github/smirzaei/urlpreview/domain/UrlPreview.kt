package com.github.smirzaei.urlpreview.domain

// https://oembed.com/

sealed class UrlPreview {
    abstract val type: OEmbedType
    abstract val title: String?
    abstract val authorName: String?
    abstract val authorUrl: String?
    abstract val providerName: String?
    abstract val providerUrl: String?
    abstract val cacheAge: Int?
    abstract val thumbnailUrl: String?
    abstract val thumbnailWidth: String?
    abstract val thumbnailHeight: String?
}

data class PhotoUrlPreview(
        override val title: String?,
        override val authorName: String?,
        override val authorUrl: String?,
        override val providerName: String?,
        override val providerUrl: String?,
        override val cacheAge: Int?,
        override val thumbnailUrl: String?,
        override val thumbnailWidth: String?,
        override val thumbnailHeight: String?,

        val url: String,
        val width: Int,
        val height: Int
) : UrlPreview() {
    override val type: OEmbedType = OEmbedType.PHOTO
}

data class VideoUrlPreview(
        override val title: String?,
        override val authorName: String?,
        override val authorUrl: String?,
        override val providerName: String?,
        override val providerUrl: String?,
        override val cacheAge: Int?,
        override val thumbnailUrl: String?,
        override val thumbnailWidth: String?,
        override val thumbnailHeight: String?,

        val html: String,
        val width: Int,
        val height: Int
) : UrlPreview() {
    override val type: OEmbedType = OEmbedType.VIDEO
}

data class LinkUrlPreview(
        override val title: String?,
        override val authorName: String?,
        override val authorUrl: String?,
        override val providerName: String?,
        override val providerUrl: String?,
        override val cacheAge: Int?,
        override val thumbnailUrl: String?,
        override val thumbnailWidth: String?,
        override val thumbnailHeight: String?
) : UrlPreview() {
    override val type: OEmbedType = OEmbedType.LINK
}

data class RichUrlPreview(
        override val title: String?,
        override val authorName: String?,
        override val authorUrl: String?,
        override val providerName: String?,
        override val providerUrl: String?,
        override val cacheAge: Int?,
        override val thumbnailUrl: String?,
        override val thumbnailWidth: String?,
        override val thumbnailHeight: String?,

        val html: String,
        val width: Int,
        val height: Int
) : UrlPreview() {
    override val type: OEmbedType = OEmbedType.RICH
}