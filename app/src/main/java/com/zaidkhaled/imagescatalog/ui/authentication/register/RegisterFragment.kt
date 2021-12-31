package com.zaidkhaled.imagescatalog.ui.authentication.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaidkhaled.imagescatalog.BuildConfig
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.common.enums.Status
import com.zaidkhaled.imagescatalog.databinding.FragmentRegisterBinding
import com.zaidkhaled.imagescatalog.extensions.*
import com.zaidkhaled.imagescatalog.ui.authentication.viewModel.AuthenticationViewModel
import com.zaidkhaled.imagescatalog.ui.base.fragments.BaseBindingFragment
import com.zaidkhaled.imagescatalog.ui.images.activity.ImagesActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseBindingFragment<FragmentRegisterBinding>() {

    override val layoutId: Int =
        R.layout.fragment_register

    private val viewModel: AuthenticationViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel

        setUpListeners()

        if (BuildConfig.DEBUG) {
            setUpTestingData()
        }
    }

    private fun setUpTestingData() {
        viewModel.registerUsername.value = "test@gmail.com"
        viewModel.registerAge.value = "25"
        viewModel.registerPassword.value = "123456"
    }

    private fun validateInput() {
        if (!(viewModel.registerUsername.value ?: "").isValidEmail()) {
            binding?.tlUsername?.isErrorEnabled = true
            binding?.tlUsername?.error = getString(R.string.enter_valid_email)
            return
        }
        binding?.tlUsername?.isErrorEnabled = false
        if (!(viewModel.registerPassword.value ?: "").isValidPassword()) {
            binding?.tlPassword?.isErrorEnabled = true
            binding?.tlPassword?.error = getString(R.string.invalid_password)
            return
        }
        binding?.tlPassword?.isErrorEnabled = false

        if (!(viewModel.registerAge.value ?: "").isValidAge()) {
            binding?.tlAge?.isErrorEnabled = true
            binding?.tlAge?.error = getString(R.string.invalid_age)
            return
        }
        binding?.tlAge?.isErrorEnabled = false

        //validation complete, register user
       registerUser()
    }

    private fun registerUser() {
        viewModel.register().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding?.progressBar.hide()
                        ImagesActivity.start(context)
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

    private fun setUpListeners() {
        binding?.tvLogin?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.btnRegister?.setOnClickListener {
            validateInput()
        }
    }

}