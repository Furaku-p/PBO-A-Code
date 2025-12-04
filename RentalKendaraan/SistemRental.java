import java.util.ArrayList;

public class SistemRental
{
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Penyewa> daftarPenyewa;

    public SistemRental() {
        daftarKendaraan = new ArrayList<>();
        daftarPenyewa = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tambahPenyewa(Penyewa p) {
        daftarPenyewa.add(p);
    }

    public void tampilkanKendaraan() {
        System.out.println("\n=== Daftar Kendaraan Tersedia ===");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKendaraan.get(i).getInfo());
        }
    }

    public void tampilkanPenyewa() {
        System.out.println("\n=== Daftar Penyewa ===");
        for (int i = 0; i < daftarPenyewa.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPenyewa.get(i).getNama());
        }
    }

    public void detailPenyewa(int index) {
        if (index >= 0 && index < daftarPenyewa.size()) {
            System.out.println("\n=== DETAIL PENYEWA ===");
            System.out.println(daftarPenyewa.get(index).getInfoPenyewa());
        } else {
            System.out.println("Nomor tidak valid!");
        }
    }
}
