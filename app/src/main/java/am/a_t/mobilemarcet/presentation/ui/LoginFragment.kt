package am.a_t.mobilemarcet.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import am.a_t.mobilemarcet.R
import am.a_t.mobilemarcet.databinding.FragmentLoginBinding
import am.a_t.mobilemarcet.extension.toast
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.presentation.viewModel.MyViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        initViewModel()
        initClickListeners()

        return binding.root
    }

    private fun initClickListeners() {
        binding.btnLogin.setOnClickListener {
            viewModel.login(
                Login(
                    binding.edName.text.toString(),
                    binding.edPassword.text.toString()
                )
            )
        }
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            viewModel.userLiveData.collect {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }

        lifecycleScope.launch {
            viewModel.errorLiveData.collect {
                requireContext().toast(it)
            }
        }
        
    }

}