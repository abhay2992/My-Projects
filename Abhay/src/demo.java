import java.io.*;
public class demo
{
    public static void main(String[] args) throws Exception
    {
        File f= new File("D:\\asd.txt");
        FileOutputStream fos=new FileOutputStream(f);
        DataOutputStream dos= new DataOutputStream(fos);
        FileInputStream fis = new FileInputStream("D:\\qwe.txt");
        //String []s=f.list();
        //for(int i=0;i<s.length;i++)
          //  System.out.println(s[i]);
        DataInputStream dis=new DataInputStream(fis);
       // byte b[]=new byte[1000];
        int read = dis.read();
        dos.write(read);
        //if(r==-1)
        // dos.writeBytes(r);
        //System.out.print(dis.read(b,0,r));

        
    }
}
