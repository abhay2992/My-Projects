// Program to input a String(name) and print initials.
import java.util.*;
public class String4
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String(Full Name): ");
        String s=sc.nextLine();
        s=s.trim();
        int l=s.length();
        char ch;
        int a;
        for(int i=0;i<l;i++)
        {
            if(i==0)
            {
                System.out.println(s.substring(0,i+1)+".");
            }
            else if(s.charAt(i)==' '&&s.charAt(i+1)!=' ')
            {
                //a=
            }
        }
        
    }
    
}
