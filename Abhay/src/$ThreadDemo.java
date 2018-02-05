class A implements Runnable
{
    Thread t1;
    A()
    {
        t1=new Thread(this);
        t1.start();
    }
       public void run()
    {
        for(int i=1;i<=10000;i++)
        {
            System.out.println(t1.getName()+"From A: "+i);
        }
    }
}
public class $ThreadDemo
{    
    public static void main(String[] args)
    {
        A task1=new A();
        A task2=new A();
        
    }
}