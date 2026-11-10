package com.example.myreadingtracker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseFormScreen(
    initial: Course?,
    onSave: (String, String, Int) -> Unit,
    onCancel: () -> Unit
) {
    var code by rememberSaveable {
        mutableStateOf(initial?.code ?: "")
    }

    var name by rememberSaveable {
        mutableStateOf(initial?.name ?: "")
    }

    var sks by rememberSaveable {
        mutableStateOf(initial?.sks?.toString() ?: "3")
    }

    val isValid = code.isNotBlank() &&
            name.isNotBlank() &&
            (sks.toIntOrNull() ?: 0) > 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(if (initial == null) "Tambah Mata Kuliah" else "Edit Mata Kuliah")
                }
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
            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = { Text("Kode Mata Kuliah") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Mata Kuliah") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = sks,
                onValueChange = { sks = it },
                label = { Text("Jumlah SKS") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    onSave(code.trim(), name.trim(), sks.toInt())
                },
                enabled = isValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan")
            }

            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Batal")
            }
        }
    }
}