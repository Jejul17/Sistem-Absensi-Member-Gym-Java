# Sistem Manajemen Absensi Member Gym Harian (Java)

Aplikasi console Java untuk mencatat kehadiran member gym berdasarkan tanggal dan jam masuk.

## Fitur
- Menambahkan member harian dan bulanan.
- Menampilkan daftar member beserta status aktif/nonaktif.
- Mencatat absensi dengan tanggal dan jam masuk otomatis.
- Mencegah member melakukan absensi lebih dari satu kali pada tanggal yang sama.
- Menampilkan absensi hari ini dan seluruh riwayat absensi.
- Mengaktifkan atau menonaktifkan member.
- Validasi ID member agar tidak duplikat.

## Penerapan prinsip OOP

### 1. Access Modifier / Encapsulation
Atribut pada class `Member` dan `Absensi` dibuat `private`. Data diakses melalui getter dan setter. Validasi ditempatkan pada setter, sedangkan status aktif diubah melalui method yang disediakan.

### 2. Inheritance
Class `MemberHarian` dan `MemberBulanan` mewarisi class induk `Member` menggunakan `extends`. Keduanya memiliki informasi paket yang berbeda dan mengimplementasikan method abstrak `getJenisMember()` serta `getInfoPaket()`.

## Struktur folder
```text
Proyek_Absensi_Member_Gym_Java/
├── src/
│   ├── Main.java
│   ├── Member.java
│   ├── MemberHarian.java
│   ├── MemberBulanan.java
│   ├── Absensi.java
│   └── ManajemenGym.java
├── docs/
│   └── Percakapan_AI.pdf
└── README.md
```

## Cara menjalankan
Pastikan JDK telah terpasang. Buka terminal pada folder proyek, lalu jalankan:

```bash
javac -d out src/*.java
java -cp out Main
```

Tersedia dua data contoh: member harian H001 dan member bulanan B001.

## Catatan
Aplikasi ini merupakan prototipe pembelajaran berbasis console. Data member dan absensi disimpan di memori, sehingga akan hilang ketika aplikasi ditutup. Aplikasi belum memakai database atau autentikasi. Program ini mencegah absensi ganda berdasarkan tanggal lokal komputer yang menjalankan aplikasi.
