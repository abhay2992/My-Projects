
import java.util.Date;

public class Day
{
    private String day_type;
    
    Day(String day)
    {
        String days[]={"sun","mon","tue","wed","thu","fri", "sat"};
        
        if(day.equalsIgnoreCase(days[0])||day.equalsIgnoreCase(days[6]))
        {
            this.day_type="weekend";
        }
        else
        {
            this.day_type="weekday";
        }
        
    }
    
    public String getDayType()
    {
        return this.day_type;
    }
    
}
