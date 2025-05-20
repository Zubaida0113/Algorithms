package GREEDY;
import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
class MarksComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.marks - s2.marks; // Ascending order
        // Integer.compare(s1.marks, s2.marks); 
    }
}

public class comparingfuncTemplate {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));

        // Sort by marks in descending order
        // Collections.sort(students, (s1, s2) -> Integer.compare(s2.marks, s1.marks));

        Collections.sort(students, new MarksComparator());
        for (Student student : students) {
            System.out.println(student.name + ": " + student.marks);
        }
    }
}
