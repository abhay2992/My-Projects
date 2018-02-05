public class Row
{
    boolean left_seats[];
    boolean right_seats[];
    boolean middle_seats[];
    
    public Row()
    {
        left_seats= new boolean[2];
        right_seats= new boolean[2];
        middle_seats= new boolean[4];
        
        for(int i=0;i<2;i++)
        {
            left_seats[i]=false;
            right_seats[i]=false;
        }
        
        for(int i=0;i<4;i++)
        {
            middle_seats[i]=false;
        }
    }
    
}
