package com.zaidkhaled.imagescatalog.data.repositories.imagesRepository

import com.zaidkhaled.imagescatalog.data.daos.ImagesRemoteDao
import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.data.models.wrappers.ListWrapper

class ImagesRepositoryImpl(private val remoteDao: ImagesRemoteDao) : ImagesRepository {
    override suspend fun getImages(
        api_key: String,
        image_type: String,
        pretty: Boolean
    ): ListWrapper<ImageResponse> {
        return remoteDao.getImages(api_key, image_type, pretty)
    }
}