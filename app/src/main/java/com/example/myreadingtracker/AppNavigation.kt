
package com.example.myreadingtracker

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.toRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // State daftar mata kuliah
    var courses by remember {
        mutableStateOf(sampleCourses)
    }

    NavHost(
        navController = navController,
        startDestination = Home
    ) {

        // HOME
        composable<Home> {
            HomeScreen(
                courses = courses,
                onOpenDetail = { id ->
                    navController.navigate(Detail(id))
                },
                onAdd = {
                    navController.navigate(Edit())
                }
            )
        }

        // DETAIL
        composable<Detail> { entry ->
            val route: Detail = entry.toRoute()

            val selectedCourse = courses.find {
                it.id == route.id
            }

            if (selectedCourse == null) {
                NotFoundScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                DetailScreen(
                    course = selectedCourse,
                    onBack = {
                        navController.popBackStack()
                    },
                    onEdit = {
                        navController.navigate(Edit(route.id))
                    }
                )
            }
        }

        // ADD / EDIT
        composable<Edit> { entry ->
            val route: Edit = entry.toRoute()

            val selectedCourse = route.id?.let { id ->
                courses.find { it.id == id }
            }

            // Jika ID diberikan tetapi datanya tidak ditemukan
            if (route.id != null && selectedCourse == null) {
                NotFoundScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                CourseFormScreen(
                    initial = selectedCourse,

                    onSave = { code, name, sks ->

                        if (route.id == null) {
                            // TAMBAH DATA BARU
                            val newId = (courses.maxOfOrNull { it.id } ?: 0) + 1

                            val newCourse = Course(
                                id = newId,
                                code = code,
                                name = name,
                                sks = sks,
                                description = "Deskripsi belum tersedia."
                            )

                            courses = courses + newCourse

                            Toast.makeText(
                                context,
                                "Mata kuliah berhasil ditambahkan",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {
                            // UPDATE DATA
                            courses = courses.map { course ->
                                if (course.id == route.id) {
                                    course.copy(
                                        code = code,
                                        name = name,
                                        sks = sks
                                    )
                                } else {
                                    course
                                }
                            }

                            Toast.makeText(
                                context,
                                "Mata kuliah berhasil diperbarui",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        navController.popBackStack()
                    },

                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

// Tampilan jika data tidak ditemukan
@Composable
fun NotFoundScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Data mata kuliah tidak ditemukan.")

        Button(
            onClick = onBack,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Kembali")
        }
    }
}
