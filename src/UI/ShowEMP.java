package UI;

import operations.Employee;
import operations.Implementer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowEMP  extends JFrame {

    JTable table;

    JScrollPane pan;

    JButton home;

    ShowEMP() throws SQLException, ClassNotFoundException {
        setLayout(null);
        Implementer imp = new Implementer();
        ArrayList<Employee> empdata = imp.ShoeEmploee();

        String [][] data = new String[empdata.size()][];

        for (int i = 0;i<empdata.size();i++){
            Employee e;
            e=empdata.get(i);
            String Name = e.getName();
            String ID = Integer.toString(e.getId());
            String Sal = Integer.toString(e.getSalary());
            data[i] = new String[]{Name,ID,Sal};
        }

        String[] colmn = {"Name","ID","Salary"};

        table = new JTable(data,colmn);
        pan = new JScrollPane(table);
        home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                dispose();
            }
        });
        table.setBounds(10,10,300,300);
        pan.setBounds(10,10,300,300);
        home.setBounds(50,320,100,20);
        add(pan);
        add(home);
        setSize(400,400);
        setVisible(true);








    }
}
