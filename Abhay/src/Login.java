import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener
{
    JLabel heading,username,password;
    JTextField Username,Password;
    JButton Submit,Forgot_password;
    Login()
    {
         heading=new JLabel("LOGIN");
         username =new JLabel("Username");
         password =new JLabel("Password");
         
         
         heading.setBounds(600,200,100,30);
         username.setBounds(400,400,100,30);
         password.setBounds(400,500,100,30);
        
         add(heading);add(username);add(password);

         Username=new JTextField();
         Password=new JTextField();
         
         Username.setBounds(700,400,100,30);
         Password.setBounds(700,500,100,30);
         

         add(Username); add(Password);

         Submit=new JButton("SUBMIT");
         Submit.setBounds(0,0,100,30);
         add(Submit);
         

    }
    public void actionPerformed(ActionEvent ex)
    {
        /*login obj3=new login();
        obj3.setBounds(0,0,1500,1000);
        obj3.setVisible(true);
        this.dispose();*/
        
    }
    public static void main(String args[])throws Exception
     {
        Login obj=new Login();
        obj.setVisible(true);
        obj.setLayout(null);
        obj.setBounds(0,0,1500,1000);
      }
}
