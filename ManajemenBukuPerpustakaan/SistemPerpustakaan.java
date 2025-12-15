import java.sql.*;
import java.util.ArrayList;

public class SistemPerpustakaan {

    public void tambahBuku(String judul, String penulis) {
        String sql = "INSERT INTO buku(judul, penulis, dipinjam) VALUES(?,?,FALSE)";
        try (Connection c = DB.getKoneksi(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, judul);
            ps.setString(2, penulis);
            ps.executeUpdate();
            System.out.println("Buku berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Gagal tambah buku: " + e.getMessage());
        }
    }

    public ArrayList<Buku> ambilSemuaBuku() {
        ArrayList<Buku> list = new ArrayList<>();
        String sql = "SELECT id, judul, penulis, dipinjam FROM buku ORDER BY id";
        try (Connection c = DB.getKoneksi();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Buku(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Buku> ambilBukuTersedia() {
        ArrayList<Buku> list = new ArrayList<>();
        String sql = "SELECT id, judul, penulis, dipinjam FROM buku WHERE dipinjam=FALSE ORDER BY id";
        try (Connection c = DB.getKoneksi();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Buku(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            System.out.println("Gagal ambil data: " + e.getMessage());
        }
        return list;
    }

    public void editBuku(int id, String judulBaru, String penulisBaru) {
        String sql = "UPDATE buku SET judul=?, penulis=? WHERE id=?";
        try (Connection c = DB.getKoneksi(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, judulBaru);
            ps.setString(2, penulisBaru);
            ps.setInt(3, id);

            int n = ps.executeUpdate();
            System.out.println(n > 0 ? "Buku berhasil diupdate!" : "Buku tidak ditemukan!");
        } catch (Exception e) {
            System.out.println("Gagal edit buku: " + e.getMessage());
        }
    }

    public void hapusBuku(int id) {
        String sql = "DELETE FROM buku WHERE id=?";
        try (Connection c = DB.getKoneksi(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            System.out.println(n > 0 ? "Buku berhasil dihapus!" : "Buku tidak ditemukan!");
        } catch (Exception e) {
            System.out.println("Gagal hapus buku: " + e.getMessage());
        }
    }

    public void pinjamBuku(int idBuku, String namaPeminjam) {
        String cek = "SELECT dipinjam FROM buku WHERE id=? FOR UPDATE";
        String ins = "INSERT INTO peminjaman(id_buku, nama_peminjam) VALUES(?,?)";
        String upd = "UPDATE buku SET dipinjam=TRUE WHERE id=?";

        try (Connection c = DB.getKoneksi()) {
            c.setAutoCommit(false);

            try (PreparedStatement ps = c.prepareStatement(cek)) {
                ps.setInt(1, idBuku);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) { c.rollback(); System.out.println("Buku tidak ditemukan!"); return; }
                    if (rs.getBoolean(1)) { c.rollback(); System.out.println("Buku sedang dipinjam!"); return; }
                }
            }

            try (PreparedStatement ps1 = c.prepareStatement(ins);
                 PreparedStatement ps2 = c.prepareStatement(upd)) {

                ps1.setInt(1, idBuku);
                ps1.setString(2, namaPeminjam);
                ps1.executeUpdate();

                ps2.setInt(1, idBuku);
                ps2.executeUpdate();

                c.commit();
                System.out.println("Buku berhasil dipinjam!");
            } catch (Exception e) {
                c.rollback();
                System.out.println("Gagal pinjam: " + e.getMessage());
            } finally {
                c.setAutoCommit(true);
            }

        } catch (Exception e) {
            System.out.println("Error DB: " + e.getMessage());
        }
    }

    public void kembalikanBuku(int idBuku) {
        String cek = "SELECT dipinjam FROM buku WHERE id=? FOR UPDATE";
        String loan = "UPDATE peminjaman SET tgl_kembali=NOW() WHERE id_buku=? AND tgl_kembali IS NULL";
        String upd = "UPDATE buku SET dipinjam=FALSE WHERE id=?";

        try (Connection c = DB.getKoneksi()) {
            c.setAutoCommit(false);

            try (PreparedStatement ps = c.prepareStatement(cek)) {
                ps.setInt(1, idBuku);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) { c.rollback(); System.out.println("Buku tidak ditemukan!"); return; }
                    if (!rs.getBoolean(1)) { c.rollback(); System.out.println("Buku tidak sedang dipinjam."); return; }
                }
            }

            try (PreparedStatement ps1 = c.prepareStatement(loan);
                 PreparedStatement ps2 = c.prepareStatement(upd)) {

                ps1.setInt(1, idBuku);
                int n = ps1.executeUpdate();
                if (n == 0) { c.rollback(); System.out.println("Data peminjaman aktif tidak ditemukan!"); return; }

                ps2.setInt(1, idBuku);
                ps2.executeUpdate();

                c.commit();
                System.out.println("Buku berhasil dikembalikan!");
            } catch (Exception e) {
                c.rollback();
                System.out.println("Gagal kembali: " + e.getMessage());
            } finally {
                c.setAutoCommit(true);
            }

        } catch (Exception e) {
            System.out.println("Error DB: " + e.getMessage());
        }
    }

    public void tampilkanList(ArrayList<Buku> list, String judul) {
        System.out.println("\n=== " + judul + " ===");
        if (list.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfo());
        }
    }
}
