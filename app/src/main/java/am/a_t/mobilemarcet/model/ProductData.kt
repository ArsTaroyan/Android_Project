package am.a_t.mobilemarcet.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("images")
    val images: List<String>
): Parcelable