public class MemberHarian extends Member {
    private int biayaPerKunjungan;

    public MemberHarian(String id, String nama, String nomorTelepon, int biayaPerKunjungan) {
        super(id, nama, nomorTelepon);
        setBiayaPerKunjungan(biayaPerKunjungan);
    }

    public int getBiayaPerKunjungan() { return biayaPerKunjungan; }

    public void setBiayaPerKunjungan(int biaya) {
        if (biaya <= 0) throw new IllegalArgumentException("Biaya kunjungan harus lebih dari nol.");
        biayaPerKunjungan = biaya;
    }

    @Override
    public String getJenisMember() { return "Harian"; }

    @Override
    public String getInfoPaket() {
        return "Biaya per kunjungan: Rp" + biayaPerKunjungan;
    }
}
