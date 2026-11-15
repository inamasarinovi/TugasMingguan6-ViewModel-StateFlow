# MyReadingTracker – ViewModel & StateFlow

## Deskripsi
MyReadingTracker merupakan aplikasi Android sederhana yang dikembangkan menggunakan Kotlin dan Jetpack Compose. Pada tugas pertemuan 6, aplikasi ini direfactor dengan menerapkan arsitektur UI Layer, ViewModel, StateFlow, dan Unidirectional Data Flow (UDF) untuk mengelola serta memperbarui data aplikasi.

## Identitas
- Nama: Novi Inama Sari
- NIM: 0112523028
- Mata Kuliah: Pemrograman Bergerak
- Pertemuan 6 – Refactor ViewModel & StateFlow

## Fitur Aplikasi
- Menampilkan daftar mata kuliah.
- Menampilkan detail mata kuliah.
- Menambahkan mata kuliah baru.
- Mengedit data mata kuliah.
- Mengubah tampilan Light Mode dan Dark Mode.
- Melakukan validasi input sebelum data disimpan.
- Menampilkan pesan kesalahan apabila input tidak valid.

## Teknologi yang Digunakan
- Bahasa pemrograman: Kotlin
- UI Framework: Jetpack Compose
- Material Design: Material 3
- State Management: ViewModel dan StateFlow
- Lifecycle: collectAsStateWithLifecycle()
- Navigation: Navigation Compose
- IDE: Android Studio

## Struktur Project
- `CourseUiState.kt` – Menyimpan data UI dalam bentuk immutable state.
- `CourseViewModel.kt` – Mengelola state dan event aplikasi menggunakan StateFlow.
- `AppNavigation.kt` – Mengatur navigasi antarhalaman dan menghubungkan ViewModel dengan UI.
- `HomeScreen.kt` – Menampilkan halaman utama aplikasi.
- `CourseFormScreen.kt` – Menampilkan formulir untuk menambah dan mengedit mata kuliah.

## Penerapan ViewModel dan StateFlow
Aplikasi menerapkan pola Unidirectional Data Flow (UDF), yaitu perubahan data dilakukan melalui event yang diteruskan dari UI ke ViewModel. ViewModel kemudian memperbarui state menggunakan MutableStateFlow dan menyediakan StateFlow sebagai state yang dapat diamati oleh UI.
State dikumpulkan pada sisi Compose menggunakan `collectAsStateWithLifecycle()`.

## Cara Menjalankan Aplikasi
1. Clone repository ini.
2. Buka project menggunakan Android Studio.
3. Tunggu proses Gradle Sync selesai.
4. Jalankan aplikasi menggunakan emulator atau perangkat Android.
5. Klik tombol Run untuk menjalankan aplikasi.

## Pengujian
Pengujian dilakukan dengan menjalankan aplikasi pada emulator, meliputi:
- Pengujian navigasi antarhalaman.
- Pengujian penambahan dan pengeditan mata kuliah.
- Pengujian perubahan Light Mode dan Dark Mode.
- Pengujian validasi input.
- Pengujian konsistensi state ketika orientasi perangkat diubah dari portrait ke landscape.

## Versi Tools dan Library
- Android Studio: [Isi versi yang digunakan]
- Kotlin: [Isi versi yang digunakan]
- Gradle: [Isi versi yang digunakan]
- Android SDK: [Isi versi compileSdk]
- Jetpack Compose dan library pendukung: [Isi versi sesuai konfigurasi Gradle]

## Deklarasi Penggunaan AI
Dalam pengerjaan tugas ini, AI digunakan sebagai alat bantu untuk memahami konsep ViewModel, StateFlow, UDF, serta membantu proses refactoring dan pemeriksaan kode. Seluruh kode yang digunakan telah diperiksa dan diuji kembali melalui Android Studio.

## Repository
[MyReadingTracker – Tugas Mingguan 6](https://github.com/inamasarinovi/TugasMingguan6-ViewModel-StateFlow)
