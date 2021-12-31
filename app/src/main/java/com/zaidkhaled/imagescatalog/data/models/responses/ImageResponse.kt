package com.zaidkhaled.imagescatalog.data.models.responses


data class ImageResponse(
    //image data
    val id: Int?,
    val previewURL: String?,
    val largeImageURL: String?,
    val imageSize: Int?,
    val type: String?,
    val tags: String?,

    //user data
    val user: String?,
    val userImageURL: String?,
    val views: Int?,
    val likes: Int?,
    val comments: Int?,
    val downloads: Int?
)
