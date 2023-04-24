package am.a_t.mobilemarcet.presentation.ui

import am.a_t.mobilemarcet.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import am.a_t.mobilemarcet.databinding.FragmentSplashBinding
import am.a_t.mobilemarcet.presentation.viewModel.MyViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel by viewModel<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        initViewModel()

        return binding.root
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            viewModel.autoLoginLiveData.collect {
                delay(2000)
                if (it) {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }
            }
        }
    }

}