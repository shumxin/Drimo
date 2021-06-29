package io.github.shumxin.glideresreuseerror

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView

class MyImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    override fun onDraw(canvas: Canvas?) {
        if (drawable is BitmapDrawable) {
            (drawable as BitmapDrawable).bitmap?.let {
                if (it.isRecycled) {
                    Log.i("smx", "onDraw bitmap: " + it + " isRecycled: " + it.isRecycled)
                    return
                }
            }
        }
        super.onDraw(canvas)
    }
}