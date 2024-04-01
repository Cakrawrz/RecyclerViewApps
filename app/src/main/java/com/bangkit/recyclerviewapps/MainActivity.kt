package com.bangkit.recyclerviewapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var heroList: ArrayList<Hero>
    private lateinit var heroAdapter: ListHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.rv_heroes)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        heroList = ArrayList()

        heroList.add(Hero("Wisata Alas Prambon", "Alas Prambon - Wisata edukasi dan outbound untuk anak di Sidoarjo.", R.drawable.alasprambon))
        heroList.add(Hero("Monumen Candi Pari","Candi Pari merupakan peninggalan dari Kerajaan Majapahit.",R.drawable.candipari,))
        heroList.add(Hero("Monumen Candi Sumur","Candi Sumur adalah sebuah peninggalan masa Klasik yang terletak di Kabupaten Sidoarjo.", R.drawable.candisumur,))
        heroList.add(Hero("GOR (Gedung Olahraga)", "Kompleks olahraga ini menjadi rumah bagi Stadion Gelora Delta, Gedung Olahraga GOR Sidoarjo, Lapangan Tenis GOR Sidoarjo dan Kolam Renang GOR Sidoarjo.", R.drawable.gor,))
        heroList.add(Hero("Monumen Jayandaru", "Monumen Jayandaru yang berlokasi di jantung Kabupaten Sidoarjo. Tepatnya di Jalan Jenggolo 21, Sidokumpul, Sidoarjo", R.drawable.jayandaru,))
        heroList.add(Hero("Wisata Kampung Batik Jetis", "batik Jetis khas Sidoarjo masih menggunakan warna bawah hitam, seperti cokelat soga dan pola penggambaran yang sederhana.", R.drawable.kampungjetis,))
        heroList.add(Hero("Wisata Masjid Agung", "Masjid Jamik Agung Sidoarjo atau sering disebut Masjid Agung Sidoarjo ini berdiri sejak tahun 1859", R.drawable.masjidagung,))
        heroList.add(Hero("Museum Mpu Tantular", "museum ini bernama Stedelijk Historisch Museum Soerabaia, didirikan oleh Godfried von Faber pada tahun 1933 dan diresmikan pada tanggal 25 Juli 1937.", R.drawable.museum,))
        heroList.add(Hero("Wisata Air Suncity", "Wisata kolam renang yang berlokasi di Sidoarjo.", R.drawable.suncity,))
        heroList.add(Hero("Wisata Alam Tlocor", "Wisata bahari tlocor penyedia jasa penyebrangan ke pulau lusi yang dibentuk oleh pokdarwis dibawah naungan BUMDesa Desa Kedungoandan.", R.drawable.wisatatlocor,))

        heroAdapter = ListHeroAdapter(heroList)
        recyclerView.adapter = heroAdapter

        heroAdapter.onItemClick = {
            val intent = Intent(this, WisataActivity::class.java)
            intent.putExtra("hero", it)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}