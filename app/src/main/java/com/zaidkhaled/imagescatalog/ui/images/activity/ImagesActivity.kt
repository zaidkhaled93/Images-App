package com.zaidkhaled.imagescatalog.ui.images.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.databinding.ActivityImagesBinding
import com.zaidkhaled.imagescatalog.ui.base.activities.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_authentication.*

@AndroidEntryPoint
class ImagesActivity : BaseBindingActivity<ActivityImagesBinding>() {
    override val layoutId: Int = R.layout.activity_images

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpNavigationGraph()
    }

    //set up the container activity navigation graph
    private fun setUpNavigationGraph() {
        val navHostFragment = auth_nav_host_fragment as NavHostFragment
        navController = navHostFragment.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.images_nav_graph)

        navHostFragment.navController.graph = graph
    }
}