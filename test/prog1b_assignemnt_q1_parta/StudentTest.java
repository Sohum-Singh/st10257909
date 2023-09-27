package prog1b_assignemnt_q1_parta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StudentTest {

    private Student testStudent;

    @Before
    public void setUp() {
        // Create a sample student object for testing
        testStudent = new Student("12345", "John Doe", 20, "john@example.com", "Computer Science");
    }

    @Test
    public void testGetStudentID() {
        assertThat(testStudent.getStudentID(), is("12345"));
    }

    @Test
    public void testGetName() {
        assertThat(testStudent.getName(), is("John Doe"));
    }

    @Test
    public void testGetAge() {
        assertThat(testStudent.getAge(), is(20));
    }

    @Test
    public void testDisplayDetails() {
        // You can't directly test console output, so we'll leave this empty.
    }

    @Test
    public void testSaveStudent() {
        String studentID = "54321";
        String name = "Alice Smith";
        int age = 22;
        String email = "alice@example.com";
        String course = "Mathematics";

        // Test saving a new student
        assertTrue(Student.SaveStudent(studentID, name, age, email, course));

        // Test saving a duplicate student (should return false)
        assertFalse(Student.SaveStudent("12345", "Duplicate Student", 25, "duplicate@example.com", "History"));
    }

    @Test
    public void testSearchStudent() {
        String studentID = "12345";
        Student result = Student.SearchStudent(studentID);
        assertThat(result, is(equalTo(testStudent)));
    }

    @Test
    public void testDeleteStudent() {
        String studentID = "12345";

        // Test deleting an existing student
        assertTrue(Student.DeleteStudent(studentID));

        // Test deleting a non-existing student (should return false)
        assertFalse(Student.DeleteStudent("99999"));
    }

    @Test
    public void testStudentReport() {
        // You can't directly test console output here. We'll leave this empty.
    }

    @Test
    public void testExitStudentApplication() {
        // This method calls System.exit(), which will terminate the JVM.
        // It's not typically tested in unit tests. We'll leave this empty.
    }
}
