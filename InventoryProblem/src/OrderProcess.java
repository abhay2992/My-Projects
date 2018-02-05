
import java.util.Scanner;
import java.util.StringTokenizer;


public class OrderProcess
{
    private String country_of_purchase;
    private int no_of_units;
    
    OrderProcess() 
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        StringTokenizer st=new StringTokenizer(input,":");
        country_of_purchase=st.nextToken();
        no_of_units=Integer.parseInt(st.nextToken());
    
    }
    
    String getCountryOfPurchase()
    {
        return country_of_purchase;
    }
    
    int getOrderedUnits()
    {
        return no_of_units;
    }
    
    public static void main(String[] args)
    {
        int cost=0;
        int stock_left_brazil=0;
        int stock_left_argentina=0;
        
        Inventory inv_brazil = new Inventory(1, "ipod", 100, 100);
        Inventory inv_argentina = new Inventory(1, "ipod", 50, 100);
        
        Company tw_brazil=new Company("Brazil", inv_brazil);
        Company tw_argentina=new Company("Argentina", inv_argentina);
        
        Transport brazil_to_argentina=new Transport("Brazil", "Argentina", "ipod", 400, 10);
        Transport argentina_to_brazil=new Transport("Argentina","Brazil", "ipod", 400, 10);
        
        OrderProcess order=new OrderProcess();

        if(order.getOrderedUnits()<=((tw_brazil.getInventory().getQty())+(tw_argentina.getInventory().getQty())))
        {
            int brazil_ipod_cost=tw_brazil.getInventory().getCostPerItem();
            int argentina_ipod_cost=tw_argentina.getInventory().getCostPerItem();
            int brazil_ipod_qty=tw_brazil.getInventory().getQty();
            int argentina_ipod_qty=tw_argentina.getInventory().getQty();
            int break_point=0;
            
            if(order.getCountryOfPurchase().equalsIgnoreCase("Brazil"))
            {
                for(int i=1;i<=argentina_to_brazil.getUnitsPerTransport();i++)
                {
                    int import_charge=argentina_to_brazil.getChargesPerTransport();
                    
                    if((brazil_ipod_cost*i)>=((argentina_ipod_cost*i)+import_charge))
                    {
                        break_point=i;
                        break;
                    }
                    
                }
                
                if(break_point!=0)
                {
                    int ipods_1=order.getOrderedUnits()%argentina_to_brazil.getUnitsPerTransport();
                    int ipods_2=order.getOrderedUnits()-ipods_1;
                    
                    if(ipods_2>argentina_ipod_qty)
                    {
                        stock_left_argentina=argentina_ipod_qty%argentina_to_brazil.getUnitsPerTransport();
                        stock_left_brazil=brazil_ipod_qty-(order.getOrderedUnits()-(argentina_ipod_qty-stock_left_argentina));
                        
                        if(stock_left_brazil<0)
                        {
                            stock_left_brazil=stock_left_brazil+stock_left_argentina;
                            stock_left_argentina=0;
                        }
                    }
                    else
                    {
                        stock_left_argentina=argentina_ipod_qty-ipods_2;
                        if(ipods_1>=break_point)
                        {
                            stock_left_argentina=stock_left_argentina-ipods_1;
                            stock_left_brazil=brazil_ipod_qty;
                        }
                        else
                        {
                            stock_left_brazil=brazil_ipod_qty-ipods_1;
                        }
                    }
                }
                
                else
                {
                    if(order.getOrderedUnits()<=brazil_ipod_qty)
                    {
                        stock_left_brazil=brazil_ipod_qty-order.getOrderedUnits();
                        stock_left_argentina=argentina_ipod_qty;
                    }
                    else
                    {
                        stock_left_brazil=0;
                        stock_left_argentina=order.getOrderedUnits()-brazil_ipod_qty;
                    }
                }
                
                if((argentina_ipod_qty-stock_left_argentina)%argentina_to_brazil.getUnitsPerTransport()==0)
                {
                    cost=(((argentina_ipod_qty-stock_left_argentina)*argentina_ipod_cost)+(argentina_to_brazil.getChargesPerTransport()*((argentina_ipod_qty-stock_left_argentina)/argentina_to_brazil.getUnitsPerTransport())))+((brazil_ipod_qty-stock_left_brazil)*brazil_ipod_cost);
                }
                else
                {
                    cost=(((argentina_ipod_qty-stock_left_argentina)*argentina_ipod_cost)+(argentina_to_brazil.getChargesPerTransport()*((argentina_ipod_qty-stock_left_argentina)/argentina_to_brazil.getUnitsPerTransport()+1)))+((brazil_ipod_qty-stock_left_brazil)*brazil_ipod_cost);
                }

                
            }
            else if(order.getCountryOfPurchase().equalsIgnoreCase("Argentina"))
            {
                for(int i=1;i<=brazil_to_argentina.getUnitsPerTransport();i++)
                {
                    int import_charge=brazil_to_argentina.getChargesPerTransport();
                    
                    if((argentina_ipod_cost*i)>=((brazil_ipod_cost*i)+import_charge))
                    {
                        break_point=i;
                        break;
                    }
                    
                }
                
                if(break_point!=0)
                {
                    int ipods_1=order.getOrderedUnits()%brazil_to_argentina.getUnitsPerTransport();
                    int ipods_2=order.getOrderedUnits()-ipods_1;
                    
                    if(ipods_2>brazil_ipod_qty)
                    {
                        stock_left_brazil=brazil_ipod_qty%brazil_to_argentina.getUnitsPerTransport();
                        stock_left_argentina=argentina_ipod_qty-(order.getOrderedUnits()-(brazil_ipod_qty-stock_left_brazil));
                        
                        if(stock_left_argentina<0)
                        {
                            stock_left_argentina=stock_left_argentina+stock_left_brazil;
                            stock_left_brazil=0;
                        }
                    }
                    else
                    {
                        stock_left_brazil=brazil_ipod_qty-ipods_2;
                        if(ipods_1>=break_point)
                        {
                            stock_left_brazil=stock_left_brazil-ipods_1;
                            stock_left_argentina=argentina_ipod_qty;
                        }
                        else
                        {
                            stock_left_argentina=argentina_ipod_qty-ipods_1;
                        }
                    }
                }
                
                else
                {
                    if(order.getOrderedUnits()<=argentina_ipod_qty)
                    {
                        stock_left_argentina=argentina_ipod_qty-order.getOrderedUnits();
                        stock_left_brazil=brazil_ipod_qty;
                    }
                    else
                    {
                        stock_left_argentina=0;
                        stock_left_brazil=brazil_ipod_qty-(order.getOrderedUnits()-argentina_ipod_qty);
                    }
                }
                
                if((brazil_ipod_qty-stock_left_brazil)%brazil_to_argentina.getUnitsPerTransport()==0)
                {
                    cost=(((brazil_ipod_qty-stock_left_brazil)*brazil_ipod_cost)+(brazil_to_argentina.getChargesPerTransport()*((brazil_ipod_qty-stock_left_brazil)/brazil_to_argentina.getUnitsPerTransport())))+((argentina_ipod_qty-stock_left_argentina)*argentina_ipod_cost);
                }
                else
                {
                    cost=(((brazil_ipod_qty-stock_left_brazil)*brazil_ipod_cost)+(brazil_to_argentina.getChargesPerTransport()*((brazil_ipod_qty-stock_left_brazil)/brazil_to_argentina.getUnitsPerTransport()+1)))+((argentina_ipod_qty-stock_left_argentina)*argentina_ipod_cost);
                }
            }
            System.out.println("\n"+cost+":"+stock_left_brazil+":"+stock_left_argentina);
            
        }
        else
        {
            System.out.println("Out of Stock");
        }
        
    
    }
    
    
}
