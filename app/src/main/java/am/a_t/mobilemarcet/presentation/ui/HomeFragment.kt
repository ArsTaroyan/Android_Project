package am.a_t.mobilemarcet.presentation.ui

import am.a_t.mobilemarcet.R
import am.a_t.mobilemarcet.databinding.FragmentHomeBinding
import am.a_t.mobilemarcet.presentation.adapter.ViewPagerAdapter
import am.a_t.mobilemarcet.presentation.viewModel.MyViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<MyViewModel>()
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViewModel()
        initNavView()
        initViewPagerAdapter()
        setView()

        return binding.root
    }

    private fun setView() {
        binding.toolBar.setTitle(R.string.app_name)
    }

    private fun initViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdapter(
            arrayListOf(
                SmartphonesProductsFragment(),
                LaptopsProductsFragment()
            ),
            requireActivity().supportFragmentManager,
            lifecycle
        )

        with(binding) {
            viewPager.adapter = viewPagerAdapter
            TabLayoutMediator(
                tbLayout, viewPager
            ) { tab, position ->
                when(position) {
                    0 -> {
                        tab.text = "Smartphones"
                    }
                    1 -> {
                        tab.text = "Laptops"
                    }
                }
            }.attach()
        }
    }


    private fun initNavView() {
        with(binding) {
            actionBarToggle = ActionBarDrawerToggle(
                requireActivity(),
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(actionBarToggle)
            actionBarToggle.syncState()

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.ic_log_out -> {
                        viewModel.logout()
                    }
                }
                true
            }
        }
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            viewModel.logOutLiveData.collect {
                if (it) {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.localLiveData.collect {
                binding.navView.inflateHeaderView(R.layout.header_layout).apply {
                    findViewById<AppCompatTextView>(R.id.tvNameHeader).text = it.firstName

                    Glide
                        .with(findViewById<ShapeableImageView>(R.id.imgUserHeader))
                        .load(it.image)
                        .centerCrop()
                        .into(findViewById<ShapeableImageView>(R.id.imgUserHeader))
                }
            }
        }
    }
}