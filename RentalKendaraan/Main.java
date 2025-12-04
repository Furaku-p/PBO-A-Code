import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SistemRental sr = new SistemRental();

        ArrayList<Mobil> daftarMobil = new ArrayList<>();
        daftarMobil.add(new Mobil("Toyota", "Avanza", 2021, 350000, true, "MPV"));
        daftarMobil.add(new Mobil("Honda", "HRV", 2020, 400000, true, "SUV"));
        daftarMobil.add(new Mobil("Suzuki", "Swift", 2022, 300000, false, "City Car"));

        ArrayList<Motor> daftarMotor = new ArrayList<>();
        daftarMotor.add(new Motor("Honda", "CBR", 2022, 200000, 250, "Sport"));
        daftarMotor.add(new Motor("Yamaha", "NMax", 2021, 150000, 155, "Automatic"));
        daftarMotor.add(new Motor("Suzuki", "Satria", 2020, 180000, 150, "Bebek"));

        ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
        daftarSepeda.add(new Sepeda("Polygon", "Xtrack", 2019, 50000, "Gunung"));
        daftarSepeda.add(new Sepeda("United", "Miami", 2020, 45000, "Balap"));
        daftarSepeda.add(new Sepeda("Pacific", "Folding", 2021, 40000, "Lipat"));

        for(Mobil m : daftarMobil) sr.tambahKendaraan(m);
        for(Motor m : daftarMotor) sr.tambahKendaraan(m);
        for(Sepeda s : daftarSepeda) sr.tambahKendaraan(s);

        sr.tambahPenyewa(new Penyewa("Abdi", daftarMobil.get(0), 3));
        sr.tambahPenyewa(new Penyewa("Cinta", daftarMotor.get(0), 2));

        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM RENTAL ===");
            System.out.println("1. Lihat Daftar Kendaraan");
            System.out.println("2. Lihat Daftar Penyewa");
            System.out.println("3. Lihat Detail Penyewa");
            System.out.println("4. Tambah Penyewa Baru");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt(); input.nextLine();

            switch (pilihan) {
                case 1:
                    sr.tampilkanKendaraan();
                    break;

                case 2:
                    sr.tampilkanPenyewa();
                    break;

                case 3:
                    sr.tampilkanPenyewa();
                    System.out.print("Pilih nomor penyewa: ");
                    int p = input.nextInt(); input.nextLine();
                    sr.detailPenyewa(p - 1);
                    break;

                case 4:
                    System.out.print("Nama penyewa: ");
                    String nama = input.nextLine();

                    System.out.println("Pilih jenis kendaraan yang ingin disewa:");
                    System.out.println("1. Mobil");
                    System.out.println("2. Motor");
                    System.out.println("3. Sepeda");
                    System.out.print("Pilihan: ");
                    int jenis = input.nextInt(); input.nextLine();

                    switch(jenis) {
                        case 1:
                            System.out.println("Daftar Mobil:");
                            for(int i=0;i<daftarMobil.size();i++)
                                System.out.println((i+1)+". "+daftarMobil.get(i).getInfo());
                            System.out.print("Pilih nomor mobil: ");
                            int mPil = input.nextInt(); input.nextLine();
                            if(mPil < 1 && mPil > daftarMobil.size()) {
                                System.out.print("Nomor Mobil Tidak Terdaftar!!");
                            }
                            System.out.print("Lama sewa (hari): ");
                            int lamaM = input.nextInt(); input.nextLine();
                            sr.tambahPenyewa(new Penyewa(nama, daftarMobil.get(mPil-1), lamaM));
                            break;

                        case 2:
                            System.out.println("Daftar Motor:");
                            for(int i=0;i<daftarMotor.size();i++)
                                System.out.println((i+1)+". "+daftarMotor.get(i).getInfo());
                            System.out.print("Pilih nomor motor: ");
                            int moPil = input.nextInt(); input.nextLine();
                            if(moPil < 1 && moPil > daftarMotor.size()) {
                                System.out.print("Nomor Motor Tidak Terdaftar!!");
                            }
                            System.out.print("Lama sewa (hari): ");
                            int lamaMo = input.nextInt(); input.nextLine();
                            sr.tambahPenyewa(new Penyewa(nama, daftarMotor.get(moPil-1), lamaMo));
                            break;

                        case 3:
                            System.out.println("Daftar Sepeda:");
                            for(int i=0;i<daftarSepeda.size();i++)
                                System.out.println((i+1)+". "+daftarSepeda.get(i).getInfo());
                            System.out.print("Pilih nomor sepeda: ");
                            int sPil = input.nextInt(); input.nextLine();
                            if(sPil < 1 && sPil > daftarSepeda.size()) {
                                System.out.print("Nomor Sepeda Tidak Terdaftar!!");
                            }
                            System.out.print("Lama sewa (hari): ");
                            int lamaS = input.nextInt(); input.nextLine();
                            sr.tambahPenyewa(new Penyewa(nama, daftarSepeda.get(sPil-1), lamaS));
                            break;

                        default:
                            System.out.println("Jenis kendaraan tidak valid!");
                    }

                    System.out.println("Penyewa baru berhasil ditambahkan!");
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while(pilihan != 0);

        input.close();
    }
}
