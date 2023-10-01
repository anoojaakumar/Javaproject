
package employeemanagementsystem;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author user
 */
public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField ceducation,tffield,tdesignation,tsalary,taddress,tphone,temail;
   
    JButton add,back;
    JLabel llempid;
    String empid;
    
    
    UpdateEmployee(String empid){
        this.empid=empid;
        
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("THAHOMA",Font.BOLD,25));
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(50,150,150,30);
        lname.setFont(new Font("serif",Font.PLAIN,20));
        add(lname);
        
        JLabel tfield=new JLabel();
        tfield.setBounds(200,150,150,30);
        add(tfield);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
         tffield=new JTextField();
        tffield.setBounds(600,150,150,30);
        add(tffield);
        
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);
        
         JLabel ddob=new JLabel();
        ddob.setBounds(200,200,150,30);
        add(ddob);
        
         JLabel lsalary=new JLabel("Salary");
        lsalary.setBounds(400,200,150,30);
        lsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lsalary);
        
         tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);
        
         JLabel laddress=new JLabel("Address");
        laddress.setBounds(50,250,150,30);
        laddress.setFont(new Font("serif",Font.PLAIN,20));
        add(laddress);
        
        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);
        
        JLabel lphone=new JLabel("Phone Number");
        lphone.setBounds(400,250,150,30);
        lphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lphone);
        
        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        JLabel lemail=new JLabel("Email Id");
        lemail.setBounds(50,300,150,30);
        lemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lemail);
        
        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);
        
        JLabel leducation=new JLabel("Highest Education");
        leducation.setBounds(400,300,150,30);
        leducation.setFont(new Font("serif",Font.PLAIN,20));
        add(leducation);
        
        
        ceducation=new JTextField();
        ceducation.setBounds(600,300,150,30);
        ceducation.setBackground(Color.WHITE);
        add(ceducation);
        
        JLabel ldesignation=new JLabel("Designation");
        ldesignation.setBounds(50,350,150,30);
        ldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(ldesignation);
        
        tdesignation=new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);
        
        JLabel laadhar=new JLabel("Aadhar Number");
        laadhar.setBounds(400,350,150,30);
        laadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(laadhar);
        
        JLabel taadhar=new JLabel();
        taadhar.setBounds(600,350,150,30);
        add(taadhar);
        
         JLabel lempid=new JLabel("Employee Id");
        lempid.setBounds(50,400,150,30);
        lempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lempid);
        
        llempid=new JLabel();
        llempid.setBounds(200,400,150,30);
        llempid.setFont(new Font("serif",Font.PLAIN,20));
        add(llempid);
        try{
            Conn c=new Conn();
            String query="select*from employee where empid='"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                tfield.setText(rs.getString("name"));
                tffield.setText(rs.getString("fname"));
                ddob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                ceducation.setText(rs.getString("education"));
                tdesignation.setText(rs.getString("designation"));
                taadhar.setText(rs.getString("aadhar"));
                llempid.setText(rs.getString("empid"));
                
                
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add=new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.GREEN);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.GREEN);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
           
           String fname=tffield.getText();
           
           String des=tdesignation.getText();
           String salary=tsalary.getText();
           String address =taddress.getText();
           String phone=tphone.getText();
           String email=temail.getText();
           String education=ceducation.getText();
           ;
           try{
               Conn conn=new Conn();
               String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+des+"'where empid='"+empid+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Details Updated Successfully");
               setVisible(false);
               new Home();
           }
           catch(Exception e){
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
        new UpdateEmployee("");
    }
    
}
