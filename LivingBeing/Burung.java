/**
 * Write a description of class Burung here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Burung extends Hewan
{
    public Burung (String name) {
        super(name);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " Makan untuk Bertumbuh");
    }
    
    @Override
    public void move(){
        System.out.println(getName() + " Terbang di Langit");
    }
}