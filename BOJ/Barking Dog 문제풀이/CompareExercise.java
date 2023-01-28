package ps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareExercise {

    static Comparator<Student> comp = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.age > s2.age) {
                return 1;
            } else if (s1.age < s2.age) {
                return -1;
            }
            return 0;
        }
    };

    public static void main(String[] args) {
        Student student1 = new Student(22, 1223);
        Student student2 = new Student(3275, 1423);
        Student student3 = new Student(-543, 16743);
        Student student4 = new Student(55, 53543);
        List<Student> students = new ArrayList<>();

        students.add(student2);
        students.add(student1);
        students.add(student4);
        students.add(student3);

        for (Student st : students) {
            System.out.println("before sort -> " + st.classNumber + " : " + st.age);
        }

        students.sort(comp);

        for (Student st : students) {
            System.out.println("after sort -> " + st.classNumber + " : " + st.age);
        }
    }
}

class Student {

    int age;
    int classNumber;

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }
}


