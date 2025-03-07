import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int gradeLevel;
    // courses this student is taking
    private List<Course> courses = new ArrayList<Course>();

    private Student() {/* prevent uninitialized instances */}
    public Student(String firstName, String lastName, int gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {return gradeLevel;}
    public List<Course> getCourses() {return courses;}

    @Override
    public String toString() {
        return new StringBuilder("Student{")
                .append("lastName='").append(lastName).append('\'')
                .append(", firstName='").append(firstName).append('\'')
                .append(", gradeLevel=").append(gradeLevel)
                .append('}').toString();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

}
