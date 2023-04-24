package am.a_t.mobilemarcet.presentation.adapter

import am.a_t.mobilemarcet.R
import am.a_t.mobilemarcet.databinding.ItemProductBinding
import am.a_t.mobilemarcet.model.ProductData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(val click: (ProductData) -> Unit) : ListAdapter<ProductData, ProductAdapter.ProductHolder>(MyDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindData(getItem(position))

        holder.binding.root.setOnClickListener {
            click(getItem(position))
        }
    }

    class ProductHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ProductData) {
            with(binding) {
                Glide
                    .with(imgProduct)
                    .load(data.images[0])
                    .centerCrop()
                    .into(imgProduct)

                tvName.text = data.title
                tvPrice.text = String.format(itemView.context.getString(R.string.price_), data.price.toString())
                tvBrand.text = data.brand
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<ProductData>() {
        override fun areItemsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
            return oldItem == newItem
        }

    }
}