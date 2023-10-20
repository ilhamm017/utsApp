package com.example.utsapp


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.utsapp.data.Datasources
import com.example.utsapp.model.Berita
import com.example.utsapp.ui.theme.UtsAppTheme
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //mengunakan fungsi
                   utsApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun utsApp() { //fungsi utsApp
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()) //Membuat scrollBehavior yang berfungsi untuk memposisikan Top bar tetap di atas layar saat digulirkan
    Scaffold( //menggunakan Scaffold untuk menampilkan topBar
        topBar = { //Membuat top bar
            CenterAlignedTopAppBar( //Top bar dengan posisi center
                colors = TopAppBarDefaults.mediumTopAppBarColors( //Menerapkan warna primary
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { //Diberi judul dengan nama Berita Random
                    Text(
                        "Berita Random",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                scrollBehavior = scrollBehavior //Menggunakan scrollBehavior
            )
        }
    ) {
        Content() //Memanggil fungsi Content
    }
}

@Composable
fun Content() {  //fungsi konten yang menampilkan list berita
    BeritaList(
        beritaList = Datasources().loadBerita(),
    )
}

@Composable
fun BeritaList(beritaList: List<Berita>, modifier: Modifier = Modifier) { //fungsi yang menyusun berita
    LazyColumn(modifier = modifier) {// Menampilkan daftar afirmasi dalam bentuk grid.
        /*LazyColumn menampilkan item-item secara lazy,
        yaitu hanya item yang terlihat di layar saja*/
        items(beritaList) { berita ->
            BeritaCard(
                berita = berita,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun BeritaCard(berita: Berita, modifier: Modifier = Modifier) { //Fungsi yang digunakan untuk membentuk card berita
    Card(modifier = modifier) {
        Column {//Diurutkan dari atas ke bawah
            Image( //Menampilkan gambar berita
                painter = painterResource(berita.imageResourceId),
                contentDescription = stringResource(berita.stringResourcesId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text( //Menampilkan text berita
                text = LocalContext.current.getString(berita.stringResourcesId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

