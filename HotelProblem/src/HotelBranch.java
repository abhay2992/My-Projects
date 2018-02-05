public class HotelBranch
{
    private String name;
    private String location;
    private int rating_stars;
    private int charges_regular_weekdays;
    private int charges_regular_weekends;
    private int charges_rewardee_weekdays;
    private int charges_rewardee_weekends;

    public HotelBranch(String name, String location, int rating_stars, int charges_regular_weekdays, int charges_regular_weekends, int charges_rewardee_weekdays, int charges_rewardee_weekends )
    {
        this.name=name;
        this.location=location;
        this.rating_stars=rating_stars;
        this.charges_regular_weekdays=charges_regular_weekdays;
        this.charges_regular_weekends=charges_regular_weekends;
        this.charges_rewardee_weekdays=charges_rewardee_weekdays;
        this.charges_rewardee_weekends=charges_rewardee_weekends;
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getRatingStars()
    {
        return rating_stars;
    }
    
    int getCharges(Customer customer, Day day)
    {
        if(customer.getType().equalsIgnoreCase("Regular"))
        {
            if(day.getDayType().equalsIgnoreCase("weekday"))
            {
                return charges_regular_weekdays;
            }
            else
            {
                return charges_regular_weekends;
            }
        }
        else
        {
            if(day.getDayType().equalsIgnoreCase("weekday"))
            {
                return charges_rewardee_weekdays;
            }
            else
            {
                return charges_rewardee_weekends;
            }
        }
 
    }

}

