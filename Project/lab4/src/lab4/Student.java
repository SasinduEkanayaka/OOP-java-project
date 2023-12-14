package lab4;

public class Student {
	
private int studentid;
private String name;
private String degree;
private String mobile;

private static int max = 100;

public Student(int studentid, String name, String degree, String mobile) {

	this.studentid = getNextStudentID();
	this.name = name;
	this.degree = degree;
	this.mobile = mobile;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDegree() {
	return degree;
}

public void setDegree(String degree) {
	this.degree = degree;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}
public void print() {
	System.out.println("StudentID :"+ studentid);
	System.out.println("name :"+ name);
	System.out.println("mobile :"+ mobile);
	System.out.println("degree :"+ degree);
}
public static int getNextStudentID() {
	return max++;
}

}

