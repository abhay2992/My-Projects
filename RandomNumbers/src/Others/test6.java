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
enum PrinterType {

    DESKJET, INKJET, Laser
}

public class test6 {

    PrinterType printerType;

    test6(PrinterType p) {
        printerType = p;
    }

    public void feature() {
// switch based on the printer type passed in the constructor
        switch (printerType) {
            case DESKJET:
                System.out.println("Dot-matrix printers are economical and almost obsolete");
                break;
            case INKJET:
                System.out.println("Inkjet printers provide decent quality prints");
                break;
            case Laser:
                System.out.println("Laser printers provide best quality prints");
                break;
        }
    }

    public static void main(String[] args) {
        test6 obj = new test6(PrinterType.INKJET);

    }

}
