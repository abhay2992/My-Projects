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
public class test2 {
    
    public static boolean isAnagram(String s1, String s2)
    {
        int len1=s1.length();
        int len2=s2.length();
        
        if(len1!=len2)
        {
            return false;
        }
        
        int temp=0;
        for(int i=0; i<len1; i++)
        {
            temp=temp^s1.charAt(i)^s2.charAt(i);
        }
        
        return (0==temp);
    }

    public static void main(String[] args) {
        
        String s1="abbacazoxx";
        String s2="bbcaaxoazx";
        
        System.out.println(isAnagram(s1, s2));
        
    }
}
