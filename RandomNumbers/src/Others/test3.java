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

//Program To check whether the Exception handler works when an Error is Thrown
public class test3 {
    
    void start()
    {
        try{
            loop(1);
        }
        catch(StackOverflowError e){
            for(int i=0; i<10; i++)
            {
                System.out.println("Hi: "+1);
            }
        }
    }
    
    void loop(int x)
    {
        System.out.println("In Loop: "+ x++);
        loop(x);
    }
    public static void main(String[] args) {
        test3 obj=new test3();
        
        obj.start();
                
    }
}
