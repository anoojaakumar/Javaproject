
package employeemanagementsystem;
//import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class ViewEmployees extends JFrame implements ActionListener {
   
    JTable table;
    Choice cempid;
    JButton search,print,update,back;
    ViewEmployees()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
         JLabel lsearch=new JLabel("Search By Employee Id");
         lsearch.setBounds(20,20,150,20);
         add(lsearch);
         
         cempid=new Choice();
         cempid.setBounds(180,20,150,20);
         add(cempid);
         table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from employee");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        update=new JButton("Update");
       update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
       back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
       
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==search)
         {
            String query="select*from employee where empid='"+cempid.getSelectedItem()+"'" ;
            try{
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
         }else  if(ae.getSource()==print)
         {
             try{
                 table.print();
             }
            catch(Exception e){
                e.printStackTrace();
                
            } 
         }
         else  if(ae.getSource()==update)
         {
             setVisible(false);
             new UpdateEmployee(cempid.getSelectedItem());
         }
         else{
             new Home();
             setVisible(false);
         }
     }
    public static void main(String args[])
    {
        new ViewEmployees();
    }
    
}
