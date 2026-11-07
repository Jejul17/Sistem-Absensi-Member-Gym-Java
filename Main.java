import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ManajemenGym gym = new ManajemenGym();

    public static void main(String[] args) {
        // Data awal agar program dapat langsung dicoba.
        gym.tambahMember(new MemberHarian("H001", "Andi Saputra", "081234567890", 30000));
        gym.tambahMember(new MemberBulanan("B001", "Siti Aminah", "081298765432", "30-11-2026"));

        boolean jalan = true;
        while (jalan) {
            System.out.println("\\n========== SISTEM ABSENSI MEMBER GYM ==========");
            System.out.println("1. Tampilkan daftar member");
            System.out.println("2. Tambah member harian");
            System.out.println("3. Tambah member bulanan");
            System.out.println("4. Catat absensi masuk");
            System.out.println("5. Lihat absensi hari ini");
            System.out.println("6. Lihat seluruh riwayat absensi");
            System.out.println("7. Ubah status member");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = input.nextLine().trim();
            try {
                switch (pilihan) {
                    case "1": gym.tampilkanMember(); break;
                    case "2": tambahMemberHarian(); break;
                    case "3": tambahMemberBulanan(); break;
                    case "4":
                        System.out.print("Masukkan ID member: ");
                        gym.catatKehadiran(input.nextLine());
                        break;
                    case "5": gym.tampilkanAbsensiHariIni(); break;
                    case "6": gym.tampilkanSemuaRiwayat(); break;
                    case "7": ubahStatus(); break;
                    case "0": jalan = false; break;
                    default: System.out.println("Menu tidak tersedia.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Gagal: " + e.getMessage());
            }
        }
        System.out.println("Terima kasih telah menggunakan sistem absensi gym.");
    }

    private static void tambahMemberHarian() {
        System.out.print("ID member: "); String id = input.nextLine();
        System.out.print("Nama: "); String nama = input.nextLine();
        System.out.print("Nomor telepon: "); String telepon = input.nextLine();
        System.out.print("Biaya kunjungan (angka rupiah): ");
        int biaya = Integer.parseInt(input.nextLine().trim());
        gym.tambahMember(new MemberHarian(id, nama, telepon, biaya));
        System.out.println("Member harian berhasil ditambahkan.");
    }

    private static void tambahMemberBulanan() {
        System.out.print("ID member: "); String id = input.nextLine();
        System.out.print("Nama: "); String nama = input.nextLine();
        System.out.print("Nomor telepon: "); String telepon = input.nextLine();
        System.out.print("Tanggal berakhir (contoh 30-11-2026): ");
        String tanggal = input.nextLine();
        gym.tambahMember(new MemberBulanan(id, nama, telepon, tanggal));
        System.out.println("Member bulanan berhasil ditambahkan.");
    }

    private static void ubahStatus() {
        System.out.print("ID member: "); String id = input.nextLine();
        System.out.print("Status (1=Aktif, 0=Nonaktif): ");
        String status = input.nextLine().trim();
        if (!status.equals("1") && !status.equals("0")) {
            System.out.println("Pilihan status tidak valid.");
            return;
        }
        gym.ubahStatusMember(id, status.equals("1"));
    }
}
