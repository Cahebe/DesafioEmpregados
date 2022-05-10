package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
        
		//Instanciando Department e Address
		System.out.print("Nome do departamento: ");
		String name = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Address address = new Address(email, phone);
		Department department = new Department(name, payDay, address);
		
		//Instanciando Employee
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		
		for (int i=0; i<n; i++) {
			System.out.println("Dados do funcionário " + (i+1));
			System.out.print("Nome: ");
			String employeeName = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			sc.nextLine();
			Employee employees = new Employee(employeeName, salary);
			department.addEmployee(employees);
		}
		
		showReport(department);
		
		sc.close();
	}
	private static void showReport(Department department) {
			System.out.println("FOLHA DE PAGAMENTO: ");
			System.out.println("Departamento " + department.getName() + " = R$ " 
			+ department.payroll());
			System.out.println("Pagamento realizado no dia " + department.getPayDay());
			System.out.println("Funcionários: ");
			for (Employee emp : department.getEmployees()) {
				System.out.println(emp.getName());
			}
			System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
	}
}
