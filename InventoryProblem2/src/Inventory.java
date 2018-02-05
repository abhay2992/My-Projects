public class Inventory
{
    private int item_id;
    private String item_name;
    private int qty;
    private int cost_per_item;

    public Inventory(int item_id,String item_name, int qty, int cost_per_item )
    {
        this.item_id=item_id;
        this.item_name=item_name;
        this.qty=qty;
        this.cost_per_item=cost_per_item;
    }
    
    public String getItemName()
    {
        return item_name;
    }
    
    public int getItemQty()
    {
        return qty;
    }
    public int getCostPerItem()
    {
        return cost_per_item;
    }
    
}
