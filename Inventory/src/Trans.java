
import java.util.Date;

public class Trans
{
    String Date;
    String Item, sn,cn,owner;
    int qty;
    Float price,amt;
    
    Trans(String date,String owner, String item, int qty, float price, float amt, String sn,String cn)
    {
        this.Date=date;
        this.owner=owner;
        this.Item=item;
        this.qty=qty;
        this.price=price;
        this.amt=amt;
        this.cn=cn;
        this.sn=sn;
    }
    
    
    
}
