package io.github.shumxin.glideresreuseerror

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageUrlList = resources.getStringArray(R.array.image_url_list)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_main_container)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CustomAdapter(imageUrlList)
    }
}