package com.zaidkhaled.imagescatalog.ui.authentication.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.databinding.FragmentRegisterBinding
import com.zaidkhaled.imagescatalog.extensions.isValidEmail
import com.zaidkhaled.imagescatalog.extensions.isValidPassword
import com.zaidkhaled.imagescatalog.ui.authentication.viewModel.AuthenticationViewModel
import com.zaidkhaled.imagescatalog.ui.base.fragments.BaseBindingFragment
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