package am.a_t.mobilemarcet.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("products")
    val products: List<ProductData>
) {

    companion object {
        fun emptyProducts(): Products = Products(emptyList())
    }

}
