package Tugas_kelompok;

public class BukuNonFiksi extends Buku {
    private String kategori;

    public BukuNonFiksi(String judul, String penulis, int tahunTerbit, String kategori) {
        super(judul, penulis, tahunTerbit);
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori: " + kategori);
    }
}
