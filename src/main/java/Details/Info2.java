package Details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table 
public class Info2 {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
private int teacherId;
private String teacherName;
private String teacherPhone;
private String teacherAddress;
private String className;
private String JoiningDate;

public int getTeacherId() {
	return teacherId;
}

public String getJoiningDate() {
	return JoiningDate;
}

public void setJoiningDate(String joiningDate) {
	JoiningDate = joiningDate;
}

public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getTeacherPhone() {
	return teacherPhone;
}
public void setTeacherPhone(String teacherPhone) {
	this.teacherPhone = teacherPhone;
}
public String getTeacherAddress() {
	return teacherAddress;
}
public void setTeacherAddress(String teacherAddress) {
	this.teacherAddress = teacherAddress;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public Info2() {
	
}

public Info2(String teacherName, String teacherPhone, String teacherAddress, String className, String joiningDate) {
	super();
	this.teacherName = teacherName;
	this.teacherPhone = teacherPhone;
	this.teacherAddress = teacherAddress;
	this.className = className;
	JoiningDate = joiningDate;
}



}
