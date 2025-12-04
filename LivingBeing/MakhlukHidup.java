
/**
 * Write a description of class MakhlukHidup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class MakhlukHidup
{
    private String name;
    
    public MakhlukHidup(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void breathe() {

        System.out.println(name + " bernafas");

    }

    public abstract void grow();
}