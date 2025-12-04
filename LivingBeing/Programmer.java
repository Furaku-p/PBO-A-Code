/**
 * Write a description of class Programmer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Programmer extends Manusia
{
    public Programmer (String name) {
        super(name);
    }
    
    @Override
    public void grow() {
        System.out.println(getName() + " Sedang Belajar Bahasa Pemrograman Baru agar jadi lebih Pintar");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " Menjelaskan Dasar Pemrograman");
    }
}