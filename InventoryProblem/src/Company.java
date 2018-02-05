public class Company
{
    private String loc;
    private Inventory inv;
    Company(String loc, Inventory inv)
    {
        this.loc= loc;
        this.inv=inv;
    }
    
    public String getName()
    {
        return loc;
    }
    
    public Inventory getInventory()
    {
        return inv;
    }
    
}
