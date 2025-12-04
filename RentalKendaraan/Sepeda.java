public class Sepeda extends Kendaraan
{
    private String jenisSepeda;

    public Sepeda(String merk, String model, int tahunProduksi, double tarifPerHari, String jenisSepeda) {
        super(merk, model, tahunProduksi, tarifPerHari);
        this.jenisSepeda = jenisSepeda;
    }

    @Override
    public String getInfo() {
        return "Sepeda (" + jenisSepeda + "): " + merk + " " + model + " (" + tahunProduksi +
               ") - Tarif: Rp" + tarifPerHari + "/hari";
    }
}
