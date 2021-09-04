package Details;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table
public class Info {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
private int studentId;	
private String studentName;
private String stPhone;
private String stAddress;
private String courseName;
private String JoiningDate;
public Info() {
	
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getstPhone() {
	return stPhone;
}
public void setstPhone(String stPhone) {
	this.stPhone = stPhone;
}
public String getstAddress() {
	return stAddress;
}
public void setstAddress(String stAddress) {
	this.stAddress = stAddress;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String className) {
	this.courseName = className;
}
public int getStudentId() {
	return studentId;
}

public String getJoiningDate() {
	return JoiningDate;
}
public void setJoiningDate(String joiningDate) {
	JoiningDate = joiningDate;
}

public Info(String studentName, String stPhone, String stAddress, String courseName, String joiningDate) {
	super();
	this.studentName = studentName;
	this.stPhone = stPhone;
	this.stAddress = stAddress;
	this.courseName = courseName;
	JoiningDate = joiningDate;
}
@Override
public String toString() {
	return "Info [studentId=" + studentId + ", studentName=" + studentName + ", stPhone=" + stPhone + ", stAddress="
			+ stAddress + ", courseName=" + courseName + "]";
}


}

