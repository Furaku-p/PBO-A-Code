
/**
 * Write a description of class Dosen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;

public class Dosen
{
   private String nama;
   private String nid;
   private static HashMap<String, Dosen> daftarDosen = new HashMap<>();
   
    public Dosen(String nid, String nama) {
        this.nama = nama;
        this.nid = nid;
    }

    public String getNama() {
        return nama;
    }

    public String getNid() {
        return nid;
    }
    
    public static Dosen get(String kode) {
        return daftarDosen.get(kode);
    }
    
    public static HashMap<String, Dosen> getAll() {
        return daftarDosen;
    }
    
    static {
        daftarDosen.put("AI", new Dosen("AI", "Aldinata Rizky Revanda, S.Kom., M.Kom."));
        daftarDosen.put("AL", new Dosen("AL", "Adhatus Solichah Ahmadiyah, S.Kom., M.Sc."));
        daftarDosen.put("AM", new Dosen("AM", "Ir. Ary Mazharuddin Shiddiqi, S.Kom., M.Comp.Sc., Ph.D."));
        daftarDosen.put("AW", new Dosen("AW", "Ir. Arya Yudhi Wijaya, S.Kom., M.Kom."));
        daftarDosen.put("BS", new Dosen("BS", "Dr. Baskoro Adi Pratomo, S.Kom., M.Kom."));
        daftarDosen.put("CF", new Dosen("CF", "Prof. Dr.Eng. Chastine Fatichah, S.Kom., M.Kom."));
        daftarDosen.put("DA", new Dosen("DA", "Dini Adni Navastara, S.Kom., M.Sc."));
        daftarDosen.put("FB", new Dosen("FB", "Fajar Baskoro, S.Kom., M.T."));
        daftarDosen.put("HM", new Dosen("HM", "Dr.Eng. Muhamad Hilmil Muchtar Aditya Pradana, S.Kom., M.Sc."));
        daftarDosen.put("IG", new Dosen("IG", "Ilham Gurat Adillion, S.Kom., M.Eng."));
        daftarDosen.put("IS", new Dosen("IS", "Ir. Misbakhul Munir Irfan Subakti, S.Kom., M.Sc., M.Phil."));
        daftarDosen.put("MK", new Dosen("MK", "Imam Mustafa Kamal, S.ST., Ph.D."));
        daftarDosen.put("NS", new Dosen("NS", "Prof. Dr.Eng. Nanik Suciati, S.Kom., M.Kom."));
        daftarDosen.put("RL", new Dosen("RL", "Rully Soelaiman, S.Kom., M.Kom."));
        daftarDosen.put("RM", new Dosen("RM", "Royyana Muslim Ijtihadie, S.Kom., M.Kom., Ph.D."));
        daftarDosen.put("SR", new Dosen("SR", "Sarwosri, S.Kom., M.T."));
        daftarDosen.put("VH", new Dosen("VH", "Victor Hariadi, S.Si., M.Kom."));
    }
}