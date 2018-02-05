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
class Ink {
}

interface Printable {
}

class ColorInk extends Ink implements Printable {
}

class BlackInk extends Ink {
}

class TwistInTaleCasting {

    public static void main(String args[]) {
        Printable printable = null;
        BlackInk blackInk = new BlackInk();
        printable = (Printable) blackInk;
    }
}
