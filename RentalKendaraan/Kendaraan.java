public abstract class Kendaraan
{
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected double tarifPerHari;

    public Kendaraan(String merk, String model, int tahunProduksi, double tarifPerHari) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.tarifPerHari = tarifPerHari;
    }

    public double getTarifPerHari() {
        return tarifPerHari;
    }

    public abstract String getInfo();
}
