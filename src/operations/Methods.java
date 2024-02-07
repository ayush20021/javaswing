package operations;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Methods {
	
	boolean AddEmployee(Employee emp) throws SQLException, ClassNotFoundException;
	boolean DeleteEmployee(Employee emp) throws SQLException, ClassNotFoundException;
	boolean UpdateEmployee(Employee emp) throws SQLException, ClassNotFoundException;


	ArrayList<Employee> ShoeEmploee() throws SQLException, ClassNotFoundException;


	String [] SearchEMP(Employee emp) throws SQLException, ClassNotFoundException;
	

}
