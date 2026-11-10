package com.example.myreadingtracker

data class Course(
    val id: Int,
    val code: String,
    val name: String,
    val sks: Int,
    val description: String
)

val sampleCourses = listOf(
    Course(1, "IF23H", "Algoritma dan Pemrograman", 2, "Mempelajari dasar algoritma dan pemrograman."),
    Course(2, "IF23H", "Struktur Data", 3, "Mempelajari pengelolaan dan penyimpanan data."),
    Course(3, "IF23H", "Basis Data", 3, "Mempelajari perancangan dan pengelolaan basis data."),
    Course(4, "IF24H", "Pemrograman Bergerak", 3, "Mempelajari pengembangan aplikasi Android."),
    Course(5, "IF23H", "Web Semantik", 3, "Mempelajari konsep web semantik dan RDF."),
    Course(6, "IF24H", "Kecerdasan Buatan", 2, "Mempelajari dasar kecerdasan buatan."),
    Course(7, "IF23H", "Jaringan Komputer", 3, "Mempelajari konsep jaringan komputer."),
    Course(8, "IF23H", "Komputasi Awan", 3, "Mempelajari teknik pengolahan dan analisis data.")
)