/**
 * Write a description of class Hewan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class Hewan extends MakhlukHidup
{
    public Hewan (String name) {
        super(name);
    }
    
    public abstract void move();
}