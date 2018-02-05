/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

/**
 *
 * @author Abhay
 */
public class Power {
    static int i=1;
    public static long powerOf(int a, int b)
    {
        System.out.println("i: "+ i++);
        if(b==0)
            return 1;
        if(b==1)
            return a;
        long x=powerOf(a, b/2);
        if(b%2!=0)
            return x*x*a;
        else
            return x*x;
    }
    
    public static void main(String[] args) {
        System.out.println(powerOf(2, 20));    
    }
    
}
