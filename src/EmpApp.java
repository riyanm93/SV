import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmpApp {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
	int choice=0;
	List<employee> e=new ArrayList<employee>();
	do{
		System.out.println("1.List of Employees\n2.Add Employees\n3.Update Employee\n4.Delete Employee\n5.Quit from Menu\n");
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  choice=Integer.parseInt(br.readLine());
	
		  if(choice==1)
			  listEmp(e);
		  else if(choice==2)
			  e=addEmp(e);
		  else if(choice==3)
			  e=UpdateEmp(e);
		  else if(choice==4)
			  e=delEmp(e);
		  else if(choice!=5)
			  System.out.println("Invalid input\n");
	}while (choice!=5);
		System.out.println("Thanks.");
	}

	private static List<employee> delEmp(List<employee> e) throws NumberFormatException, IOException {
		listEmp(e);
		System.out.println("\nPlease enter the name of the employee you would like to delete\n");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		
		for(employee ee:e)
		{
			if(name.equals(ee.getEmpName()))
			{
				e.remove(ee);
				break;
			}
		}
		return e;
	}

	private static List<employee> UpdateEmp(List<employee> e) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		listEmp(e);
		System.out.println("Please Enter the name of the employee you would like to edit\n");
		String name=br.readLine();
		employee user=new employee();
		int j=0;
		for(employee ee:e)
		{
			if(name.equals(ee.getEmpName()))
			{
				j=1;
				user=ee;
				e.remove(ee);
				break;
			}
		}
		if(j==0)
		{
			System.out.println("Usesr not found");
			UpdateEmp(e);
		}
		System.out.println("1.EmpID\n2.Emp Name\n3.Emp Dept\n4.Emp Sal\nEmpWhat would you like to update?\nPlease enter the Corresponding number that you want to edit\n");
		int choice=Integer.parseInt(br.readLine());
		if(choice==1)
		{
			System.out.println("Enter the new EmpID\n");
			user.setEmpID(Integer.parseInt(br.readLine()));
		}
		else if(choice==2)
		{
			System.out.println("Enter the new Emp Name\n");
			user.setEmpName(br.readLine());
		}
		else if(choice==3)
		{
			System.out.println("Enter the new Emp Dept\n");
			user.setEmpDep(br.readLine());
		}
		else if(choice==4)
		{
			System.out.println("Enter the new Emp Sal\n");
			user.setEmpSal((Double.parseDouble(br.readLine())));
		}
		
		e.add(user);
		return e;
	}

	private static List<employee> addEmp(List<employee> e) throws NumberFormatException, IOException {
		employee em=new employee();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter EmpID");
		em.setEmpID(Integer.parseInt(br.readLine()));
		System.out.println("Enter Emp Name");
		em.setEmpName(br.readLine());
		System.out.println("Enter Emp Dept");
		em.setEmpDep(br.readLine());
		System.out.println("Enter Emp Salary");
		em.setEmpSal(Double.parseDouble(br.readLine()));
		e.add(em); 
		System.out.println("Employee added\n");
		return e;
	}

	private static void listEmp(List<employee> e) {
		for(employee ee:e)
		{
			System.out.println(ee.getEmpID()+"."+ee.getEmpName()+"\n");
		}
		
	}

	
}
