public class Transport
{
    private String source;
    private String destination;
    private String item;
    private int charges_per_transport;
    private int units_per_transport;
    Transport(String source, String destination, String item,int charges_per_transport, int units_per_transport)
    {
        this.source=source;
        this.destination=destination;
        this.item=item;
        this.charges_per_transport=charges_per_transport;
        this.units_per_transport=units_per_transport;
    }
    
    public int getChargesPerTransport()
    {
        return charges_per_transport;
    }
    
    public int getUnitsPerTransport()
    {
        return units_per_transport;
    }
}
