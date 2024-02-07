package UI;

import operations.Employee;
import operations.Implementer;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchEmployee extends JFrame {

    JLabel ID,msg;

    JTextField Ininp;
    JButton btn,home;

    SearchEmployee()
    {
        setLayout(null);
        ID = new JLabel("Enter ID");
        msg = new JLabel();
        btn = new JButton("Search");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Ininp.getText()));

                Implementer inp = new Implementer();
                try {
                    String[] adata = inp.SearchEMP(emp);

                    msg.setText("Name :"+adata[0]+"ID :"+adata[1]+" Salary "+adata[2]);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        home = new JButton("HOME");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                dispose();
            }
        });
        Ininp = new JTextField(10);
        ID.setBounds(50,50,60,30);
        Ininp.setBounds(120,50,60,20);
        btn.setBounds(50,100,80,20);
        home.setBounds(130,130,80,20);
        msg.setBounds(50,150,180,20);


        add(ID);
        add(Ininp);
        add(btn);
        add(home);
        add(msg);

        setSize(400,400);
        setVisible(true);





    }




}
