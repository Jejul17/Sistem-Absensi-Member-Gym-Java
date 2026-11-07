import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManajemenGym {
    private final List<Member> daftarMember = new ArrayList<>();
    private final List<Absensi> riwayatAbsensi = new ArrayList<>();

    public void tambahMember(Member member) {
        if (cariMember(member.getId()) != null)
            throw new IllegalArgumentException("ID member sudah terdaftar.");
        daftarMember.add(member);
    }

    public Member cariMember(String id) {
        for (Member member : daftarMember) {
            if (member.getId().equalsIgnoreCase(id.trim())) return member;
        }
        return null;
    }

    public void catatKehadiran(String id) {
        Member member = cariMember(id);
        if (member == null) throw new IllegalArgumentException("Member tidak ditemukan.");
        if (!member.isAktif()) throw new IllegalStateException("Status member tidak aktif.");

        for (Absensi a : riwayatAbsensi) {
            if (a.getIdMember().equalsIgnoreCase(member.getId())
                    && a.getTanggal().equals(LocalDate.now())) {
                throw new IllegalStateException("Member sudah melakukan absensi hari ini.");
            }
        }
        riwayatAbsensi.add(new Absensi(member));
        System.out.println("Absensi berhasil dicatat untuk " + member.getNama() + ".");
    }

    public void tampilkanMember() {
        if (daftarMember.isEmpty()) {
            System.out.println("Belum ada data member.");
            return;
        }
        System.out.println("\\nID       | Nama                 | Jenis    | Status   | Paket");
        for (Member m : daftarMember) {
            System.out.printf("%-8s | %-20s | %-8s | %-8s | %s%n",
                m.getId(), m.getNama(), m.getJenisMember(),
                m.isAktif() ? "Aktif" : "Nonaktif", m.getInfoPaket());
        }
    }

    public void tampilkanAbsensiHariIni() {
        LocalDate hariIni = LocalDate.now();
        boolean ada = false;
        System.out.println("\\nID       | Nama                 | Tanggal      | Jam Masuk");
        for (Absensi a : riwayatAbsensi) {
            if (a.getTanggal().equals(hariIni)) {
                System.out.println(a);
                ada = true;
            }
        }
        if (!ada) System.out.println("Belum ada absensi hari ini.");
    }

    public void tampilkanSemuaRiwayat() {
        if (riwayatAbsensi.isEmpty()) {
            System.out.println("Riwayat absensi masih kosong.");
            return;
        }
        System.out.println("\\nID       | Nama                 | Tanggal      | Jam Masuk");
        for (Absensi a : riwayatAbsensi) System.out.println(a);
    }

    public void ubahStatusMember(String id, boolean aktif) {
        Member m = cariMember(id);
        if (m == null) throw new IllegalArgumentException("Member tidak ditemukan.");
        m.setAktif(aktif);
        System.out.println("Status " + m.getNama() + " sekarang " + (aktif ? "Aktif." : "Nonaktif."));
    }
}
