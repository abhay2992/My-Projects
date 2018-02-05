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
class test5 {

    public static void main(String[] args) {
        String[][] oldLaptops
                = {{"Dell", "Toshiba", "Vaio"}, null,
                {"IBM"}, new String[10]};
        System.out.println(oldLaptops[0][0]); // line 1
        System.out.println(oldLaptops[1]); // line 2
        System.out.println(oldLaptops[3][6]); // line 3
        System.out.println(oldLaptops[3][0].length()); // line 4
        System.out.println(oldLaptops); // line 5
    }
}