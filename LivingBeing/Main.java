/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Main {
    public static void main(String[] args) {
        Manusia programmer = new Programmer("Ani");
        Manusia dokter = new Dokter("Budi");
        
        programmer.breathe();
        programmer.grow();
        programmer.speak();
        
        dokter.breathe();
        dokter.grow();
        dokter.speak();
        
        Hewan anjing = new Anjing("Cuddly");
        Hewan burung = new Burung("Dumpy");
        
        anjing.breathe();
        anjing.grow();
        anjing.move();
        
        burung.breathe();
        burung.grow();
        burung.move();
        
        Tumbuhan mawar = new TanamanBerbunga("Rose");
        Tumbuhan pakis = new TanamanNonBunga("Fern");
        
        mawar.breathe();
        mawar.grow();
        mawar.photosynthesis();
        
        pakis.breathe();
        pakis.grow();
        pakis.photosynthesis();
    }
}