import java.io.*;
public class TwinPrime 
{
    void prime_no(int m,int n)
    {
        int i,c=3;
            for(i=m;i<=n;i++)
            {
                if(i==3)
                        System.out.print("3  ");
                else
                {
                   int j;
                   for(j=2;j<=i;j++)
                   {                 
                        if(i%j==0)
                            break;
                   
                   }
                
                   if(j==i)
                   {
                       if((i-c)==2)
                        System.out.print("\t"+c+"\t"+(c+2)); //What to do if three twin prime consecutive nos. appear.. par hai nai koi other than 3,5,7.
                       c=i;
                   }
                 }
            }
            
    }
        
    public static void main(String[] args)throws IOException 
    {
        TwinPrime obj=new TwinPrime();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Starting Number: ");
        int x=Integer.parseInt(br.readLine());
        System.out.print("Enter the Ending Number: ");
        int y=Integer.parseInt(br.readLine());
        obj.prime_no(x,y);
    }
    
}