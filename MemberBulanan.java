public class MemberBulanan extends Member {
    private String tanggalBerakhir;

    public MemberBulanan(String id, String nama, String nomorTelepon, String tanggalBerakhir) {
        super(id, nama, nomorTelepon);
        setTanggalBerakhir(tanggalBerakhir);
    }

    public String getTanggalBerakhir() { return tanggalBerakhir; }

    public void setTanggalBerakhir(String tanggal) {
        if (tanggal == null || tanggal.trim().isEmpty())
            throw new IllegalArgumentException("Tanggal berakhir wajib diisi.");
        tanggalBerakhir = tanggal.trim();
    }

    @Override
    public String getJenisMember() { return "Bulanan"; }

    @Override
    public String getInfoPaket() {
        return "Berlaku sampai: " + tanggalBerakhir;
    }
}
