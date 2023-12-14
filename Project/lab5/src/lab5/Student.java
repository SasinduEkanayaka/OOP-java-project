package lab5;
import java.util.ArrayList;
import java.util.List;
public class Student {
	
	private String studentid;
	private String name;
	private String GPA;
	

	public Student(String studentid, String name, String GPA) {
	
		this.studentid = studentid;
		this.name = name;
		this.GPA = GPA;
	}
	


	public String getStudentid() {
		return studentid;
	}





	public String getName() {
		return name;
	}







	public String getGPA() {
		return GPA;
	}


	public static void main(String[] args) {
		ArrayList<Student> StudentList = new ArrayList<>();

        Student student1 = new Student("1", "John Doe", "3");
        Student student2 = new Student("2", "Alice Smith","2.1");
        Student student3 = new Student("3", "Bob Johnson", "2");
        
        StudentList.add(student1);
        StudentList.add(student2);
        StudentList.add(student3);
        
        System.out.println("Student details:");
        for (Student student : StudentList) {
            System.out.println("Student ID: " + student.getStudentid());
            System.out.println("Name: " + student.getName());
            System.out.println("GPA: " + student.getGPA());
            System.out.println();
        
        
		

	}
	}
}
