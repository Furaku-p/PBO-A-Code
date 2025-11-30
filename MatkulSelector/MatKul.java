
/**
 * Write a description of class MatKul here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;

public class MatKul {
    private String nama;
    private String kode;
    private int sks;
    private static HashMap<String, MatKul> daftarMatKul = new HashMap<>();

    public MatKul(String kode, String nama, int sks) {
        this.nama = nama;
        this.kode = kode;
        this.sks = sks;
    }

    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kode;
    }

    public int getSks() {
        return sks;
    }
    
    public static MatKul get(String kode) {
        return daftarMatKul.get(kode);
    }
    
    public static HashMap<String, MatKul> getAll() {
        return daftarMatKul;
    }
    
    static {
        daftarMatKul.put("TG", new MatKul("TG", "Teori Graf", 3));
        daftarMatKul.put("MD", new MatKul("MD", "Matematika Diskrit", 3));
        daftarMatKul.put("PBO", new MatKul("PBO", "Pemrograman Berorientasi Objek", 3));
        daftarMatKul.put("KKA", new MatKul("KKA", "Konsep Kecerdasan Artifisial", 3));
        daftarMatKul.put("JK", new MatKul("JK", "Jaringan Komputer", 4));
        daftarMatKul.put("PW", new MatKul("PW", "Pemrograman Web", 3));
        daftarMatKul.put("KPPL", new MatKul("KPPL", "Konsep Pengembangan Perangkat Lunak", 2));
    }

}
