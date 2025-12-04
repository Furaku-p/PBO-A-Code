public class Penyewa
{
    private String nama;
    private Kendaraan kendaraan;
    private int lamaSewa;

    public Penyewa(String nama, Kendaraan kendaraan, int lamaSewa) {
        this.nama = nama;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
    }

    public double totalBiaya() {
        return kendaraan.getTarifPerHari() * lamaSewa;
    }

    public String getInfoPenyewa() {
        return nama + " menyewa -> " + kendaraan.getInfo() + ", Lama: " + lamaSewa + " hari, Total: Rp" + totalBiaya();
    }

    public String getNama() {
        return nama;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }
}
