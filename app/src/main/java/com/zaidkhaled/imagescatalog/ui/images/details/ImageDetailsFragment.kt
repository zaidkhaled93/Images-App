package com.zaidkhaled.imagescatalog.ui.images.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.databinding.FragmentImageDetailsBinding
import com.zaidkhaled.imagescatalog.ui.base.fragments.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailsFragment : BaseBindingFragment<FragmentImageDetailsBinding>() {

    override val layoutId: Int =
        R.layout.fragment_image_details

    private val args: ImageDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.image = args.passedImage
    }

}