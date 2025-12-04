public class Motor extends Kendaraan
{
    private int cc;
    private String jenisMotor;

    public Motor(String merk, String model, int tahunProduksi, double tarifPerHari, int cc, String jenisMotor) {
        super(merk, model, tahunProduksi, tarifPerHari);
        this.cc = cc;
        this.jenisMotor = jenisMotor;
    }

    @Override
    public String getInfo() {
        return "Motor (" + jenisMotor + "): " + merk + " " + model + " " + cc + "CC (" + tahunProduksi + 
               ") - Tarif: Rp" + tarifPerHari + "/hari";
    }
}
