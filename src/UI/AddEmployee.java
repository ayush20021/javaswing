package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operations.Employee;
import operations.Implementer;

public class AddEmployee extends JFrame {
	
	JLabel ID,Name,Sal,msg;
	JTextField Idinp,Naminp,Salinp;
	JButton btm,home;
	
	public AddEmployee() {
		setLayout(null);
		ID = new JLabel("Enter iD");
		Name = new JLabel("Enter Name");
		Sal = new JLabel("Enter Sal");
		
		Idinp = new JTextField(10);
		Naminp = new JTextField(10);
		Salinp = new JTextField(10);
		
		btm = new JButton("Add");
		msg = new JLabel();
		btm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Employee emp = new Employee();
				emp.setId(Integer.parseInt(Idinp.getText()));
				emp.setName(Naminp.getText());
				emp.setSalary(Integer.parseInt(Salinp.getText()));
				Implementer imp = new Implementer();
                try {
                    boolean status = imp.AddEmployee(emp);
					msg.setText("Data Inserted");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
		});
		home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home();
				dispose();
			}
		});
		
		
		ID.setBounds(50, 50, 60, 20);
		Idinp.setBounds(120,50,30,20);
		Name.setBounds(50, 100, 100, 20);
		Naminp.setBounds(120,100,60,20);
		Sal.setBounds(50,150,60,30);
		Salinp.setBounds(120,150,60,30);
		btm.setBounds(50,210,80,30);
		home.setBounds(120,210,90,30);
		msg.setBounds(50,260,80,20);
		
		
		add(ID);
		add(Idinp);
		add(Name);
		add(Naminp);
		add(Sal);
		add(Salinp);
		add(btm);
		add(home);
		add(msg);
		
		
		setSize(400,400);
		setVisible(true);
		
		
	}

}
