package in.mypackage.contrller;

import java.util.Scanner;

import in.mypackage.dto.Student14;
import in.mypackage.service.IStudentService;
import in.mypackage.servicefactory.StudentServiceFactory;

public class CrudApp {
	static Scanner sc = new Scanner(System.in);
	private static IStudentService studentService;

	public static void main(String[] args) {
		for(int i=1; i>0; i++) {
			System.out.println("\n\t1.Insert\n\t2.Update\n\t3.Delete\n\t4.Read\n\t5.Exit");
			System.out.println("Enter the operation number which you want to do....");
			int opNumber = Integer.parseInt(sc.next());
			if(opNumber!=5) {
				switch(opNumber) {
				case 1: insertStudent();
						break;
						
				case 2: updateStudent();
						break;
						
				case 3: deleteStudent();
						break;
						
				case 4: searchStudent();
						break;
						
				case 5: break;
				
				default: System.out.println("Choose proper option in the given list!");
						 break;
				}
			}else {
				System.out.println("Thank you for using our application...visit again");
				break;
			}
		}
	}

	public static void insertStudent() {

		System.out.println("Enter Student name:");
		String sname = sc.next();
		System.out.println("Enter student Age:");
		int sage = sc.nextInt();
		System.out.println("Enter student Address:");
		String saddress = sc.next();
		System.out.println("Enter student Salary:");
		int salary = sc.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();

		String msg = studentService.addStudent(sname, sage, saddress, salary);

		if (msg.equals("success")) {
			System.out.println("Record inserted successfully......");
		} else {
			System.out.println("Record insertion failed.......");
		}

	}

	public static void searchStudent() {
		System.out.println("Enter student id that you want to see : ");
		int sid = sc.nextInt();
		Student14 student = null;
		IStudentService studentService = StudentServiceFactory.getStudentService();

		student = studentService.searchStudent(sid);

		if (student != null) {
			//System.out.println(student);
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage() + "\t"
					+ student.getSaddress() + "\t" + student.getSalary());

		} else {
			System.out.println("Record not found for the given record id of " + sid);
		}

	}

	public static void updateStudent() {
		System.out.println("enter the student id you want to update :");
		int sid = sc.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();

		Student14 oldStd = studentService.searchStudent(sid);

		if (oldStd != null) {
			Student14 newStd = new Student14();

			System.out.println("current student detail of the searched student id " + sid+" are \n");
			System.out.println(oldStd.getSname() + "\t" + oldStd.getSage() + "\t" + oldStd.getSaddress() + "\t"
					+ oldStd.getSalary()+"\n");
			
			newStd.setSid(oldStd.getSid());
			
			System.out.println("if you want to update new name please enter....");
			String sname = sc.next();
			if(sname.equals("") | sname == "") {
				newStd.setSname(oldStd.getSname());
			}else {
				newStd.setSname(sname);
			}
			
			System.out.println("if you want to update new age please enter....");
			String sage = sc.next();
			if(sage.equals("") | sage == "") {
				newStd.setSage(oldStd.getSage());
			}else {
				newStd.setSage(Integer.parseInt(sage));
			}
			
			System.out.println("if you want to update new address please enter....");
			String saddress = sc.next();
			if(saddress.equals("") | saddress == "") {
				newStd.setSaddress(oldStd.getSaddress());
			}else {
				newStd.setSaddress(saddress);
			}
			
			System.out.println("if you want to update new salary please enter....");
			String salary = sc.next();
			if(salary.equals("") | salary == "") {
				newStd.setSalary(oldStd.getSalary());
			}else {
				newStd.setSalary(Integer.parseInt(salary));
			}
			
			System.out.println("new object data is : "+ newStd);
			
			String msg = studentService.updateStudent(newStd);
			
			
			if(msg.equals("success")) {
				System.out.println("Record updated successfully");
			}
			else {
				System.out.println("Record updation failed......");
			}
		}
	}

	public static  void deleteStudent() {
		Student14 student = null;
		System.out.println("Enter Student id which you want to delete.....");
		
		int sid = sc.nextInt();
		
		studentService = StudentServiceFactory.getStudentService();
		student = studentService.searchStudent(sid);
		if(student != null) {
			String msg = studentService.deleteStudent(sid);			
			if(msg.equalsIgnoreCase("success"))
				System.out.println("Record deleted successfully...");
		}
		else {
			System.out.println("Entered Id not found in the records, please try with proper id.......");
		}	
	}

}
