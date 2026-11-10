package com.example.myreadingtracker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    course: Course?,
    onBack: () -> Unit,
    onEdit: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Mata Kuliah") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (course == null) {
                Text("Data tidak ditemukan")
            } else {
                Text("Kode: ${course.code}")
                Text("Nama: ${course.name}")
                Text("SKS: ${course.sks}")
                Text("Deskripsi: ${course.description}")

                Button(onClick = onEdit) {
                    Text("Edit")
                }
            }

            OutlinedButton(onClick = onBack) {
                Text("Kembali")
            }
        }
    }
}