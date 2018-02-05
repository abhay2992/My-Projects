
import java.util.ArrayList;

public class Hotel
{
    private String name;
    private ArrayList<HotelBranch> hotel_branches;
    

    public Hotel(String name)
    {
        this.name=name;
        this.hotel_branches=new ArrayList<>();
    }
    
    public void addBranch(HotelBranch branch)
    {
        this.hotel_branches.add(branch);
    }
    
    public ArrayList<HotelBranch> getHotelBranches()
    {
        return hotel_branches;
    }
    
}
