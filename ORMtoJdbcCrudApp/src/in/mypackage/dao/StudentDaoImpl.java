package in.mypackage.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.mypackage.dto.Student14;
import in.mypackage.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {
	Session session = null;
	Transaction transaction = null;
	boolean flag = false;
	Student14 student = new Student14() ;
	Integer id = null;
	@Override
	public String addStudent(String sname, Integer sage, String saddress, Integer salary) {
		try {
			System.out.println("addStudent called");
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				student.setSname(sname);
				student.setSaddress(saddress);
				student.setSage(sage);
				student.setSalary(salary);
				
				System.out.println(student);
				session.save(student);
				flag = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		return "failure";
	}

	@Override
	public Student14 searchStudent(Integer sid) {

		try {
			session = HibernateUtil.getSession();

			if (session != null) {

				student = session.get(Student14.class, sid);

				return student;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String updateStudent(Student14 student) {
		session.clear();
		try {
			session = HibernateUtil.getSession();
			
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.update(student);
				flag=true;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		return "Failure";

	}

	@Override
	public String deleteStudent(Integer sid) {
		System.out.println("deleteStudent called..");
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				student = session.load(Student14.class, sid);
				System.out.println("session created..");
				transaction = session.beginTransaction();
			}
			if (transaction != null && student != null) {
				System.out.println("transaction created..");
				session.delete(student);
				System.out.println("delete executed..");
				flag = true;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				return "success";
			} else {
				transaction.rollback();
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		return "Failed";
	}
}
