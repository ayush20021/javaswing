package UI;

import operations.Employee;
import operations.Implementer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateEmp extends JFrame {

    JLabel ID, NAme,msg;

    JTextField Idinp,Naminp;

    JButton btn,home;

    UpdateEmp(){
        setLayout(null);
        ID = new JLabel("Enter ID");
        NAme = new JLabel("Name TO Update");
        Idinp = new JTextField(10);
        Naminp = new JTextField(10);
        home = new JButton("Home");
        msg = new JLabel();
        btn = new JButton("update");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Idinp.getText()));
                emp.setName(Naminp.getText());
                Implementer imp = new Implementer();
                try {
                    boolean status = imp.UpdateEmployee(emp);
                    if(status){
                        msg.setText("Data Updated");
                    }else{
                        msg.setText("Data Not Updated");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                dispose();
            }
        });

        ID.setBounds(50,50,60,30);
        Idinp.setBounds(120,50,60,20);
        NAme.setBounds(50,100,60,30);
        Naminp.setBounds(120,100,60,30);
        btn.setBounds(50,160,80,20);
        home.setBounds(120,160,90,20);
        msg.setBounds(50,200,110,20);

        add(ID);
        add(Idinp);
        add(NAme);
        add(Naminp);
        add(btn);
        add(home);
        add(msg);

        setSize(400,400);
        setVisible(true);


    }

}
