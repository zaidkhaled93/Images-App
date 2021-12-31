package com.zaidkhaled.imagescatalog.data.daos

import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.data.models.wrappers.ListWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesRemoteDao {

    @GET(".")
    suspend fun getImages(
        @Query("key") api_key: String,
        @Query("image_type") image_type: String,
        @Query("pretty") pretty: Boolean
    ): ListWrapper<ImageResponse>

}