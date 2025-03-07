import java.util.Collections;
//
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        // Register the Java 8 Date/Time module to handle ZonedDateTime
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        // Enable pretty-printing if desired
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Course c1 = new Course("Java", "Java Programming");
        System.out.format("%s\n", c1);

        try {
            String c1Json = objectMapper.writeValueAsString(c1);
            System.out.format("Course as JSON: %s\n", c1Json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } finally {
        }

        Department d1 = new Department("Computer Science", "Computer Science & Cryptography");
        System.out.format("%s\n", d1);
        d1.addCourse(c1);

        Student s1 = new Student("Mythical", "Last-Name", 12);
        System.out.format("%s\n", s1);
        s1.addCourse(c1);

        Teacher mgrohman = new Teacher( "Mark", "Grohman");
        System.out.format("%s\n", mgrohman);
        mgrohman.addCourse(c1);

        School lphs = new School("Lewis-Palmer","LPHS", "1300 Highby Road", "Monument" );
        System.out.format("%s\n", lphs);
        lphs.addTeacher(mgrohman);
        lphs.addStudent(s1);
        lphs.addCourse(c1); // MIGHT WANT TO KEEP THIS ONLY IN DEPARTMENT
        lphs.addDepartment(d1);

        School prhs = new School("Palmer Ridge", "PRHS", "19255 Monument Hill Road", "Monument" );
        System.out.format("%s\n", prhs);
        prhs.addTeacher(mgrohman);

        District lpsd = new District("Lewis-Palmer", "D38", "146 N. Jefferson Street", "Monument");
        System.out.format("%s\n", lpsd);

        // add a bunch of schools to the district in one call
        Collections.addAll(lpsd.getSchools(), lphs, prhs);
        // lpsd.addSchool(lphs);
        // lpsd.addSchool(prhs);

        lpsd.displaySchools();
        lpsd.displaySchoolsAndTeachers();

        lphs.displayDepartments();
        lphs.displayTeachers();
        lphs.displayStudents();
        lphs.displayCourses();

        State colorado = new State("Colorado", "CO");
        System.out.format("%s\n", colorado);
        colorado.addSchoolDistrict(lpsd);

    }
}