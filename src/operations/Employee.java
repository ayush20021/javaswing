package operations;

public class Employee {
	
	String Name;
	
	int Id;
	
	int Salary;

	public Employee() {
	}

	public Employee(String name, int id, int salary) {
		Name = name;
		Id = id;
		Salary = salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}
}
