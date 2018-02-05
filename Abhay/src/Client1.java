import java.net.*;
import java.io.*;
public class Client1
{
    Socket s;
    BufferedReader br;
    PrintWriter pw;
    DataInputStream dis;
    File f=new File("D:\\Downloads");
    
    Client1()
    {
        try
        {
            s=new Socket("127.0.0.1",8800);
            br= new BufferedReader(new InputStreamReader(System.in));
            pw=new PrintWriter(s.getOutputStream());
            dis=new DataInputStream(s.getInputStream());
            int x=dis.readInt();
            for(int i=0;i<x;i++)
            {
                int bb=dis.readInt();
                byte b[]=new byte[bb];
                dis.read(b,0,bb);
                for(int c=0;c<bb;c++)
                {
                    System.out.print((char)b[c]);
                }
                System.out.println();
            }
            String a=br.readLine();
            pw.println(a);
            pw.flush();
            boolean bool=dis.readBoolean();
            if(bool)
            {
                long l=dis.readLong();
                System.out.println("Length of File "+a+" is : "+l);
                System.out.println("Downloading File..");                 // How to put a delay..??
                FileOutputStream fos=new FileOutputStream(f.getPath()+a,true);
                int r;
                byte b[]=new byte[1000000];
                while(true)
                {
                    r=dis.readInt();
                    if(r==-1)
                    {
                        break;
                    }
                    dis.read(b,0,r);
                    fos.write(b,0,r);
                    
                }
                System.out.println("File Downloaded.");
                
            }
            else
            {
                System.out.println("File "+a+" does not exists at the Server.");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
     
    public static void main(String[] args)
    {
        Client1 obj=new Client1();
        
    }
    
}
