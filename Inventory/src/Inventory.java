public class Inventory
{
    int id, qty;
    String item, owner;
    float price;
    
    public Inventory(int id, String item, int qty, float price, String owner)
    {
        this.id = id;
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.owner = owner;
    }
    
}
