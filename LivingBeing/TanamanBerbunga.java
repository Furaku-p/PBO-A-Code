/**
 * Write a description of class TanamanBerbunga here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TanamanBerbunga extends Tumbuhan
{
    public TanamanBerbunga (String name) {
        super(name);
    }
    
    @Override
    public void grow(){
        System.out.println(getName() + " tumbuh Dengan Menumbuhkan Bunga");
    }
    
    @Override
    public void photosynthesis(){
        System.out.println(getName() + " Memproduksi makanan dengan Fotosintesis");
    }
}