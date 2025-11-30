
/**
 * Write a description of class Kelas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Kelas {

    private String nama;
    private int kapasitas;
    private String jadwal;
    private Dosen dosen;
    private MatKul matkul;
    private ArrayList<Mahasiswa> mahasiswaList;
    private static ArrayList<Kelas> daftarKelas = new ArrayList<>();

    public Kelas(String nama, int kapasitas, String jadwal, Dosen dosen, MatKul matkul) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.jadwal = jadwal;
        this.dosen = dosen;
        this.matkul = matkul;
        this.mahasiswaList = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public MatKul getMatkul() {
        return matkul;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public String getJadwal() {
        return jadwal;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getJumlahMahasiswa() {
        return mahasiswaList.size();
    }
    
    public ArrayList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }
    
    public static ArrayList<Kelas> getDaftarKelas() {
        return daftarKelas;
    }


    public boolean tambahMahasiswa(Mahasiswa m) {
        if (mahasiswaList.size() < kapasitas) {
            mahasiswaList.add(m);
            return true;
        }
        return false;
    }
    
    private static void tambah(String nama, int kapasitas, String jadwal, String inisialDosen, String kodeMatkul) {
        Dosen d = Dosen.get(inisialDosen);
        MatKul mk = MatKul.get(kodeMatkul);

        daftarKelas.add(new Kelas(nama, kapasitas, jadwal, d, mk));
    }

    public static void loadDefaultKelas() {
        tambah("TG-A", 18, "Senin, 07.00",  "AW", "TG");
        tambah("TG-B", 15, "Senin, 07.00",  "VH", "TG");
        tambah("PW-A", 14, "Senin, 07.00",  "FB", "PW");
        tambah("KKA-A",20, "Senin, 10.00",  "NS", "KKA");
        tambah("KKA-C",11, "Senin, 10.00",  "AI", "KKA");
        tambah("PW-B", 13, "Senin, 10.00",  "FB", "PW");
        tambah("KKA-B",17, "Senin, 13.30",  "NS", "KKA");
        tambah("KKA-E",19, "Senin, 13.30",  "DA", "KKA");
        tambah("KKA-D",16, "Senin, 15.30",  "MK", "KKA");

        tambah("TG-D", 20, "Selasa, 07.00", "VH", "TG");
        tambah("JK-A", 14, "Selasa, 07.00", "BS", "JK");
        tambah("PBO-A",17, "Selasa, 10.00", "FB", "PBO");
        tambah("PBO-C",12, "Selasa, 10.00", "RL", "PBO");
        tambah("KPPL-A",18,"Selasa, 10.00", "SR", "KPPL");
        tambah("PBO-D",20, "Selasa, 13.30", "RL", "PBO");
        tambah("PBO-B",13, "Selasa, 13.30", "FB", "PBO");
        tambah("KPPL-B",11,"Selasa, 13.30", "SR", "KPPL");
        tambah("KKA-F",15, "Selasa, 15.30", "AI", "KKA");

        tambah("JK-B", 18, "Rabu, 07.00",   "RM", "JK");
        tambah("KPPL-C",12,"Rabu, 10.00",   "SR", "KPPL");
        tambah("KPPL-E",16,"Rabu, 10.00",   "AL", "KPPL");
        tambah("TG-E", 14, "Rabu, 10.00",   "AW", "TG");
        tambah("KPPL-D",20,"Rabu, 13.30",   "SR", "KPPL");
        tambah("MD-B", 13, "Rabu, 15.30",   "HM", "MD");

        tambah("KKA-G", 12,"Kamis, 07.00",  "CF", "KKA");
        tambah("TG-C",  17,"Kamis, 07.00",  "VH", "TG");
        tambah("PW-C",  18,"Kamis, 07.00",  "IS", "PW");
        tambah("JK-C",  11,"Kamis, 13.30",  "AM", "JK");
        tambah("PW-D",  19,"Kamis, 15.30",  "IS", "PW");

        tambah("MD-C",  16,"Jumat, 09.00",  "IG", "MD");
    }
}

