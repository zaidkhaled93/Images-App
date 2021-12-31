package com.zaidkhaled.imagescatalog.data.repositories.imagesRepository

import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.data.models.wrappers.ListWrapper

interface ImagesRepository {

    suspend fun getImages(
        api_key: String,
        image_type: String,
        pretty: Boolean
    ): ListWrapper<ImageResponse>
}