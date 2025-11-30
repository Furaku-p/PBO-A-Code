
/**
 * Write a description of class NumberDisplay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    
    public NumberDisplay(int maxlimit)
    {
        limit = maxlimit;
        value = 0;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }
    
    public void setValue(int inpValue)
    {
        if((inpValue >= 0) && (inpValue < limit)) {
            value = inpValue;
        }
    }
    
    public void increment()
    {
        value = (value + 1) % limit;
    }
}