package prog1b_assignemnt_q1_parta;

public class Student {
    static final int MAX_STUDENTS = 100;
    static Student[] students = new Student[MAX_STUDENTS];
    static int studentCount = 0;

    private String studentID;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String studentID, String name, int age, String email, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
    }

    public static boolean SaveStudent(String studentID, String name, int age, String email, String course) {
        if (studentCount >= MAX_STUDENTS) {
            return false;
        }

        if (findStudent(studentID) != null) {
            return false;
        }

        Student student = new Student(studentID, name, age, email, course);
        students[studentCount] = student;
        studentCount++;
        return true;
    }

    public static Student SearchStudent(String studentID) {
        return findStudent(studentID);
    }

    private static Student findStudent(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                return students[i];
            }
        }
        return null;
    }

    public static boolean DeleteStudent(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                return true;
            }
        }
        return false;
    }

    public static void StudentReport() {
        if(studentCount == 0) {
            System.out.println("\nNo students have been registered yet.");
            return;
        }

        System.out.println("\nPrinting all student reports:");
        System.out.println("******************************");
        for(int i = 0; i < studentCount; i++) {
            students[i].displayDetails();
            System.out.println("------------------------------");
        }
    }

    public static void ExitStudentApplication() {
        System.out.println("\nExiting the application.");
        System.exit(0);
    }
}

