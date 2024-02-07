package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JMenuBar;

public class Home extends JFrame {
	
	
	JMenuBar menu;
	JMenu EMployee,EmployeeDetails,Account,Utility;
	JMenuItem Add,Update,Delte,Search,Show;
	
	public Home() {
		setLayout(null);
		menu = new JMenuBar();
		EMployee = new JMenu("Employee");
		EmployeeDetails = new JMenu("Employee Details");
		Account = new JMenu("Account");
		Utility = new JMenu("Utility");
		
		Add = new JMenuItem("Add EMployee");
		Update= new JMenuItem("Update Employee");
		Delte = new JMenuItem("Delete Employee");
		Search = new JMenuItem("Search employee");
		Show = new JMenuItem("Show Employee");
		
		menu.add(EMployee);
		menu.add(EmployeeDetails);
		menu.add(Account);
		menu.add(Utility);

		EmployeeDetails.add(Show);
		Show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try {
                    new ShowEMP();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();

			}
		});
		EmployeeDetails.add(Search);
		Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchEmployee();
				dispose();
			}
		});
		
		EMployee.add(Add);
		Add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee();
				dispose();
				
			}
		});
		EMployee.add(Update);
		Update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateEmp();
				dispose();
			}
		});
		EMployee.add(Delte);
		Delte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DelEmp();
				dispose();
			}
		});
		
		
		menu.setBounds(20, 10, 300, 30);
		add(menu);
		setSize(400,400);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Home();
	}
	
	
	

}
