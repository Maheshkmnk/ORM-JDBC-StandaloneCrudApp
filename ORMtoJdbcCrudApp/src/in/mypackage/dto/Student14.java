package in.mypackage.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value=true)
public class Student14 {
	@Id
	@GenericGenerator(name="gen14", strategy="increment")
	@GeneratedValue(generator="gen14")
	private Integer sid;

	private String sname;

	private Integer sage;

	private String saddress;

	private Integer salary;

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSname() {
		return sname;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + ", salary="
				+ salary + "]";
	}

}
