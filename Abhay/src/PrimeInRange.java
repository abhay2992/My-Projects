import java.io.*;
public class PrimeInRange 
{
    void prime_no(int m,int n)
    {
        int i;
            for(i=m;i<=n;i++)
            {
                if(i==2)
                        System.out.print("2  ");
                else
                {
                   int j;
                   for(j=2;j<i;j++)  //if condition is j<=i. then it should work otherwise not. But still it is working.
                   {                 
                        if(i%j==0)
                            break;
                   
                   }
                   if(j==i)
                       System.out.print(i+"  ");
                 }
            }
            
    }
        
    public static void main(String[] args)throws IOException 
    {
        PrimeInRange obj=new PrimeInRange();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Starting Number: ");
        int x=Integer.parseInt(br.readLine());
        System.out.print("Enter the Ending Number: ");
        int y=Integer.parseInt(br.readLine());
        obj.prime_no(x,y);
    }
    
}
