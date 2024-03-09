package Tugas_kelompok;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        DaftarBuku daftarBuku = new DaftarBuku();
        char lanjut;

        do{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("======PERPUSTAKAAN ONLINE======");
            System.out.println("1. Menambah buku ");
            System.out.println("2. Menampilkan Daftar buku ");
            System.out.println("3. Mencari judul Buku ");
            System.out.println("4. Menghapus Buku ");
            System.out.print("Pilih menu : ");
            int input = scanner.nextInt();
            System.out.println();

            if(input == 1){
            // Menambahkan buku
                scanner.nextLine();
                System.out.println("=====Menambahkan Buku=====");
                System.out.print("Masukkan judul buku          : ");
                String judul = scanner.nextLine();
                System.out.print("Masukkan penulis buku        : ");
                String penulis = scanner.nextLine();
                System.out.print("Masukkan tahun terbit        : ");
                int tahunTerbit = scanner.nextInt();
                System.out.print("Jenis buku (fiksi/non-fiksi) : ");
                String jenisBuku = scanner.next();


                if (jenisBuku.equalsIgnoreCase("fiksi")) {
                    System.out.print("Masukkan genre buku\t     : ");
                    String genre = scanner.next();
                    BukuFiksi bukuFiksi = new BukuFiksi(judul, penulis, tahunTerbit, genre);
                    daftarBuku.addBuku(bukuFiksi);
                } else if (jenisBuku.equalsIgnoreCase("non-fiksi")) {
                    System.out.print("Masukkan genre buku\t     : ");
                    String genre = scanner.next();
                    BukuNonFiksi bukuNonFiksi = new BukuNonFiksi(judul, penulis, tahunTerbit, genre);
                    daftarBuku.addBuku(bukuNonFiksi);
                }
            }

            if(input == 2){
                // Menampilkan daftar buku
                System.out.println("=====Daftar Buku=====");
                daftarBuku.tampilkanDaftarBuku();
            }

            if(input == 3){
                // Mencari buku
                System.out.println("=====Mencari Buku=====");
                System.out.print("Masukkan judul buku yang ingin dicari : ");
                scanner.nextLine();
                String judulBuku = scanner.nextLine();

                Buku bukuDicari = daftarBuku.cariBuku(judulBuku);

                if (bukuDicari != null) {
                    System.out.println("\nBuku ditemukan!");
                    bukuDicari.tampilkanInfo();
                } else {
                    System.out.println("\nBuku tidak ditemukan!");
                }
            }

            if(input == 4){
                // Menghapus buku
                scanner.nextLine();
                System.out.println("=====Menghapus Buku=====");
                System.out.print("Masukkan judul buku yang ingin dihapus : ");
                String judulBuku = scanner.nextLine();

                Buku bukuDihapus = daftarBuku.cariBuku(judulBuku);

                if (bukuDihapus != null) {
                    daftarBuku.removeBuku(bukuDihapus);
                    System.out.println("Buku \"" + judulBuku + "\" berhasil dihapus!");
                } else {
                    System.out.println("Buku \"" + judulBuku + "\" tidak ditemukan!");
                }
            }
            System.out.println();
            System.out.print("Apakah ingin menginput menu lagi (y/n)? ");
            lanjut = scanner.next().charAt(0);
        }while(Character.toLowerCase(lanjut) == 'y');
    }
}

