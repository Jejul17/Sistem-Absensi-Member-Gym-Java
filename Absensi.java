import java.time.LocalDate;
import java.time.LocalTime;

public class Absensi {
    private final String idMember;
    private final String namaMember;
    private final LocalDate tanggal;
    private final LocalTime jamMasuk;

    public Absensi(Member member) {
        this.idMember = member.getId();
        this.namaMember = member.getNama();
        this.tanggal = LocalDate.now();
        this.jamMasuk = LocalTime.now();
    }

    public String getIdMember() { return idMember; }
    public String getNamaMember() { return namaMember; }
    public LocalDate getTanggal() { return tanggal; }
    public LocalTime getJamMasuk() { return jamMasuk; }

    public String toString() {
        return String.format("%-8s | %-20s | %-12s | %s",
            idMember, namaMember, tanggal, jamMasuk.withNano(0));
    }
}
