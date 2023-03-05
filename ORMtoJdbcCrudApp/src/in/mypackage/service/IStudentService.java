package in.mypackage.service;

import in.mypackage.dto.Student14;


public interface IStudentService {
	
public String addStudent(String sname, Integer sage, String saddress, Integer salary);
	
	public Student14 searchStudent(Integer sid);
	
	public String updateStudent(Student14 student);
	
	public String deleteStudent(Integer sid);
}
