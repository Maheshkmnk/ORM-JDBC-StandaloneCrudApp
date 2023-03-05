package in.mypackage.daofactory;

import in.mypackage.dao.IStudentDao;
import in.mypackage.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	private static IStudentDao studentDao = null;
	
	private StudentDaoFactory() {
		
	}
	
	public static IStudentDao getStudentDao() {
		
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
				
		return studentDao;
	}

}
