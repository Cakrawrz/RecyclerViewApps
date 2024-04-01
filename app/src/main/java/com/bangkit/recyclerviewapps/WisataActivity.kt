 package com.bangkit.recyclerviewapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

 @Suppress("DEPRECATION")
 class WisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata)

        val hero = intent.getParcelableExtra<Hero>("hero")
        if (hero != null) {
            val imageView : ImageView = findViewById(R.id.imageView)
            val textView : TextView = findViewById(R.id.titleView)
            val deskripsi : TextView = findViewById(R.id.deskripsi)

            imageView.setImageResource(hero.photo)
            textView.text = hero.name
            deskripsi.text = hero.description
        }

    }
}