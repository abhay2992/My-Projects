
import java.util.ArrayList;

public class Airline
{
    private ArrayList <Plane> Airline_planes;
    
    public Airline()
    {
        Airline_planes=new ArrayList<>();

    }
    
    public void addPlane(Plane plane)
    {
        this.Airline_planes.add(plane);
    }
    
}
