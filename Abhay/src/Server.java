import java.net.*;
import java.io.*;

public class Server
{
    ServerSocket ss;
    Socket s;
    PrintWriter pw;
    BufferedReader br, brk;
    Server()
    {
        try
        {
            ss=new ServerSocket(9900);
            System.out.println("Server Started..");
            s=ss.accept();
            System.out.println("Connection Build..");
            br=new BufferedReader(new InputStreamReader(System.in));
            brk=new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(s.getOutputStream());
            pw.println("Welcome User.");
            pw.println("Start Chatting..");
            pw.flush();
            
            Receiver r=new Receiver();
            Sender s=new Sender();
            
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    class Receiver implements Runnable
        {
            Thread t2;
            Receiver()
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
                        String a= brk.readLine();
                        if(a==null)
                        {
                            System.out.println("Client is down.");
                            break;
                        }
                        System.out.println("Client : "+a);
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
            Thread t1;
            Sender()
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
                        String a= br.readLine();
                        pw.println("Server : "+a);
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
        Server obj=new Server();
        
        
    }
}

