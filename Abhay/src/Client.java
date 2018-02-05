import java.net.*;
import java.io.*;
public class Client
{
    Socket s;
    PrintWriter pw;
    BufferedReader br, brk;
    Client()
    {
        try
        {
            s=new Socket("127.0.0.1", 9900);
            System.out.println("Connection build.");
            pw=new PrintWriter(s.getOutputStream());
            br=new BufferedReader(new InputStreamReader(System.in));
            brk=new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(brk.readLine());
            System.out.println(brk.readLine());
            Receiver r= new Receiver();
            Sender s= new Sender();
        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    class Receiver implements Runnable
    {
        Thread t1;
        Receiver()
        {
            t1=new Thread(this);
            t1.start();
        }
        public void run()
        {
            try
            {
                while(true)
                {
                    String a=brk.readLine();
                    System.out.println(a);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    class Sender implements Runnable
    {
        Thread t2;
        Sender()
        {
            t2=new Thread(this);
            t2.start();
        }
        public void run()
        {
            try
            {
                while(true)
                {
                    String a=br.readLine();
                    pw.println(a);
                    pw.flush();
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        Client obj=new Client();
        
    }
    
    
}
