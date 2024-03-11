package Tugas_kelompok;
import java.util.ArrayList;

public class DaftarBuku {
    private ArrayList<Buku> daftarBuku;

    public DaftarBuku() {

        daftarBuku = new ArrayList<>();
    }

    public void addBuku(Buku buku) {

        daftarBuku.add(buku);
    }

    public void removeBuku(Buku buku) {
        daftarBuku.remove(buku);
    }

    public Buku cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equals(judul)) {
                return buku;
            }
        }
        return null;
    }

    public void tampilkanDaftarBuku() {
        for (Buku buku : daftarBuku) {
            buku.tampilkanInfo();
            System.out.println(buku);
        }
    }
}
