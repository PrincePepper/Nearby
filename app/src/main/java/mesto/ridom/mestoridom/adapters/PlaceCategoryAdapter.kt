package mesto.ridom.mestoridom.adapters

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.place_category_view_holder_layout.view.*
import mesto.ridom.mestoridom.R

class PlaceCategoryAdapter() : RecyclerView.Adapter<PlaceCategoryAdapter.PlaceCategoryViewHolder>() {

    lateinit var data: MutableList<PlaceCategory>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceCategoryViewHolder =
            PlaceCategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.place_category_view_holder_layout, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PlaceCategoryViewHolder, position: Int){
        holder.fillView(data[position])
    }

    class PlaceCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        companion object{
            const val LOG_TAG = "PLACE_CATEGORY"
        }

        fun fillView(placeCategory: PlaceCategory) {
            view.apply {
                val backGround = ResourcesCompat.getDrawable(resources, R.drawable.place_category_rounded_corners, null)
                backGround?.setTint(placeCategory.categoryColor)
                place_category_background.background = backGround
                place_category_logo.background = placeCategory.categoryLogo
                category_name.text = placeCategory.categoryName
            }
            Log.i(LOG_TAG, "place category holder was filled")
        }
    }
}

data class PlaceCategory(var categoryName: String, var categoryColor: Int, var categoryLogo: Drawable)