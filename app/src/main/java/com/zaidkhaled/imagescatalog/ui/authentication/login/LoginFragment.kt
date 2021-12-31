package com.zaidkhaled.imagescatalog.ui.authentication.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaidkhaled.imagescatalog.BuildConfig
import com.zaidkhaled.imagescatalog.R
import com.zaidkhaled.imagescatalog.databinding.FragmentLoginBinding
import com.zaidkhaled.imagescatalog.extensions.isValidEmail
import com.zaidkhaled.imagescatalog.extensions.isValidPassword
import com.zaidkhaled.imagescatalog.ui.authentication.viewModel.AuthenticationViewModel
import com.zaidkhaled.imagescatalog.ui.base.fragments.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseBindingFragment<FragmentLoginBinding>() {

    override val layoutId: Int =
        R.layout.fragment_login

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
        viewModel.loginUsername.value = "test@gmail.com"
        viewModel.loginPassword.value = "123456"
    }

    private fun validateInput() {
        if (!(viewModel.loginUsername.value ?: "").isValidEmail()) {
            binding?.tlUsername?.isErrorEnabled = true
            binding?.tlUsername?.error = getString(R.string.enter_valid_email)
            return
        }
        binding?.tlUsername?.isErrorEnabled = false
        if (!(viewModel.loginPassword.value ?: "").isValidPassword()) {
            binding?.tlPassword?.isErrorEnabled = true
            binding?.tlPassword?.error = getString(R.string.invalid_password)
            return
        }
        binding?.tlPassword?.isErrorEnabled = false
    }

    private fun setUpListeners() {
        binding?.tvRegister?.setOnClickListener {
            findNavController().navigate(R.id.openRegisterFragment)
        }
        binding?.btnLogin?.setOnClickListener {
            validateInput()
        }
    }
}