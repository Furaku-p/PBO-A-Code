/**
 * Write a description of class Manusia here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class Manusia extends MakhlukHidup
{
    public Manusia (String name) {
        super(name);
    }
    
    public abstract void speak();

}