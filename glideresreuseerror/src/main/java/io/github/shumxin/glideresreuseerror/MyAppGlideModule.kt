package io.github.shumxin.glideresreuseerror

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class MyAppGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val bitmapPoolSizeBytes = 1024 * 1024 * 0 // 0mb
        val memoryCacheSizeBytes = 1024 * 1024 * 0 // 0mb
        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes.toLong()))
        builder.setBitmapPool(LruBitmapPool(bitmapPoolSizeBytes.toLong()))
        builder.setLogLevel(Log.VERBOSE)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}