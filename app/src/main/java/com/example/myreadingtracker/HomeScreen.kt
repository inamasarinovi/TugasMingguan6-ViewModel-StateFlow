
package com.example.myreadingtracker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class DashboardTask(
    val id: Int,
    val title: String,
    val subject: String,
    val deadline: String,
    val isDone: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    courses: List<Course>,
    onOpenDetail: (Int) -> Unit,
    onAdd: () -> Unit
) {
    var isDarkMode by rememberSaveable { mutableStateOf(false) }

    // WARNA LIGHT MODE DAN DARK MODE
    val backgroundColor = if (isDarkMode)
        Color(0xFF211820) else Color(0xFFFFF1F5)

    val cardColor = if (isDarkMode)
        Color(0xFF30232D) else Color(0xFFFFFFFF)

    val scheduleColor = if (isDarkMode)
        Color(0xFF392936) else Color(0xFFF8DCE6)

    val primaryColor = if (isDarkMode)
        Color(0xFFE58BAA) else Color(0xFFD96C91)

    val textColor = if (isDarkMode)
        Color(0xFFF8EDF2) else Color(0xFF393039)

    val mutedColor = if (isDarkMode)
        Color(0xFFC8B8C1) else Color(0xFF806D76)

    val pendingColor = if (isDarkMode)
        Color(0xFF49303D) else Color(0xFFFCE1E8)

    val completedColor = if (isDarkMode)
        Color(0xFF3C2B38) else Color(0xFFF4EAF0)

    val deadlineColor = if (isDarkMode)
        Color(0xFFF0A0BA) else Color(0xFFC04B72)

    val tasks = remember {
        mutableStateListOf(
            DashboardTask(
                1, "Menyelesaikan laporan praktikum",
                "Pemrograman Web", "Besok • H-1", false
            ),
            DashboardTask(
                2, "Membuat desain halaman aplikasi",
                "Pemrograman Bergerak", "12 November", false
            ),
            DashboardTask(
                3, "Mengerjakan latihan Kotlin",
                "Pemrograman Bergerak", "Selesai", true
            )
        )
    }

    val pendingTasks = tasks.filter { !it.isDone }
    val completedTasks = tasks.filter { it.isDone }

    Scaffold(
        containerColor = backgroundColor,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAdd,
                containerColor = primaryColor,
                contentColor = Color.White
            ) {
                Text("+", fontSize = 26.sp)
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            // HEADER, IPK, PROFIL, DAN DARK MODE
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Hi, Inama! 👋",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )
                        Text(
                            text = "Semangat menjalani aktivitas kuliah hari ini!",
                            fontSize = 12.sp,
                            color = mutedColor
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = "IPK",
                                fontSize = 10.sp,
                                color = mutedColor
                            )
                            Text(
                                text = "3.75",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = primaryColor
                            )
                        }

                        Surface(
                            shape = CircleShape,
                            color = if (isDarkMode)
                                Color(0xFF49303D)
                            else Color(0xFFF8DCE6),
                            modifier = Modifier.size(34.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    "N",
                                    fontWeight = FontWeight.Bold,
                                    color = primaryColor
                                )
                            }
                        }

                        IconButton(
                            onClick = { isDarkMode = !isDarkMode }
                        ) {
                            Text(
                                text = if (isDarkMode) "☀" else "☾",
                                fontSize = 23.sp,
                                color = primaryColor
                            )
                        }
                    }
                }
            }

            // JADWAL HARI INI
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Jadwal Hari Ini",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = scheduleColor
                        ),
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {
                            Text(
                                text = "18.30 - 20.30",
                                color = primaryColor,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Pemrograman Web",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold,
                                color = textColor
                            )

                            Text(
                                text = "Jadwal perkuliahan",
                                fontSize = 12.sp,
                                color = mutedColor
                            )
                        }
                    }
                }
            }

            // RINGKASAN TUGAS
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Ringkasan Tugas",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(
                                containerColor = pendingColor
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "Belum Selesai",
                                    color = textColor,
                                    fontSize = 13.sp
                                )
                                Text(
                                    "${pendingTasks.size}",
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryColor
                                )
                            }
                        }

                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(
                                containerColor = completedColor
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "Sudah Selesai",
                                    color = textColor,
                                    fontSize = 13.sp
                                )
                                Text(
                                    "${completedTasks.size}",
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryColor
                                )
                            }
                        }
                    }
                }
            }

            // DEADLINE TERDEKAT
            item {
                Text(
                    text = "Deadline Terdekat",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            items(pendingTasks.size) { index ->
                val task = pendingTasks[index]

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = cardColor
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = task.title,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )

                        Text(
                            text = task.subject,
                            color = mutedColor
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Deadline: ${task.deadline}",
                            color = deadlineColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // DAFTAR TUGAS
            item {
                Text(
                    text = "Daftar Tugas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            items(tasks.size) { index ->
                val task = tasks[index]

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = cardColor
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = task.isDone,
                            onCheckedChange = { checked ->
                                tasks[index] = task.copy(isDone = checked)
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = primaryColor
                            )
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = task.title,
                                fontWeight = FontWeight.SemiBold,
                                color = textColor
                            )

                            Text(
                                text = task.subject,
                                fontSize = 12.sp,
                                color = mutedColor
                            )
                        }
                    }
                }
            }

            // DAFTAR MATA KULIAH
            item {
                Text(
                    text = "Daftar Mata Kuliah",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            items(courses.size) { index ->
                val course = courses[index]

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onOpenDetail(course.id)
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = cardColor
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = course.name,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )

                        Text(
                            text = "${course.code} • ${course.sks} SKS",
                            color = mutedColor
                        )
                    }
                }
            }
        }
    }
}
