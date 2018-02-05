import java.io.*;
public class Array1
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        System.out.println("Enter No. of Rows and columns: ");
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int arr[][]=new int[a][b];
        System.out.println("Enter the elements: ");
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
                arr[i][j]=Integer.parseInt(br.readLine());
        }
        
        System.out.println("Entered 2-D Array is: ");
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(j==b/2||i==a/2)
                    System.out.print(arr[i][j]+" ");
            }
                
        }
        
    }
   
}
