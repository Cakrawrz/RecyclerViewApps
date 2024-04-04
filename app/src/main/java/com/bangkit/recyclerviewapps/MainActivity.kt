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
    private lateinit var detailList: Array<String>
    private lateinit var descList: Array<String>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var heroAdapter: ListHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.alasprambon,
            R.drawable.candipari,
            R.drawable.candisumur,
            R.drawable.gor,
            R.drawable.jayandaru,
            R.drawable.kampungjetis,
            R.drawable.masjidagung,
            R.drawable.museum,
            R.drawable.suncity,
            R.drawable.wisatatlocor
        )

        titleList = arrayOf(
            "Wisata Alas Prambon",
            "Monumen Candi Pari",
            "Monumen Candi Sumur",
            "GOR (Gedung Olahraga)",
            "Monumen Jayandaru",
            "Wisata Kampung Batik Jetis",
            "Wisata Masjid Agung",
            "Museum Mpu Tantular",
            "Wisata Air Suncity",
            "Wisata Alam Tlocor"
        )

        detailList = arrayOf(
            "Wisata Edukasi dan Outbound",
            "Peninggalan Kerajaan Majapahit",
            "Peninggalan Prasasti pada masa Klasik di Sidoarjo",
            "Kompleks Olahraga Stadion Gelora Delta Sidoarjo",
            "Monumen Jayandaru pada Alun-Alun Sidoarjo",
            "Kampung Batik Jetis Khas kerajinan Warga Sidoarjo",
            "Masjid Agung untuk pengunjung Sidoarjo",
            "Museum Mpu Tantular Menyimpan Banyak Prasasti",
            "Wisata Kolam Renang Suncity Yang Terletak di Sidoarjo",
            "Wisata Alam Tlocor Yang di Kelola oleh Pokdarwis bernama Pulau Lusi"
        )

        descList = arrayOf(
            getString(R.string.detail_a),
            getString(R.string.detail_b),
            getString(R.string.detail_c),
            getString(R.string.detail_d),
            getString(R.string.detail_e),
            getString(R.string.detail_f),
            getString(R.string.detail_g),
            getString(R.string.detail_h),
            getString(R.string.detail_i),
            getString(R.string.detail_j)
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.rv_heroes)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        heroList = ArrayList()
        getData()

        heroAdapter = ListHeroAdapter(heroList)
        recyclerView.adapter = heroAdapter

        heroAdapter.onItemClick = {
            val intent = Intent(this, WisataActivity::class.java)
            intent.putExtra("hero", it)
            startActivity(intent)
        }
    }


    private fun getData() {
        for (i in imageList.indices) {
            val hero = Hero(imageList[i], titleList[i], detailList[i], descList[i])
            heroList.add(hero)
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