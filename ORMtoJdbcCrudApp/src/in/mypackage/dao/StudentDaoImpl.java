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

	@Override
	public String addStudent(String sname, Integer sage, String saddress, Integer salary) {
		System.out.println("addStudent called>>>>");
		try {
			System.out.println("before session creation>>>>");
			session = HibernateUtil.getSession();
			System.out.println("session created>>>>");
			if (session != null) {
				transaction = session.beginTransaction();
				System.out.println("this called>>>>");
				student.setSname(sname);
				student.setSaddress(saddress);
				student.setSage(sage);
				student.setSalary(salary);
				//student.setSid(1);
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

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				session.delete(sid);
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
