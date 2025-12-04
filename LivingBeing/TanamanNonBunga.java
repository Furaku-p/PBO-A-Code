/**
 * Write a description of class TanamanBerbunga here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TanamanNonBunga extends Tumbuhan
{
    public TanamanNonBunga (String name) {
        super(name);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " tumbuh Tanpa Menumbuhkan Bunga");
    }
    
    @Override
    public void photosynthesis(){
        System.out.println(getName() + " Dapat Fotosintesis tanpa Bunga");
    }
}