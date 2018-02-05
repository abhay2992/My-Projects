
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomerRequest
{
    Customer customer;
    ArrayList <Day> days;

    public CustomerRequest()
    {
        Scanner scan=new Scanner(System.in);
        String input= scan.nextLine();
        StringTokenizer st_colan=new StringTokenizer(input,":");
        
        customer=new Customer(st_colan.nextToken());
        
        StringTokenizer st_comma=new StringTokenizer(st_colan.nextToken(),",");
        
        days=new ArrayList<>();
        
        while(st_comma.hasMoreTokens())
        {
            StringTokenizer st_braces=new StringTokenizer(st_comma.nextToken(),"()");
            st_braces.nextToken();
            
            Day type=new Day(st_braces.nextToken());
            days.add(type);
        }
        
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public ArrayList<Day> getListOfDays()
    {
        return days;
    }

    public static void main(String[] args)
    {
        HotelBranch x=new HotelBranch("x","Miami", 3, 100, 120, 90, 95);
        HotelBranch y=new HotelBranch("y","Miami", 5, 150, 140, 80, 85);
        HotelBranch z=new HotelBranch("z","Miami", 4, 195, 150, 120, 90);
        
        Hotel tipton=new Hotel("Tipton");
        tipton.addBranch(x);
        tipton.addBranch(y);
        tipton.addBranch(z);
        
        CustomerRequest request=new CustomerRequest();
        
        
        ArrayList<HotelCharges> hotel_charges=new ArrayList<>();
        
        int charge=0;

        
        for(int j=0;j<tipton.getHotelBranches().size();j++)
        {
            for(int i=0;i<request.getListOfDays().size();i++)
            {
                charge=charge+tipton.getHotelBranches().get(j).getCharges(request.getCustomer(), request.getListOfDays().get(i));
                
            }
            
            HotelCharges hotel_charge=new HotelCharges(tipton.getHotelBranches().get(j), charge);
            hotel_charges.add(hotel_charge);
        
        }
        
        int min_charge=hotel_charges.get(0).charge;
        for(int i=0;i<hotel_charges.size();i++)
        {
            if(min_charge>hotel_charges.get(i).charge)
            {
                min_charge=hotel_charges.get(i).charge;
            }
        }
        
        ArrayList<HotelBranch> min_charge_hotels=new ArrayList<>();
        int count=0;
        for(int i=0;i<hotel_charges.size();i++)
        {
            if(min_charge==hotel_charges.get(i).charge)
            {
                count++;
                min_charge_hotels.add(hotel_charges.get(i).hotel);
            }
            
        }
        
        HotelBranch max_profit_hotel=null;
        
        if(count==1)
        {
            max_profit_hotel=min_charge_hotels.get(0);
        }
        
        else
        {
            int max_hotel_rating=min_charge_hotels.get(0).getRatingStars();
            
            for(int i=0;i<min_charge_hotels.size();i++)
            {
                if(max_hotel_rating<min_charge_hotels.get(i).getRatingStars())
                {
                    max_hotel_rating=min_charge_hotels.get(i).getRatingStars();
                    max_profit_hotel=min_charge_hotels.get(i);
                }
            }
        }
            
        System.out.println(max_profit_hotel.getName()+":"+min_charge);
        
    }
}
