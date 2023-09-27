package prog1b_assignemnt_q1_parta;

import java.util.Scanner;

public class PROG1B_Assignemnt_Q1_partA {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Student Management Application");
        System.out.println("******************************");
        System.out.println("Enter (1) to launch menu or any other key to exit the application");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            displayMenu();
        } else {
            Student.ExitStudentApplication();
        }
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("******************************");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: \n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    captureStudentDetails();
                    break;
                case 2:
                    searchForStudent();
                    break;
                case 3:
                    deleteAStudent();
                    break;
                case 4:
                    Student.StudentReport();
                    break;
                case 5:
                    Student.ExitStudentApplication();
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void captureStudentDetails() {
        System.out.println("Capture a new student");
        System.out.println("******************************");
        System.out.print("\nEnter student ID: ");
        String studentID = scanner.nextLine();

        // Check if the student already exists
        if (Student.SearchStudent(studentID) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Enter student age (must be 16 or above): ");
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age < 16);

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        if(Student.SaveStudent(studentID, name, age, email, course)) {
            System.out.println("Student details successfully saved.");
        } else {
            System.out.println("Error: Student was not saved.");
        }
    }

    private static void searchForStudent() {
        System.out.print("\nEnter student ID to search: ");
        String studentID = scanner.nextLine();

        Student student = Student.SearchStudent(studentID);
        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    private static void deleteAStudent() {
        System.out.print("\nEnter student ID to delete: ");
        String studentID = scanner.nextLine();

        if(Student.DeleteStudent(studentID)) {
            System.out.println("\nStudent successfully deleted.");
        } else {
            System.out.println("\nStudent not found or an error occurred.");
        }
    }
}
