public abstract class Member {
    private String id;
    private String nama;
    private String nomorTelepon;
    private boolean aktif;

    public Member(String id, String nama, String nomorTelepon) {
        setId(id);
        setNama(nama);
        setNomorTelepon(nomorTelepon);
        this.aktif = true;
    }

    // Encapsulation: atribut private diakses melalui getter dan setter.
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getNomorTelepon() { return nomorTelepon; }
    public boolean isAktif() { return aktif; }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty())
            throw new IllegalArgumentException("ID member wajib diisi.");
        this.id = id.trim();
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty())
            throw new IllegalArgumentException("Nama member wajib diisi.");
        this.nama = nama.trim();
    }

    public void setNomorTelepon(String nomorTelepon) {
        if (nomorTelepon == null || nomorTelepon.trim().isEmpty())
            throw new IllegalArgumentException("Nomor telepon wajib diisi.");
        this.nomorTelepon = nomorTelepon.trim();
    }

    public void setAktif(boolean aktif) { this.aktif = aktif; }

    public abstract String getJenisMember();
    public abstract String getInfoPaket();
}
