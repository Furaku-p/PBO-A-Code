/**
 * Write a description of class Anjing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Anjing extends Hewan
{
    public Anjing (String name) {
        super(name);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " Tumbuh dengan Makan dan Olahraga");
    }
    
    @Override
    public void move(){
        System.out.println(getName() + " Berlari dengan Empat kaki");
    }
}