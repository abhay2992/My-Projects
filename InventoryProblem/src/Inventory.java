public class Inventory
{
    private int item_id;
    private String item_name;
    private int cost_per_item;
    private int qty;
    
    Inventory(int item_id, String item_name, int cost, int qty)
    {
        this.item_id=item_id;
        this.item_name=item_name;
        this.cost_per_item= cost;
        this.qty=qty;
    }
    
    public int getQty()
    {
            return qty;
    }
    public int getCostPerItem()
    {
        return cost_per_item;
    }

}

