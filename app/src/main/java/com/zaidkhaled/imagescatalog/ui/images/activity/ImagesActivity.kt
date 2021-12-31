package com.zaidkhaled.imagescatalog.ui.images.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.databinding.ActivityImagesBinding
import com.zaidkhaled.imagescatalog.ui.base.activities.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_images.*

@AndroidEntryPoint
class ImagesActivity : BaseBindingActivity<ActivityImagesBinding>() {
    override val layoutId: Int = R.layout.activity_images

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpNavigationGraph()
    }

    //set up the container activity navigation graph
    private fun setUpNavigationGraph() {
        val navHostFragment = images_nav_host_fragment as NavHostFragment
        navController = navHostFragment.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.images_nav_graph)
        navHostFragment.navController.graph = graph
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    companion object {
        fun start(context: Context?) {
            val intent = Intent(context, ImagesActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context?.startActivity(intent)
        }
    }
}