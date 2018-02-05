import java.net.*;
import java.io.*;
import java.util.*;
public class Client2
{
    Socket s;
    BufferedReader br;
    PrintWriter pw;
    DataInputStream dis;
    File f=new File("D:\\Downloads");
    
    Client2()
    {   
        String a;
        try
        {
            s=new Socket("127.0.0.1",7700);
            br= new BufferedReader(new InputStreamReader(System.in));
            pw=new PrintWriter(s.getOutputStream());
            dis=new DataInputStream(s.getInputStream());
            int x=dis.readInt();
            while(true)
            {
                a=dis.readLine();
                System.out.println(a);
                if(a.startsWith("Files"))
                {
                    for(int i=0;i<x;i++)
                    {
                        System.out.println(dis.readLine());
                    }
                    
                }
                else if(a.startsWith("Enter"))
                {
                    a=br.readLine();
                    pw.println(a);
                    pw.flush();
                }
                else
                {
                    break;
                }
                
            }
            
            boolean bool=dis.readBoolean();
            if(bool==true)
            {
                    a=dis.readLine();
                    if(a.startsWith("Size"))
                    {
                        StringTokenizer st=new StringTokenizer(a);
                        int n=st.countTokens();
                        for(int j=0;j<n;j++)
                        {
                            if(j==n-1)
                            {
                                long l=Long.parseLong(st.nextToken());
                                System.out.print(l);
                            }
                            System.out.print(st.nextToken());
                        }
                    }
                    
                    else
                    {
                        FileOutputStream fos=new FileOutputStream(f.getPath()+a,true);
                        int r;
                        byte b[]=new byte[1000000];
                        while(true)
                        {
                            r=dis.read(b,0,1000000);
                            if(r==-1)
                            {
                                break;
                            }
                            fos.write(b,0,r);
                    
                        }
                        System.out.println("File Downloaded.");
                
                    }     
            }
            else
            {
                System.out.println("File not found.");
            }
            
            
        }        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
     
    public static void main(String[] args)
    {
        Client2 obj=new Client2();
        
    }
    
}
