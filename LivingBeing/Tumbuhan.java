/**
 * Write a description of class Tumbuhan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class Tumbuhan extends MakhlukHidup 
{
    public Tumbuhan (String name) {
        super(name);
    }
    
    public abstract void photosynthesis();
}