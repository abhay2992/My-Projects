
import com.sun.jmx.remote.util.OrderClassLoaders;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProcessOrder
{
    private String country_of_purchase;
    private int ordered_untis;

    public ProcessOrder()
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        StringTokenizer st=new StringTokenizer(input, ":");
        country_of_purchase=st.nextToken();
        ordered_untis=Integer.parseInt(st.nextToken());
    }
    
    public String getCountryOfPurchase()
    {
        return country_of_purchase;
    }    
    
    public int getOrderedUnits()
    {
        return ordered_untis;
    }
    
    public static void main(String[] args)
    {
        Company apple=new Company("Apple");
        
        Company_Branch apple_argentina=new Company_Branch("Argentina");
        Company_Branch apple_brazil=new Company_Branch("brazil");
        
        apple.addCompanyBranch(apple_argentina);
        apple.addCompanyBranch(apple_brazil);
        
        apple_brazil.addItem(new Inventory(1,"ipod",100,100));
        apple_argentina.addItem(new Inventory(1,"ipod",100,70));
        
        Transport brazil_to_argentina=new Transport("Brazil", "Argentina",300);
        Transport argentina_to_brazil=new Transport("Argentina","Brazil", 300);
        
        ProcessOrder order=new ProcessOrder();
        
        Inventory apple_brazil_ipods=null, apple_argentina_ipods=null;
        
        for(int i=0;i<apple.getCompanyBranches().size();i++)
        {
            if(apple.getCompanyBranches().get(i).getLocation().equalsIgnoreCase("Argentina"))
            {
                for(int j=0;j<apple.getCompanyBranches().get(i).getItemList().size();j++)
                {
                    if(apple.getCompanyBranches().get(i).getItemList().get(j).getItemName().equalsIgnoreCase("ipod"))
                    {
                        apple_argentina_ipods=apple.getCompanyBranches().get(i).getItemList().get(j);
                    }
                    
                }
                
            }
            
            else if(apple.getCompanyBranches().get(i).getLocation().equalsIgnoreCase("Brazil"))
            {
                for(int j=0;j<apple.getCompanyBranches().get(i).getItemList().size();j++)
                {
                    if(apple.getCompanyBranches().get(i).getItemList().get(j).getItemName().equalsIgnoreCase("ipod"))
                    {
                        apple_brazil_ipods=apple.getCompanyBranches().get(i).getItemList().get(j);
                    }
                    
                }
                
            }
        }
        
        if(order.getOrderedUnits()<=(apple_brazil_ipods.getItemQty()+apple_argentina_ipods.getItemQty()))
        {
            int break_point=0;
            int stock_left_argentina=0,stock_left_brazil=0, cost=0;
            if(order.getCountryOfPurchase().equalsIgnoreCase("Brazil"))
            {
                int import_charge=argentina_to_brazil.getChargesPerTransport();
                
                for(int i=1;i<=10;i++)
                {
                    if((apple_brazil_ipods.getCostPerItem()*i)>=((apple_argentina_ipods.getCostPerItem()*i)+import_charge))
                    {
                        break_point=i;
                    }
                }
                
                if(break_point!=0)
                {
                    int remainder_ipods=order.getOrderedUnits()%10;
                    int integral_ipods=order.getOrderedUnits()-remainder_ipods;
                    if(order.getOrderedUnits()>=apple_argentina_ipods.getItemQty())
                    {
                        stock_left_argentina=0;
                        stock_left_brazil=apple_brazil_ipods.getItemQty()-(order.getOrderedUnits()-apple_argentina_ipods.getItemQty());
                    }
                    else
                    {
                        stock_left_argentina=apple_argentina_ipods.getItemQty()-integral_ipods;
                        if(remainder_ipods<=break_point)
                        {
                            stock_left_brazil=apple_brazil_ipods.getItemQty()-remainder_ipods;
                        }
                        else
                        {
                            stock_left_brazil=apple_brazil_ipods.getItemQty();
                            stock_left_argentina=stock_left_argentina-remainder_ipods;
                        }
                    }
                }
                else
                {
                    if(order.getOrderedUnits()>=apple_brazil_ipods.getItemQty())
                    {
                        stock_left_brazil=0;
                        stock_left_argentina=apple_argentina_ipods.getItemQty()-(order.getOrderedUnits()-apple_brazil_ipods.getItemQty());
                    }
                    else
                    {
                        stock_left_brazil=apple_brazil_ipods.getItemQty()-order.getOrderedUnits();
                        stock_left_argentina=apple_argentina_ipods.getItemQty();
                    }
                }
                
                cost=(apple_argentina_ipods.getCostPerItem()*(apple_argentina_ipods.getItemQty()-stock_left_argentina))+(import_charge*((apple_argentina_ipods.getItemQty()-stock_left_argentina)/10))+apple_brazil_ipods.getCostPerItem()*(apple_brazil_ipods.getItemQty()-stock_left_brazil);


            }
            else if(order.getCountryOfPurchase().equalsIgnoreCase("Argentina"))
            {
                int import_charge=brazil_to_argentina.getChargesPerTransport();
                
                for(int i=1;i<=10;i++)
                {
                    if((apple_argentina_ipods.getCostPerItem()*i)>=((apple_brazil_ipods.getCostPerItem()*i)+import_charge))
                    {
                        break_point=i;
                        break;
                    }
                }
                
                if(break_point!=0)
                {
                    int remainder_ipods=order.getOrderedUnits()%10;
                    int integral_ipods=order.getOrderedUnits()-remainder_ipods;
                    if(order.getOrderedUnits()>=apple_brazil_ipods.getItemQty())
                    {
                        stock_left_brazil=0;
                        stock_left_argentina=apple_argentina_ipods.getItemQty()-(order.getOrderedUnits()-apple_brazil_ipods.getItemQty());
                    }
                    else
                    {
                        stock_left_brazil=apple_brazil_ipods.getItemQty()-integral_ipods;
                        if(remainder_ipods<=break_point)
                        {
                            stock_left_argentina=apple_argentina_ipods.getItemQty()-remainder_ipods;
                        }
                        else
                        {
                            stock_left_argentina=apple_argentina_ipods.getItemQty();
                            stock_left_brazil=stock_left_brazil-remainder_ipods;
                        }
                    }
                }
                else
                {
                    if(order.getOrderedUnits()>=apple_argentina_ipods.getItemQty())
                    {
                        stock_left_argentina=0;
                        stock_left_brazil=apple_brazil_ipods.getItemQty()-(order.getOrderedUnits()-apple_argentina_ipods.getItemQty());
                    }
                    else
                    {
                        stock_left_argentina=apple_argentina_ipods.getItemQty()-order.getOrderedUnits();
                        stock_left_brazil=apple_brazil_ipods.getItemQty();
                    }
                }
                
                cost=(apple_brazil_ipods.getCostPerItem()*(apple_brazil_ipods.getItemQty()-stock_left_brazil))+(import_charge*((apple_brazil_ipods.getItemQty()-stock_left_brazil)/10))+(apple_argentina_ipods.getCostPerItem()*(apple_argentina_ipods.getItemQty()-stock_left_argentina));

                
            }
            
            System.out.println(cost+":"+stock_left_brazil+":"+stock_left_argentina);
            
            
        }
        else
        {
            System.out.println("Out of Stock.");
        }
        
    }
}
