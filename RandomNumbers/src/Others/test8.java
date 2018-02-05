/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Abhay
 */
public class test8 {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> arr= new ArrayList<>(2*a-1);
	    
	   // int [][] array=new int[2*a-1][2*a-1];
	    
	    for(int i=0;i< ((2*a)-1);i++)
	    {
	        ArrayList<Integer> tempList=new ArrayList<>(Collections.nCopies(2*a-1,0));
	        arr.add(tempList);
	    }
	    
	    
	    int startX=a-1, endX=a-1;
	    int startY=a-1, endY=a-1;
	    int value=1;
	    
	    for(int x=value; x<=a; x++)
	    {
	        for(int a1=startY;a1<=endY;a1++)
	        {
	             arr.get(startX).set(a1, x);
	        }
	        
	        for(int a2=startX+1;a2<=endX;a2++)
	        {
	             arr.get(a2).set(endY, x);
	        }
	        
	        for(int a3=endY-1;a3>=startY;a3--)
	        {
	             arr.get(endX).set(a3, x);
	        }
	        
	        for(int a4=endX-1;a4>=startX+1;a4--)
	        {
	             arr.get(a4).set(startY, x);
	        }
	        
	        startX--;
	        startY--;
	        endX++;
	        endY++;
	    }
	   
	   return arr;
	    
	}
        
        public static void main(String[] args) {
            System.out.println(new test8().prettyPrint(3));
    }
}
