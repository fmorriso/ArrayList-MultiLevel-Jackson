import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {

    private int gradeLevel;

    // courses this student is taking
    @JsonProperty(required = false)
    private List<Course> courses = new ArrayList<Course>();

    private Student() {/* prevent uninitialized instances */}
    public Student(String firstName, String lastName, int gradeLevel) {
        ensureId();
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

    @Override
    public boolean equals(Object o) {
        // same memory address is easy
        if (this == o) return true;
        // if you're not one of us, go away.
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return gradeLevel == student.gradeLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gradeLevel);
    }
}
