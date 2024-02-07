package UI;

import operations.Employee;
import operations.Implementer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DelEmp  extends JFrame {

    JLabel ID,msg;
    JTextField Idinp;

    JButton btn,home;

    DelEmp(){
        setLayout(null);
        ID = new JLabel("Enter ID");
        msg = new JLabel();
        Idinp = new JTextField(10);
        btn = new JButton("DELETE");
        home = new JButton("Home");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Idinp.getText()));
                Implementer inp = new Implementer();
                try {
                    boolean Ststus =   inp.DeleteEmployee(emp);

                    if(Ststus){
                        msg.setText("Data Delete");
                    }else {
                        msg.setText("Data NOT Delete");
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
        btn.setBounds(50,100,100,20);
        home.setBounds(130,100,90,20);
        msg.setBounds(50,130,120,300);

        add(ID);
        add(Idinp);
        add(btn);
        add(home);
        add(msg);

        setSize(400,400);
        setVisible(true);

    }


}
