
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        Main app = new Main();
        Kelas.loadDefaultKelas();
        app.run();
    }

    public void run()
    {
        int input = 0;
        
        while (input != 4) {
            waitForEnter();
            clearScreen();
            System.out.println("\n===== PENGAMBILAN MATA KULIAH INFORMATIKA =====");
            System.out.println("1. Ambil Mata Kuliah");
            System.out.println("2. Lihat Daftar Kelas");
            System.out.println("3. Kelas Saya");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");

            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> ambilMatkul();
                case 2 -> lihatMatkul();
                case 3 -> kelasSaya();
                case 4 -> System.out.println("Selamat Menjalani Perkuliahan!!!");
                default -> System.out.println("Pilihan Tidak Valid");
            }
        }
    }

    public void ambilMatkul()
    {
        int input;
        Mahasiswa mhs;
        while(true) {
            waitForEnter();
            clearScreen();
            System.out.println("Ketik '0' Untuk Kembali");
            System.out.println("Input Nama Mahasiswa: ");
            String nama = sc.nextLine();
            if(nama.equals("0")) {
                return;
            }
            System.out.println("Input NRP Mahasiswa: ");
            String nrp = sc.nextLine();
            if(nrp.equals("0")) {
                return;
            }
            
            mhs = Mahasiswa.find(nrp);
            if (mhs == null) {
                mhs = new Mahasiswa(nama, nrp);
                Mahasiswa.addMahasiswa(mhs);
                break;
            } else {
                if (!mhs.getNama().equals(nama)) {
                    System.out.println("ERROR: Nama tidak sesuai dengan NRP!");
                } else {
                    break;
                }
                
            }

            
        }
        
        while(true) {
            waitForEnter();
            clearScreen();
            System.out.println("\n===== DAFTAR KELAS TERSEDIA =====");
            System.out.printf("%-3s | %-8s | %-12s | %-30s | %-20s | %-8s%n",
                      "No", "Kode", "Jadwal", "Dosen", "Matkul", "Kuota");
            int no = 1;
            for (Kelas k : Kelas.getDaftarKelas()) {
                System.out.printf("%-3d | %-8s | %-12s | %-30s | %-20s | %-2d/%-5d%n", no, k.getNama(), k.getJadwal(), k.getDosen().getNama(), k.getMatkul().getNama(),
                k.getJumlahMahasiswa(),k.getKapasitas());
                no++;
            }
            
            while(true) {
                System.out.println();
                
                System.out.print("Ketik '0' untuk kembali");
                System.out.println();
                System.out.print("Pilih nomor kelas: ");
                input = sc.nextInt();
                sc.nextLine();
                
                
                if (input < 0 || input > Kelas.getDaftarKelas().size()) {
                    System.out.println("Pilihan tidak valid!");
                    break;
                } else if (input == 0) {
                    return;
                }
            
                Kelas target = Kelas.getDaftarKelas().get(input - 1);
                String kodeMatkul = target.getMatkul().getKode();
            
                if (target.getMahasiswaList().contains(mhs)) {
                    System.out.println("Anda sudah terdaftar di kelas ini!");
                    break;
                } else if (mhs.sudahAmbilMatkul(kodeMatkul)){
                    System.out.println("Anda sudah mengambil mata kuliah " + kodeMatkul + " di kelas lain!");
                    break;
                }
        
                if (target.tambahMahasiswa(mhs)) {
                    System.out.println("Berhasil ditambahkan ke kelas " + target.getNama());
                    mhs.addKelas(target);
                    break;
                } else {
                    System.out.println("Kelas penuh!");
                    break;
                }
            }
        }
    }

    public void lihatMatkul()
    {
        System.out.println("\n===== DAFTAR KELAS DAN MAHASISWA =====");
        System.out.printf("%-3s | %-8s | %-12s | %-30s | %-20s | %-8s%n", "No", "Kode", "Jadwal", "Dosen", "Matkul", "Kuota");
        int no = 1;
        for (Kelas k : Kelas.getDaftarKelas()) {
            System.out.printf("%-3d | %-8s | %-12s | %-30s | %-20s | %-2d/%-5d%n", no, k.getNama(), k.getJadwal(),
                                k.getDosen().getNama(), k.getMatkul().getNama(), k.getJumlahMahasiswa(), k.getKapasitas());
            no++;
            if (k.getJumlahMahasiswa() == 0) {
                System.out.println("      -");
            } else {
                for (Mahasiswa m : k.getMahasiswaList()) {
                    System.out.println("      > " + m.getNama() + " (" + m.getNrp() + ")");
                }
            }
            System.out.println();
        }
    }

    public void kelasSaya() {
        System.out.println("Input NRP Mahasiswa: ");
        String nrp = sc.nextLine();
        
        Mahasiswa mhs = Mahasiswa.find(nrp);
        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan!");
            return;
        }
        var list = mhs.getKelasDiambil();
        
        if (list.isEmpty()) {
            System.out.println("Anda belum mengambil kelas apa pun.");
            return;
        }

        System.out.println("\n===== KELAS YANG ANDA AMBIL =====");
        System.out.printf("%-3s | %-8s | %-12s | %-30s | %-20s | %-8s%n",
                "No", "Kode", "Jadwal", "Dosen", "Matkul", "Kuota");
        
        int no = 1;
        for (Kelas k : list) {
            System.out.printf("%-3d | %-8s | %-12s | %-30s | %-20s | %-2d/%-5d%n",
                    no, k.getNama(), k.getJadwal(), k.getDosen().getNama(), k.getMatkul().getNama(), k.getJumlahMahasiswa(), k.getKapasitas()
            );
            no++;
        }
    }
    
    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public void waitForEnter() {
        System.out.println("\nTekan ENTER untuk melanjutkan...");
        sc.nextLine();
    }
}
