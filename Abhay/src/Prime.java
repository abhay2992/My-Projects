import java.io.*;
public class Prime 
{
    void prime_no(int m)
    {
        if(m==0||m==1)
            System.out.println("It is not a Prime Number.");
        else if(m==2)
            System.out.println("It is a Prime Number.");
        else
        {
            int i;
            for(i=2;i<m;i++)
            {
                if(m%i==0)
                {
                    System.out.println("It is not a Prime Number.");
                    break;
                }
            }
            if(i==m)
                System.out.println("It is a Prime Number.");
        }
        
    }
    public static void main(String[] args)throws IOException 
    {
        Prime obj=new Prime();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a Number: ");
        int x=Integer.parseInt(br.readLine());
        obj.prime_no(x);
    }
    
}
