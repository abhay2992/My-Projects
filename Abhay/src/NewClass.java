public class NewClass
{
    
   
    boolean isPrime(int n)
    {
        int flag=0;
        for(int i=2; i<n; i++)
        {
            
            if(n%i==0)
            {
                flag=1;
                break;
            }
        }
            if(flag==0)
            {
                return true;
            }
            else
            {
                return false;
            }
    }
        
    
    public static void main(String args[])
    {
        NewClass obj = new NewClass();
        for(int i=2; i<=12; i++)
        {
            boolean b = obj.isPrime(i);
            if(b==true)
            {
                System.out.println(i);
            }
        }
    }
    
}
