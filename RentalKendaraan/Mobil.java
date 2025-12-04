public class Mobil extends Kendaraan
{
    private boolean AC;
    private String jenisMobil;

    public Mobil(String merk, String model, int tahunProduksi, double tarifPerHari, boolean AC, String jenisMobil) {
        super(merk, model, tahunProduksi, tarifPerHari);
        this.AC = AC;
        this.jenisMobil = jenisMobil;
    }

    @Override
    public String getInfo() {
        return "Mobil (" + jenisMobil + "): " + merk + " " + model + " (" + tahunProduksi + 
               "), AC: " + (AC ? "Ya" : "Tidak") + " - Tarif: Rp" + tarifPerHari + "/hari";
    }
}
