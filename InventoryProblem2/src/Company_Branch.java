
import java.util.ArrayList;

public class Company_Branch
{
    String location;
    ArrayList<Inventory> list;

    public Company_Branch(String location)
    {
        this.location=location;
        list=new ArrayList<>();
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public void addItem(Inventory inv)
    {
        list.add(inv);
    }
    
    public ArrayList<Inventory> getItemList()
    {
        return list;
    }
    
}
