import java.io.*;
import java.net.*;
public class Receiver
{
    Socket sock;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedReader br;
    String s;
    Receiver()
    {
        try
        {
            sock = new Socket("192.168.137.3",9800);
            System.out.println("Connection build with server");
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                System.out.println("Enter command : ");
                s = br.readLine();
                if(s.equals("send list"))
                {
                     dos.writeBytes(s+"\r\n");
                     dos.flush();
                     int totalfiles = dis.readInt();
                     System.out.println("Total files at server : "+totalfiles);
                     for(int i=0; i<totalfiles; i++)
                     {
                         s = dis.readLine();
                         System.out.println("File "+i+" ---"+s);
                     }
                     System.out.println("Enter fileIndex to download : ");
                     int index = Integer.parseInt(br.readLine());
                     dos.writeInt(index);
                     long size = dis.readLong();
                     System.out.println("Size received : "+size);
                     long count=0;
                     int r;
                     byte b[] = new byte[1000];
                     FileOutputStream fos = new FileOutputStream("E:\\one.exe");
                     while(true)
                     {
                        r= dis.read(b,0,1000);
                         System.out.println(r+ " bytes received");
                        fos.write(b,0,r);
                        count= count+r;
                        if(count==size)
                            break;
                     }
                     fos.close();
                     System.out.println("File downloaded successfully");

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
        Receiver obj = new Receiver();
    }

}
