public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private boolean dipinjam;

    public Buku(int id, String judul, String penulis, boolean dipinjam) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.dipinjam = dipinjam;
    }

    public int getId() { return id; }
    public boolean isDipinjam() { return dipinjam; }

    public String getInfo() {
        return id + ". " + judul + " - " + penulis + " | Status: " + (dipinjam ? "Dipinjam" : "Tersedia");
    }
}
