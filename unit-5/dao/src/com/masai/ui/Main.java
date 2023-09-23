//package com.masai.ui;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Scanner;
//
//import com.masai.dao.MedicineDao;
//import com.masai.dao.MedicineDaoImpl;
//import com.masai.dto.Medicine;
//import com.masai.exception.NoRecordFoundException;
//import com.masai.exception.SomethingWentWrongException;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		int choice = 0;
//		do {
//			System.out.println("1. Add Medicine");
//			System.out.println("2. View Medicine List");
//			System.out.println("3. Update Medicine Details");
//			System.out.println("4. Delete Medicine Details");
//			System.out.println("5. Search Medicine By id ");
//			System.out.println("6. Show Expired Medicine ");
//			System.out.println("0. Exit");
//			System.out.print("Enter selection ");
//			choice = sc.nextInt();
//			switch(choice) {
//				case 1:
//					insertMedicineUI(sc);
//					break;
//				case 2:
//					viewMedicineListUI();
//					break;
//				case 3:
//					updateMedicinetUI(sc);
//					break;
//				case 4:
//					deleteMedicineUI(sc);
//					break;
//				case 5:
//					searchMedicineByid(sc);
//					break;
//				case 6:
//					showExpiredMedicine(sc);
//					break;
//				case 0:
//					System.out.println("Thank you, visit again");
//					break;
//				default:
//					System.out.println("Invalid selection, please try again");
//			}
//		}while(choice != 0);
//		
//		sc.close();
//		
//		
//
//	}
//	
//	static void insertMedicineUI(Scanner sc) {
//		
//		System.out.print("Enter id");
//		int medid = sc.nextInt();
//		System.out.print("Enter name");
//		String name = sc.next();
//		System.out.println("Enter company ");
//		String company = sc.next();
//		System.out.println("Enter price");
//		double price = sc.nextDouble();
//		System.out.println("Enter mfg");
////		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
////		LocalDate date = LocalDate.parse("29-Mar-2019", formatter);
//		LocalDate mfgdate = LocalDate.parse(sc.next());
//		System.out.println("Enter exp");
//		LocalDate expdate = LocalDate.parse(sc.next());
//		
//		
////		create an object of DTO class
//		Medicine med = new Medicine(medid,name,company,price,mfgdate,expdate);
//		
//		MedicineDao mcDao = new MedicineDaoImpl();
//		try {
//			mcDao.addMedicine(med);
//			System.out.println("Medicine Added successfully");
//		} catch (SomethingWentWrongException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		
//	}
//	
//	
//	
//	static void viewMedicineListUI() {
//		//call the insert operation of the DAO layer and get result
//		MedicineDao mcDao = new MedicineDaoImpl();
//		try {
//			List<Medicine> studentList = mcDao.viewAllMedicine();
//			//you are here means one or more record is available
//			studentList.stream().forEach(st -> System.out.println(st));
//		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//	
//	static void updateMedicinetUI(Scanner sc) {
//		//code to take input
//		System.out.print("Enter id");
//		int medid = sc.nextInt();
//		System.out.print("Enter name");
//		String name = sc.next();
//		System.out.println("Enter company ");
//		String company = sc.next();
//		System.out.println("Enter price");
//		double price = sc.nextDouble();
//		System.out.println("Enter mfg");
//		LocalDate mfgdate = LocalDate.parse(sc.next());
//		System.out.println("Enter exp");
//		LocalDate expdate = LocalDate.parse(sc.next());
//		
//		//Create an object of DTO class
//		Medicine med = new Medicine(medid,name,company,price,mfgdate,expdate);
//		
//		MedicineDao mcDao = new MedicineDaoImpl();
//		try {
//			mcDao.updateMedicine(med);
//			System.out.println("Medicine Updated successfully");
//		} catch (SomethingWentWrongException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//	
//	}
//	
//	static void deleteMedicineUI(Scanner sc) {
//		//code to take input
//		System.out.print("Enter id  ");
//		int id = sc.nextInt();
//		//pass the input to DAO layer
//		//call the insert operation of the DAO layer and get result
//		MedicineDao mcDAO = new MedicineDaoImpl();
//		try {
//			mcDAO.deleteMedicine(id);
//			
//			//print the result
//			System.out.println("Medicine deleted successfully");
//		}catch(SomethingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//	
//	static void searchMedicineByid(Scanner sc) {
//		//code to take input
//		System.out.print("Enter id  ");
//		int id = sc.nextInt();
//		
//		//pass the input to DAO layer
//		//call the insert operation of the DAO layer and get result
//		MedicineDao mcDAO = new MedicineDaoImpl();
//		try {
//			Medicine mc = mcDAO.searchMedicine(id);
//			System.out.println(mc);
//		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//	
//	static void showExpiredMedicine(Scanner sc) {
//		
//		MedicineDao mcDao = new MedicineDaoImpl();
//		try {
//			List<Medicine> studentList = mcDao.showExpiredMedicine();
//			//you are here means one or more record is available
//			studentList.stream().forEach(st -> System.out.println(st));
//		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//	}
//	
//	
//}
