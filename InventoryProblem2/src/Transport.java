public class Transport
{
    private String source;
    private String destination;
    private int charges_per_ten_units;
    
    Transport(String source,String destination, int charges_per_ten_units)
    {
        this.source=source;
        this.destination=destination;
        this.charges_per_ten_units=charges_per_ten_units;
    }
    
    public int getChargesPerTransport()
    {
        return charges_per_ten_units;
    }
    
}
