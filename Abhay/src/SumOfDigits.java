import java.util.*;
public class SumOfDigits 
{
    Scanner sc= new Scanner(System.in);
    long num, s=0;
    SumOfDigits()
    {
        System.out.println("Enter a no.: ");
        num=sc.nextLong();
    }
    
    long sum()
    {
        for(long i=num;i>0;i=i/10)
        {
           long j=i%10;
           s=s+j;
        }
        return s;
    }
    
    public static void main(String[] args) 
    {
        SumOfDigits obj=new SumOfDigits();
        System.out.println("Sum is: "+obj.sum());
    }
    
}
