/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author user
 */
public class Login extends JFrame implements ActionListener {
    JTextField tusername,tpassword;
    Login()
            {
                
                getContentPane().setBackground(Color.white);
                setLayout(null);
                
                JLabel jbusername=new JLabel("Username");
                jbusername.setBounds(40,20,100,30);
                add(jbusername);
                 tusername=new JTextField();
                tusername.setBounds(150,20,100,30);
                add(tusername);
                
                JLabel jbpassword=new JLabel("Password");
                jbpassword.setBounds(40,70,100,30);
                add(jbpassword);
                
                 tpassword=new JTextField();
                tpassword.setBounds(150,70,100,30);
                add(tpassword);
                
                ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=I1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
                
                 JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
                
               setSize(600,300);
               setLocation(450,200);
               setVisible(true);
            }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String username=tusername.getText();
            String password=tpassword.getText();
            
            Conn c=new Conn();
            String query="select*from login where username='"+username+"'and password='"+password+"'";
            ResultSet rs=c.s.executeQuery(query);
           if(rs.next())
            {
               setVisible(false); 
               new Home();
            }
           else{
      JOptionPane.showMessageDialog(null, "Invalid password Or Username");
                       setVisible(false);
           }
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }
    public static void main(String args[])
    {
        new Login();
    }
    
}
