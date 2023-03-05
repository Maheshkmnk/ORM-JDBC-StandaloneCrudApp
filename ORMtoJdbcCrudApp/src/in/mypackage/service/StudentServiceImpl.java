package in.mypackage.service;

import in.mypackage.dao.IStudentDao;
import in.mypackage.daofactory.StudentDaoFactory;
import in.mypackage.dto.Student14;


public class StudentServiceImpl implements IStudentService{

	private IStudentDao stdDao = StudentDaoFactory.getStudentDao();
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress, Integer salary) {
		stdDao = StudentDaoFactory.getStudentDao();
		
		return stdDao.addStudent(sname, sage, saddress, salary);
	}

	@Override
	public Student14 searchStudent(Integer sid) {
		
		stdDao = StudentDaoFactory.getStudentDao();
		
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student14 student) {
		
		stdDao = StudentDaoFactory.getStudentDao();
		
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		stdDao = StudentDaoFactory.getStudentDao();
		
		return stdDao.deleteStudent(sid);
	}
	
}
