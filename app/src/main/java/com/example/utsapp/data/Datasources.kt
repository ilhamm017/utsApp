package com.example.utsapp.data

import com.example.utsapp.R
import com.example.utsapp.model.Berita

class Datasources() {
    fun loadBerita(): List<Berita> {
        return listOf<Berita>(
            Berita(R.string.berita1, R.drawable.berita1, R.string.link1),
            Berita(R.string.berita2, R.drawable.berita2, R.string.link1),
            Berita(R.string.berita3, R.drawable.berita3, R.string.link1),
            Berita(R.string.berita4, R.drawable.berita4, R.string.link1),
            Berita(R.string.berita5, R.drawable.berita5, R.string.link1),
            Berita(R.string.berita6, R.drawable.berita6, R.string.link1),
            Berita(R.string.berita7, R.drawable.berita7, R.string.link1),
            Berita(R.string.berita8, R.drawable.berita8, R.string.link1),
            Berita(R.string.berita9, R.drawable.berita9, R.string.link1),
            Berita(R.string.berita10, R.drawable.berita10, R.string.link1),
        )
    }
}