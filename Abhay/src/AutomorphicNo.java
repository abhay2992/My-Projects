import java.util.*;
public class AutomorphicNo 
{
    Scanner sc= new Scanner(System.in);
    long num, s=0,i;
    AutomorphicNo()
    {
        System.out.print("Enter a no.: ");
        num=sc.nextLong();
    }
    
    void test()
    {
        long c=num;
        long a=num*num;
        for(i=c;i>0;i=i/10)
        {
           long j=i%10;
           long k=a%10;
           if(j==k)
           {
               a=a/10;
               continue;
           }
           else
               break;
               
        }
        if (i==0)
            System.out.println(num+" is an Automorphic No.");
        else
            System.out.println(num+" is Not an Automorphic No.");
    }
    
    public static void main(String[] args) 
    {
        AutomorphicNo obj=new AutomorphicNo();
        obj.test();
    }
    
}
   
    