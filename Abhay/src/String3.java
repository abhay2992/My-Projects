// Program to input a string and print it in the following pattern:- 
//   ABCDE :-  A
//             AB
//             ABC
//             ABCD
//             ABCDE
import java.util.*;
public class String3
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner (System.in);
        System.out.println ("Enter the String: ");
        String s= sc.nextLine();
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            System.out.println(s.substring(0,i+1));
        }
    }
}
