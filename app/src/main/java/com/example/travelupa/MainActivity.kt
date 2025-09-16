package com.example.travelupa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelupa.ui.theme.TravelupaTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelupaTheme {
                RekomendasiTempatScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelupaTheme {
        Greeting("Android")
    }
}

@Composable
fun GreetingScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Text(
                text = "Selamat Datang di Travelupa!",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Solusi buat kamu yang lupa kemana-mana",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = {/*TODO*/},
            modifier = Modifier.width(360.dp).align(Alignment.BottomCenter).padding(bottom = 16.dp)
        ) {
            Text(text = "Mulai")
        }
    }
}

data class TempatWisata(val nama: String, val deskripsi: String, val gambar: Int)

val daftarTempatWisata = listOf(
    TempatWisata(
        "Tumpak Sewu",
        "Air terjun tercantik di Jawa Timur.",
        R.drawable.tumpaksewu),
    TempatWisata(
        "Gunung Bromo",
        "Matahari terbitnya bagus banget.",
        R.drawable.gunungbromo)
)

@Composable
fun RekomendasiTempatScreen(){
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(daftarTempatWisata) {
            tempat -> TempatItem(tempat)
        }
    }
}

@Composable
fun TempatItem(tempat: TempatWisata){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Image(
                painter = painterResource(id = tempat.gambar),
                contentDescription = tempat.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                    contentScale = ContentScale.Crop
            )
            Text(
                text = tempat.nama,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = tempat.deskripsi,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

//@Composable
//fun RekomendasiTempatScreen(){
//    var daftarTempatWisata by remember { mutableStateOf(listOf(
//        TempatWisata(
//            "Tumpak Sewu",
//            "Air terjun tercantik di Jawa Timur.",
//            R.drawable.tumpaksewu),
//        TempatWisata(
//            "Gunung Bromo",
//            "Matahari terbitnya bagus banget.",
//            R.drawable.gunungbromo)
//    )) }
//
//    var showTambahDialog by remember { mutableStateOf(false) }
//
//    Scaffold(
//        floatingButtonAction = {
//            FloatingActionButton(
//                onClick = { showTambahDialog = true },
//                backgroundColor = MaterialTheme.colorScheme.primary
//            ) {
//                Icon(Icons.Filled.Add, contentDescription = "Tambah Tempat Wisata")
//            }
//        }
//    ){ paddingValues ->
//        Column(
//            modifier = Modifier
//                .padding(paddingValues)
//                .padding(16.dp)
//        ){
//            LazyColumn{
//                items(daftarTempatWisata){ tempat ->
//                    TempatItemEditable(
//                        tempat = tempat,
//                        onDelete = {
//                            daftarTempatWisata = daftarTempatWisata.filter { it != tempat }
//
//                        }
//                    )
//                }
//            }
//        }
//
//        if(showTambahDialog){
//            TambahTempatWisataDialog(
//                onDismiss = { showTambahDialog = false },
//                onTambah = { nama, deskripsi, gambar ->
//                    val nuevoTempat = TempatWisata(nama, deskripsi, gambar)
//                    daftarTempatWisata =
//                }
//            )
//        }

//    }
//}