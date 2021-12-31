package com.zaidkhaled.imagescatalog.ui.images.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.common.enums.Status
import com.zaidkhaled.imagescatalog.data.models.responses.ImageResponse
import com.zaidkhaled.imagescatalog.databinding.FragmentImagesHomeBinding
import com.zaidkhaled.imagescatalog.extensions.hide
import com.zaidkhaled.imagescatalog.extensions.show
import com.zaidkhaled.imagescatalog.ui.base.adapter.OnItemClickListener
import com.zaidkhaled.imagescatalog.ui.base.fragments.BaseBindingFragment
import com.zaidkhaled.imagescatalog.ui.images.viewModel.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_images_home.*
import javax.inject.Inject


@AndroidEntryPoint
class ImagesHomeFragment : BaseBindingFragment<FragmentImagesHomeBinding>() {

    override val layoutId: Int =
        R.layout.fragment_images_home

    @Inject
    lateinit var imagesAdapter: ImagesAdapter

    private val viewModel: ImagesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        setAdapters()
    }

    override fun onViewVisible(view: View) {
        super.onViewVisible(view)
        viewModel.loadImagesApi().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding?.progressBar.hide()
                    }
                    Status.ERROR, Status.CUSTOM_ERROR -> {
                        binding?.progressBar.hide()
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> {
                        binding?.progressBar.show()
                    }
                }
            }
        })
    }

    private fun setAdapters() {
        //configure popular image adapter
        imagesAdapter.setOnItemClickListener(object : OnItemClickListener<ImageResponse?> {
            override fun onItemClicked(
                view: View?,
                parentView: View?,
                item: ImageResponse?,
                position: Int
            ) {
                handleImageItemClick(item)
            }
        })
        rv_images.adapter = imagesAdapter
    }

    private fun handleImageItemClick(image: ImageResponse?) {
        //open image details from clicked item
        findNavController().navigate(
            R.id.openImageDetailsFragment,
            bundleOf("passedImage" to image)
        )
    }

}