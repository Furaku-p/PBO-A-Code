
/**
 * Write a description of class Mahasiswa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Mahasiswa {
    private String nama;
    private String nrp;
    private static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    private ArrayList<Kelas> kelasDiambil;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.kelasDiambil = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getNrp() {
        return nrp;
    }
    
    public ArrayList<Kelas> getKelasDiambil() {
        return kelasDiambil;
    }
    
    public void addKelas(Kelas k) {
        if (!kelasDiambil.contains(k)) {
            kelasDiambil.add(k);
        }
    }

    public static void addMahasiswa(Mahasiswa m) {
        dataMahasiswa.add(m);
    }
    
    public boolean sudahAmbilMatkul(String kodeMatkul) {
        for (Kelas k : kelasDiambil) {
            if (k.getMatkul().getKode().equals(kodeMatkul)) {
                return true;
            }
        }
        return false;
    }

    public static Mahasiswa find(String nrp) {
        for (Mahasiswa m : dataMahasiswa) {
            if (m.getNrp().equals(nrp)) return m;
        }
        return null;
    }
}
