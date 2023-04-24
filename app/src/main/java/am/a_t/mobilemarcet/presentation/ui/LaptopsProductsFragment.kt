package am.a_t.mobilemarcet.presentation.ui

import am.a_t.mobilemarcet.R
import am.a_t.mobilemarcet.databinding.FragmentLaptopsProductsBinding
import am.a_t.mobilemarcet.databinding.FragmentProductBinding
import am.a_t.mobilemarcet.extension.toast
import am.a_t.mobilemarcet.model.ProductData
import am.a_t.mobilemarcet.presentation.adapter.ProductAdapter
import am.a_t.mobilemarcet.presentation.viewModel.MyViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaptopsProductsFragment : Fragment() {
    private lateinit var binding: FragmentLaptopsProductsBinding
    private val viewModel by viewModel<MyViewModel>()
    private lateinit var productAdapter: ProductAdapter
    private lateinit var myDialog: FragmentProductBinding
    private lateinit var alertDialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaptopsProductsBinding.inflate(inflater, container, false)

        initAdapter(inflater, container)
        initViewModel()

        return binding.root
    }

    private fun initDialog(inflater: LayoutInflater, container: ViewGroup?, productData: ProductData) {
        myDialog = FragmentProductBinding.inflate(inflater, container, false)
        with(myDialog) {
            Glide
                .with(imgProduct)
                .load(productData.images[0])
                .centerCrop()
                .into(imgProduct)

            tvBrand.text = productData.title
            tvPrice.text = String.format(requireContext().getString(R.string.price_), productData.price.toString())
            tvDescription.text = productData.description
            alertDialog = AlertDialog.Builder(requireContext())
                .setView(root)
                .show()
            btnClose.setOnClickListener {
                alertDialog.dismiss()
            }
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    private fun initAdapter(inflater: LayoutInflater, container: ViewGroup?) {
        with(binding) {
            productAdapter = ProductAdapter {
                initDialog(inflater, container, it)
            }
            rvAdapter.layoutManager = LinearLayoutManager(requireContext())
            rvAdapter.adapter = productAdapter
        }
    }

    private fun initViewModel() {
        viewModel.product()

        lifecycleScope.launch {
            viewModel.laptopsLiveData.collectLatest {
                productAdapter.submitList(it)
            }
        }
        lifecycleScope.launch {
            viewModel.errorLiveData.collect {
                requireContext().toast(it)
            }
        }
    }

}