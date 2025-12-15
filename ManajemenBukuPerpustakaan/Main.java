import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SistemPerpustakaan sp = new SistemPerpustakaan();

        int pilihan;
        do {
            System.out.println("\n=== MENU USER ===");
            System.out.println("1. Lihat Buku Tersedia");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Masuk Admin");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt(); input.nextLine();

            switch (pilihan) {
                case 1:
                    sp.tampilkanList(sp.ambilBukuTersedia(), "BUKU TERSEDIA");
                    break;

                case 2:
                    System.out.print("ID buku: ");
                    int idPinjam = input.nextInt(); input.nextLine();
                    System.out.print("Nama peminjam: ");
                    String nama = input.nextLine();
                    sp.pinjamBuku(idPinjam, nama);
                    break;

                case 3:
                    System.out.print("ID buku: ");
                    int idKembali = input.nextInt(); input.nextLine();
                    sp.kembalikanBuku(idKembali);
                    break;

                case 4:
                    System.out.print("Masukkan kode admin: ");
                    String kode = input.nextLine();
                    if (kode.equals("1234")) {
                        adminMenu(sp, input);
                    } else {
                        System.out.println("Kode salah!");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }

    static void adminMenu(SistemPerpustakaan sp, Scanner input) {
        int pilih;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Edit Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");
            pilih = input.nextInt(); input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Judul: ");
                    String j = input.nextLine();
                    System.out.print("Penulis: ");
                    String p = input.nextLine();
                    sp.tambahBuku(j, p);
                    break;

                case 2:
                    sp.tampilkanList(sp.ambilSemuaBuku(), "DAFTAR SEMUA BUKU");
                    break;

                case 3:
                    System.out.print("ID buku: ");
                    int idEdit = input.nextInt(); input.nextLine();
                    System.out.print("Judul baru: ");
                    String jb = input.nextLine();
                    System.out.print("Penulis baru: ");
                    String pb = input.nextLine();
                    sp.editBuku(idEdit, jb, pb);
                    break;

                case 4:
                    System.out.print("ID buku: ");
                    int idHapus = input.nextInt(); input.nextLine();
                    sp.hapusBuku(idHapus);
                    break;

                case 0:
                    System.out.println("Kembali ke user...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }
}
