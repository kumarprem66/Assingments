package com.masaischool.sprint3day1;

import java.util.Scanner;

import com.masaischool.sprint3day1.dao.StudentDaoImpl;
import com.masaischool.sprint3day1.dao.masaiDao;
import com.masaischool.sprint3day1.dao2.EmployeeDao;
import com.masaischool.sprint3day1.dao2.EmployeeDaoImp;
import com.masaischool.sprint3day1.entity.Employee;
import com.masaischool.sprint3day1.entity.Student;
import com.masaischool.sprint3day1.exception.NoSuchDataFoundException;
import com.masaischool.sprint3day1.exception.SomethingWentWrongException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("1 - For student");
        System.out.println("2 - Employee");
        System.out.println("0 - to exit");
        
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        if(choose == 1) {
        	
        	
            int choice = 0;
            do {
            	System.out.println("1 - Add student");
                System.out.println("2 - Remove student");
                System.out.println("3 - Update Student label");
                System.out.println("4 - search Student ");
                System.out.println("0 - to exit");
                System.out.println("Select Selection ");
                choice = sc.nextInt();
                switch(choice) {
                case 1:
                	addStu(sc);
                	break;
                case 2:
                	removeStu(sc);
                	break;
                case 3:
                	updatetu(sc);
                	break;
                case 4:
                	searchStu(sc);
                	break;
                case 0:
                	System.out.println("Successfully exited..");
                	break;
                }
            }while(choice !=0 );
            
           
        }else if(choose == 2) {
        	 int choice = 0;
             do {
             	System.out.println("1 - Add Employee");
                 System.out.println("2 - Remove Employee");
                 System.out.println("3 - give bonus to Employee");
                 System.out.println("4 - get address Employee ");
                 System.out.println("0 - to exit");
                 System.out.println("Select Selection ");
                 choice = sc.nextInt();
                 switch(choice) {
                 case 1:
                 	addEmp(sc);
                 	break;
                 case 2:
                 	removeEmp(sc);
                 	break;
                 case 3:
                 	givebonus(sc);
                 	break;
                 case 4:
                	 getAddressEmp(sc);
                 	break;
                 case 0:
                 	System.out.println("Successfully exited..");
                 	break;
                 }
             }
             while(choice !=0);
        }else {
        	System.out.println("Successfully exited");
        	System.exit(0);
        }
    }

	private static void getAddressEmp(Scanner sc) {
		System.out.println("Enter id");
		int id = sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImp();
		try {
			System.out.println(dao.getAddressOfEmployee(id));
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void givebonus(Scanner sc) {
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("Enter bonnus");
		int bonus = sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImp();
		try {
			dao.giveBonusToEmployee(id,bonus);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void removeEmp(Scanner sc) {
		
		System.out.println("Enter id");
		int id = sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImp();
		try {
			dao.deleteEmployee(id);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addEmp(Scanner sc) {
		
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImp();
		try {
			dao.save(new Employee(name,address,salary));
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private static void searchStu(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		int id = sc.nextInt();
		Student st = null;
		masaiDao dao = new StudentDaoImpl();
		try {
			st = dao.findStudentById(id);
			System.out.println(st);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

	private static void updatetu(Scanner sc) {
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("Increase your label");
		masaiDao dao = new StudentDaoImpl();
		int label = sc.nextInt();
	
		try {
			dao.updateStudentLevel(id,label);
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void removeStu(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		int id = sc.nextInt();
		masaiDao dao = new StudentDaoImpl();
	
	
		try {
			dao.deleteStudentById(id);
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addStu(Scanner sc) {
	
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter course");
		String courses = sc.next();
		System.out.println("Increase your label");
		masaiDao dao = new StudentDaoImpl();
		int label = sc.nextInt();
	
		try {
			dao.saveStudent(new Student(id,email,address,courses,label));
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
