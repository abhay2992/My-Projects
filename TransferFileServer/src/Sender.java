import java.io.*;
import java.net.*;
public class Sender
{
    ServerSocket sersock;
    Socket sock;
    DataInputStream dis;
    DataOutputStream dos;
    String s;
    Sender()
    {
        try
        {
            sersock = new ServerSocket(9800);
            System.out.println("Server Started");
            sock = sersock.accept();
            System.out.println("Connection build");
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            while(true)
            {
                s = dis.readLine();
                System.out.println("Req from Receiver : "+s);
                if(s.equals("send list"))
                {
                    File f = new File("E:\\vmm software\\vmm");
                    String files[] = f.list();
                    dos.writeInt(files.length);
                    for(int i=0; i<files.length; i++)
                    {
                        dos.writeBytes(files[i]+"\r\n");
                        dos.flush();
                    }
                    int index = dis.readInt();
                    System.out.println("Index received : "+index);
                    File f1 = new File("E:\\vmm software\\vmm\\"+files[index]);
                    long size = f1.length();
                    dos.writeLong(size);
                    byte b[]  = new byte[1000];
                    int r=0;
                    long count=0;
                    FileInputStream fis = new FileInputStream(f1);
                    while(true)
                    {
                        r = fis.read(b,0,1000);
                       
                        dos.write(b,0,r);
                        System.out.println(r +" bytes sent");
                        count=count+r;
                        if(count==size)
                            break;
                    }
                    System.out.println("File sent successfully");
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        Sender obj = new Sender();
    }


}
