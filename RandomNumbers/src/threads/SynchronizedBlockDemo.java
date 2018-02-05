/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Abhay
 */
public class SynchronizedBlockDemo extends Thread{

    final StringBuffer stringBuffer;
    public SynchronizedBlockDemo(StringBuffer stringBuffer) {
        this.stringBuffer=stringBuffer;
    }
    
    
    @Override
    public void run()
    {
        synchronized(stringBuffer)
        {
            for(int i = 1;i<=100;i++)
            {
                System.out.println(stringBuffer +" "+i);
            }
            char ch=stringBuffer.charAt(0);
            ch++;
            stringBuffer.replace(0, 1, Character.toString(ch));
            
            
        }
    }
    
    public static void main(String[] args) {
        StringBuffer s=new StringBuffer("A");
        StringBuffer s1=new StringBuffer("Z");
        SynchronizedBlockDemo thread1=new SynchronizedBlockDemo(s);
        SynchronizedBlockDemo thread2=new SynchronizedBlockDemo(s1);
//        SynchronizedBlockDemo thread3=new SynchronizedBlockDemo(s);
        
        thread1.start();
        thread2.start();
//        thread3.start();
    }
    
}
