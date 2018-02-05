import java.io.*;
import java.net.*;
public class Server1
{
    ServerSocket ss;
    Socket s;
    DataOutputStream dos;
    BufferedReader br,brk;
    File f=new File("D:\\Demo");
    Server1()
    {
        try
        {
             ss=new ServerSocket(8800);
             s=ss.accept();
             br= new BufferedReader(new InputStreamReader(System.in));
             brk= new BufferedReader(new InputStreamReader(s.getInputStream()));
             dos=new DataOutputStream(s.getOutputStream());
             String a[]= f.list();
             //byte b=(byte)a.length;
             dos.writeInt(a.length);
             for(int i=0;i<a.length;i++)
             {
                 dos.writeInt(a[i].length());
                 byte b[]=new byte[a[i].length()];
                 for(int j=0;j<a[i].length();j++)
                 {
                     b[j]=(byte)a[i].charAt(j);
                 }
                 dos.write(b,0,a[i].length());
             }
             //dos.writeBytes("Enter the name of the File you want to download : ");            //How to send this line over dos so that it can be read over dis without any conversion to char array and then further byte array..
             String z=brk.readLine();
             System.out.println("hiii");
             File g= new File(f.getPath()+z);
             
             if(g.exists())
             {
                dos.writeBoolean(true);
                FileInputStream fis= new FileInputStream(g);
                long l=g.length();                  //Also try g.available()..
                dos.writeLong(l);
                int r;
                byte b[]=new byte[1000000];
                while(true)
                {
                    r=fis.read(b,0,1000000);
                    dos.writeInt(r);
                    if(r==-1)
                    {
                        break;
                    }
                    dos.write(b,0,r);
                }
             }
             else
             {
                 dos.writeBoolean(false);
             }
            }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args)
    {
        Server1 obj=new Server1();
        
    }
    
}
