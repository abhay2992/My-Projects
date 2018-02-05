
import java.util.Scanner;

// Program to input a String and count no. of letters, digits and special symbols.

public class String2
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String:");
        String s=sc.nextLine();
        int count1=0,count2=0,count3=0;
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if(Character.isLetter(ch))
                count1++;   
            else if(Character.isDigit(ch))
                count2++;
            else
                count3++;
        }
        System.out. println("No. of Letters: "+count1);
        System.out. println("No. of Digits: "+count2);
        System.out. println("No. of Special Symbols: "+count3);
    }
}