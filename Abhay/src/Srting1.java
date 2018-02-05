// Program to input a String and calculate frequency of each character.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Srting1 
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr= new InputStreamReader(System.in); 
        BufferedReader br= new BufferedReader(isr);
        char c='\u0000';
        System.out.println(c);
        System.out.println("Enter the String: ");
        String s=br.readLine();
        int l=s.length();
        
        for(int i=0;i<l;i++)
        {
            int count=0;
            char ch= s.charAt(i);
            if(ch!=c)
            {
                for(int j=i;j<l;j++)
                {
                    if(ch==s.charAt(j))
                    {    
                        count++;
                    }
                }
                System.out.println(ch+" occurs "+count+" times");
                s=s.replace(ch,c);
            }
            
        }
        
    }
       
    
}

