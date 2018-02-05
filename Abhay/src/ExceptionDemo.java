
import java.util.Scanner;

class Abc
{
    void test()
    {
        int age;
        try
        {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter your age: ");
         age=sc.nextInt();
         if(age<0)
             throw (new AgeLessThanZeroException(age));
         else
                System.out.println("Your age is : "+age);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        
    }
}


public class ExceptionDemo 
{
    public static void main(String[] args)
    {
        Abc obj=new Abc();
        obj.test();
        
    }
}
