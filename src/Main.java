import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.format("Java version: %s%n", System.getProperty("java.version"));

        PersistenceHandler persistenceHandler = new PersistenceHandler();

        Course c1 = new Course("Java", "Java Programming");
        System.out.format("before ensureId(): %s%n", c1);
        c1.ensureId();
        System.out.format("after ensureId(): %s%n", c1);

        // convert to JSON
        String c1JSON = persistenceHandler.getJsonFromPOJO(c1);
        System.out.format("Course (JSON): %s%n", c1JSON);

        // use the JSON string to convert back to a POJO:
        Course c1POJO = persistenceHandler.getPOJOfromJson(c1JSON, Course.class);
        c1POJO.ensureId();
        System.out.format("Course (POJO from JSON): %s%n", c1POJO);

        // verify that the original POJO and rehydrated one are equal
        assert c1POJO.equals(c1);

        Department d1 = new Department("Computer Science", "Computer Science & Cryptography");
        System.out.format("%s\n", d1);
        String d1JSON = persistenceHandler.getJsonFromPOJO(d1);
        System.out.format("Department (JSON): %s%n", d1JSON);
        d1.addCourse(c1);

        // use the JSON string to convert back to a POJO:
        Department d1POJO = persistenceHandler.getPOJOfromJson(d1JSON, Department.class);
        System.out.format("Department (POJO from JSON): %s%n", d1POJO);

        // verify that the original POJO and rehydrated one are equal
        assert d1POJO.equals(d1);

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

    /**
     * get the java version that is running the current program
     *
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion() {
        Runtime.Version rtv = Runtime.version();
        return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
    }
}