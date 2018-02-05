/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbers;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// For TTS- Text to Speech
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

/**
 *
 * @author Abhay
 */
public class RandomNumbers extends JFrame implements ActionListener, KeyListener {

    private static Thread paintThread;
    JLabel label1, label2, label3, status, actualStatus;
    JButton button, startButton;
    JTextField textfield;
    ArrayList<Integer> arrayDone = new ArrayList<>();
    ArrayList<Integer> intArray;
    Random random;
    String allArrayLeft = "";
    String allArrayDone = "";
    public final static int startIndex = 1;
    public final static int endIndex = 91;

    Synthesizer synthesizer;
    boolean autoStart = false;

    public RandomNumbers() throws HeadlessException {

        setTitle("Tambola");
        setBounds(0, 0, 1300, 400);
        setLayout(null);

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        status = new JLabel("Status: ");
        textfield = new JTextField();
        actualStatus = new JLabel();
        button = new JButton("Next");
        startButton = new JButton("Auto Start");

        label1.setFont(new Font("Arial", Font.BOLD, 70));
        label2.setFont(new Font("Arial", Font.BOLD, 9));
        label3.setFont(new Font("Arial", Font.BOLD, 9));

        label1.setBounds(50, 50, 200, 50);
        label2.setBounds(50, 100, 1500, 50);
        label3.setBounds(50, 150, 1500, 50);
        status.setBounds(250, 50, 50, 50);
        textfield.setBounds(300, 60, 300, 30);
        actualStatus.setBounds(600, 50, 200, 50);
        button.setBounds(50, 250, 200, 50);
        startButton.setBounds(300, 250, 200, 50);

        add(label1);
        add(label2);
        add(label3);
        add(status);
        add(textfield);
        add(actualStatus);
        add(button);
//        add(startButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        button.addActionListener(this);
        startButton.addActionListener(this);
        textfield.addKeyListener(this);

        intArray = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            intArray.add(i);
        }

        random = new Random();

        try {
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void paintIt() {

        Integer n = random.nextInt(endIndex - startIndex) + startIndex;

        if (intArray.contains(n)) {
            intArray.remove(n);
            System.out.println(n);

            label1.setText(n + "");

            try {
                synthesizer.speakPlainText(label1.getText(), null);
//                synthesizer.speakPlainText("Hello papa", null);
//                synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
//                synthesizer.deallocate();

            } catch (Exception e) {
                e.printStackTrace();
            }
            allArrayLeft = "";
            for (int i : intArray) {
                allArrayLeft = allArrayLeft + "," + i;
            }

            arrayDone.add(n);
            allArrayDone = allArrayDone + "," + n;
            try {
                label2.setText("Left: " + allArrayLeft.substring(1));

                label3.setText("Done: " + allArrayDone.substring(1));
            } catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "Game Complete..!!");
                button.setEnabled(false);
                try {
                    synthesizer.deallocate();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            paintIt();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        new RandomNumbers().paintIt();

//        for (int i = startIndex; i < endIndex; i++) {
        RandomNumbers obj = new RandomNumbers();

        try {
            paintThread = new Thread(new Runnable() {

                public void run() {
                    for (int i = RandomNumbers.startIndex; i < RandomNumbers.endIndex; i++) {
                        try {
                            if (obj.autoStart) {
                                Thread.sleep(2000);
                            } else {
                                Thread.sleep(10000);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RandomNumbers.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        obj.paintIt();

                    }
                }
            });
//            paintThread.start();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            paintIt();
        } else if (e.getSource() == startButton) {

            if (!autoStart) {
                autoStart = true;
//                paintThread.start();
                startButton.setText("Pause with 10 sec");
            } else {
                autoStart = false;
//                startButton.setText("Resume");
            }

        }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == textfield) {
            try {
                int number = Integer.parseInt(textfield.getText());

                if (arrayDone.contains(number)) {
                    actualStatus.setText("Done");
                }

                if (intArray.contains(number)) {
                    actualStatus.setText("Left");
                }

            } catch (Exception e1) {

            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
