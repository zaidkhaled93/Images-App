package com.zaidkhaled.imagescatalog.ui.images.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.zaidkhaled.imagescatalog.common.constants.NetworkConstants
import com.zaidkhaled.imagescatalog.common.enums.ImageTypeEnum
import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.data.models.wrappers.Resource
import com.zaidkhaled.imagescatalog.data.repositories.imagesRepository.ImagesRepository
import com.zaidkhaled.imagescatalog.ui.base.lifeCycle.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val imagesRepo: ImagesRepository,
) : BaseViewModel() {

    val images: MutableLiveData<List<ImageResponse>> by lazy { MutableLiveData<List<ImageResponse>>() }

    //get images list from pixabay remote api
    fun loadImagesApi() = liveData {
        emit(Resource.loading(data = null))
        try {
            val response =
                imagesRepo.getImages(NetworkConstants.API_KEY, ImageTypeEnum.Photo.value, true)

            if (response.hits != null) {
                images.postValue(response.hits)
                emit(Resource.success(data = response))
            } else {
                //Handle errors here depending on server response, for example 400, 401, 403...etc
                emit(
                    Resource.customError(
                        data = null,
                        message = "No results found!",
                        code = 400
                    )
                )
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}