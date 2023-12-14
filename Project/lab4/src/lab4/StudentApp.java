package lab4;


public class StudentApp {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student("John", "Engineering", "123-456-7890");
        students[1] = new Student("Alice", "Mathematics", "987-654-3210");
        students[2] = new Student("Bob", "Computer Science", "555-555-5555");
        students[3] = new Student("Eve", "Physics", "888-888-8888");
        students[4] = new Student("Charlie", "Biology", "777-777-7777");

        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + " details:");
            students[i].print();
            System.out.println();
        }
    }
}
