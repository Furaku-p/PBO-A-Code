
/**
 * Write a description of class Keyword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Keyword
{
    private Map<String, String> rules;
    private Random random;
    
    public Keyword() {
        rules = new LinkedHashMap<>();
        random = new Random();

        rules.put("sks", "Pastikan jumlah SKS Anda mencukupi untuk mengambil mata kuliah tersebut.");
        rules.put("prasyarat", "Anda mungkin belum lulus mata kuliah prasyarat.");
        rules.put("batal", "Pembatalan mata kuliah hanya dapat dilakukan pada periode yang ditentukan.");
        rules.put("validasi", "Validasi KRS perlu dilakukan oleh dosen wali sebelum final.");
        rules.put("kelas", "Apakah kelas penuh? Anda dapat mencoba kelas di jadwal lain.");
        rules.put("frs", "Masuk ke portal FRS, cek status pengisian Anda.");
        rules.put("pengumuman", "Pengumuman akademik biasanya muncul di dashboard portal.");
        rules.put("akses", "Jika tidak dapat mengakses portal, coba login ulang setelah beberapa menit.");
    }
    
    public String respond(Set<String> words) {

        for (String rule : rules.keySet()) {
            if (words.contains(rule)) {
                return rules.get(rule);
            }
        }
        
        String[] fallback = {
            "Silakan jelaskan masalah Anda secara lebih spesifik.",
            "Saya masih belum berhasil mengerti, boleh diulangi?",
            "Berikan konteks tambahan agar saya dapat membantu lebih tepat.",
            "Apakah ini terkait SKS, prasyarat, atau akses portal?",
            "Baik, saya mendengarkan — bisa diperjelas?"
        };

        return fallback[random.nextInt(fallback.length)];
    }
}