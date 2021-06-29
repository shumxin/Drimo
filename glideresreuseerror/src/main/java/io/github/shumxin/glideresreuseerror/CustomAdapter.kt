package io.github.shumxin.glideresreuseerror

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

class CustomAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageview_main_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.img_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imageView.context).load(dataSet[position])
            .into(object : CustomViewTarget<View, Drawable>(holder.imageView) {
                override fun onLoadFailed(errorDrawable: Drawable?) {

                }

                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    Log.i("smx", "onResourceReady view: " + holder.imageView + " bitmap: " + (resource as BitmapDrawable).bitmap)
                    holder.imageView.setImageDrawable(resource)
                }

                override fun onResourceCleared(placeholder: Drawable?) {
                    if (holder.imageView.drawable is BitmapDrawable) {
                        val bitmap = (holder.imageView.drawable as BitmapDrawable).bitmap
                        Log.i("smx", "onResourceCleared view: " + holder.imageView + " bitmap: " + bitmap + " isRecycled: " + bitmap.isRecycled)
                    }
                    holder.imageView.setImageDrawable(null)
                }
            })
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}