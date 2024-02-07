package operations;

import connection.GetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Implementer  implements Methods{

	@Override
	public boolean AddEmployee(Employee emp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		String sql = "insert into employee (ID,Name,Slary) values(?,?,?)";
		preparedStatement = GetConnection.getConection().prepareStatement(sql);
		preparedStatement.setInt(1,emp.getId());
		preparedStatement.setString(2, emp.getName());
		preparedStatement.setInt(3,emp.getSalary());

		int a = preparedStatement.executeUpdate();

		return a>0;

		
		

	}

	@Override
	public boolean DeleteEmployee(Employee emp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		String sql = " delete from employee where ID = ?";
		preparedStatement = GetConnection.getConection().prepareStatement(sql);
		preparedStatement.setInt(1,emp.getId());

		int a = preparedStatement.executeUpdate();

		return a>0;


	}

	@Override
	public boolean UpdateEmployee(Employee emp) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement;
		String sql = " update employee set Name = ? where ID = ?";
		preparedStatement = GetConnection.getConection().prepareStatement(sql);
		preparedStatement.setString(1,emp.getName());
		preparedStatement.setInt(2,emp.getId());

		int a = preparedStatement.executeUpdate();

		return a>0;


	}

	@Override
	public ArrayList<Employee> ShoeEmploee() throws SQLException, ClassNotFoundException {

		ArrayList<Employee> EMPDATA = new ArrayList<>();

		PreparedStatement preparedStatement;
		String sql = "select * from employee";
		preparedStatement = GetConnection.getConection().prepareStatement(sql);

		ResultSet set = preparedStatement.executeQuery();




		while (set.next()){


			String Name = set.getString("Name");
			int id = set.getInt("ID");
			int Sal= set.getInt("Slary");
			EMPDATA.add(new Employee(Name,id,Sal));
		}

		return EMPDATA;

	}

	@Override
	public String[] SearchEMP(Employee emp) throws SQLException, ClassNotFoundException {

		String [] data = new String[3];
		PreparedStatement preparedStatement;
		String Sql = "select * from employee where ID = ?";
		preparedStatement = GetConnection.getConection().prepareStatement(Sql);
		preparedStatement.setInt(1, emp.getId());

		ResultSet set = preparedStatement.executeQuery();



		while (set.next()){
			String Name = set.getString("Name");
			String ID = Integer.toString(set.getInt("ID"));
			String Sal = Integer.toString(set.getInt("Slary"));
			data[0]=Name;
			data[1]=ID;
			data[2]=Sal;

		}
		return data;





	}

}
