/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;

/**
 *
 * @author Abhay
 */
public class Test {
    
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int startIndex=0, count=0;
            long sum=0;
	    
            printArrayList(a);
	    for(int i=0; i<a.size(); i++)
	    {
	        if(a.get(i)>=0)
	        {
	            int tempStartIndex=i, tempCount=0;
                    long tempSum=0;
	            while(i<a.size() && a.get(i)>=0)
	            {
	                tempCount=tempCount+1;
	                tempSum=tempSum+a.get(i);
	                i++;
	            }
	            
                    System.out.println("TempCount: "+tempCount);
                    System.out.println("TempSum: "+tempSum);
	            if(tempSum>sum)
	            {
	                sum=tempSum;
	                count=tempCount;
	                startIndex=tempStartIndex;
	            }
	            else if(tempSum==sum)
	            {
	                if(tempCount>count)
	                {
	                    count=tempCount;
	                    startIndex=tempStartIndex;
	                }
	                else if(tempCount==count)
	                {
	                    //Control will never go into ths if-statement as tempIndex is always greater than
	                    //previous startIndex.. as the loop is incrementing i..
	                    if(tempStartIndex<startIndex)
	                    {
	                        startIndex=tempStartIndex;
	                    }
	                }
	            }
	        }
	    }
	    
            System.out.println("Start Index: "+startIndex);
            System.out.println("Count: "+count);
            System.out.println("Sum: "+sum);
	    ArrayList<Integer> result=new ArrayList<>();
	    for(int i=startIndex;i<(startIndex+count);i++)
	    {
	        result.add(a.get(i));
	    }
        
        return result;
        
	    
	}
    
    public void printArrayList(ArrayList<Integer> a)
    {
        for(int i: a)
        {
            System.out.print(i+", ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Test test=new Test();
        ArrayList<Integer> input=new ArrayList<>();
        
        input.add(1967513926);
        input.add(1540383426);
        input.add(-1303455736);
        input.add(-521595368);
        
        test.printArrayList(test.maxset(input));
        
    }
}

