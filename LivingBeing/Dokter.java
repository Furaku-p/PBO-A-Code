
/**
 * Write a description of class Doctor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dokter extends Manusia
{
    public Dokter (String name) {
        super(name);
    }
    
    @Override
    public void grow() {
        System.out.println(getName() + " Menambah pengalaman melalui Praktik");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " Melakukan Konseling dengan Pasien");
    }
}