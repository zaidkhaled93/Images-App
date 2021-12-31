package com.zaidkhaled.imagescatalog.data.models.wrappers

import com.squareup.moshi.Json

data class ListWrapper<M>(
    @Json(name = "hits")
    val hits: List<M>?,
    @Json(name = "totalHits")
    val totalHits: Int?,
    @Json(name = "total")
    val total: Int?
)
