/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author user
 */
public class Splash extends JFrame implements ActionListener {
    Splash()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=I1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        
        JButton cont = new JButton("Click Here To Continue");
        cont.setBounds(400,400,300,70);
        cont.setBackground(Color.GREEN);
        cont.setForeground(Color.white);
        cont.addActionListener(this);
        image.add(cont);
      setSize(1170,650);
      setLocation(200,50);
      setVisible(true);
      while(true)
      {
          heading.setVisible(false);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){}
          heading.setVisible(true);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){}
      }
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        new Splash();
    }
    
}
