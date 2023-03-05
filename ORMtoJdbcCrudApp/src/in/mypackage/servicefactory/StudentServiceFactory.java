package in.mypackage.servicefactory;

import in.mypackage.service.IStudentService;
import in.mypackage.service.StudentServiceImpl;

public class StudentServiceFactory {

	private StudentServiceFactory() {}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentServiceImpl();
		}
		
		return studentService;
	}
}