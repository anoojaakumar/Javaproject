
package employeemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.event.*;


public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cempid;
    JButton back,delete;
    RemoveEmployee(){
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        JLabel lempid=new JLabel("Employee Id");
        lempid.setBounds(50,50,100,30);
        add(lempid);
        
        cempid=new Choice();
        cempid.setBounds(200,50,100,30);
        add(cempid);
        
        try{
            Conn c=new Conn();
            String query="select*from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(50,100,100,30);
        add(lname);
        
        JLabel llname=new JLabel();
        llname.setBounds(200,100,100,30);
        add(llname);
        
         JLabel lphone=new JLabel("Phone");
        lphone.setBounds(50,150,100,30);
        add(lphone);
        
        JLabel llphone=new JLabel();
       llphone.setBounds(200,150,100,30);
        add(llphone);
        
         JLabel lemail=new JLabel("Email");
        lemail.setBounds(50,200,100,30);
        add(lemail);
        
        JLabel llemail=new JLabel();
       llemail.setBounds(200,200,100,30);
        add(llemail);
        
        try{
            Conn c=new Conn();
            String query="select*from employee where empid='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                llname.setText(rs.getString("name"));
                llphone.setText(rs.getString("phone"));
                llemail.setText(rs.getString("email"));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
            try{
            Conn c=new Conn();
            String query="select*from employee where empid='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                llname.setText(rs.getString("name"));
                llphone.setText(rs.getString("phone"));
                llemail.setText(rs.getString("email"));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        });
        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.green);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.green);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=I1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete)
        {
            try{
                Conn c=new Conn();
                String query="delete from employee where empid='"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details Deleted Succesfully");
                setVisible(false);
                new Home();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[])
    {
        new RemoveEmployee();
        
        
    }
}
