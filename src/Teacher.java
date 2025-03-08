import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person {

    @JsonProperty(required = false)
    private Department department;

    // courses taught by this teacher
    @JsonProperty(required = false)
    private List<Course> courses = new ArrayList<>(); // courses taught

    private Teacher() {/* prevent uninitialized instances */}
    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<Course> getCourses() { return courses;}

    @Override
    public String toString() {
        return new StringBuilder("Teacher{")
                .append("lastName='").append(lastName).append('\'')
                .append(", firstName='").append(lastName).append('\'')
                .append('}').toString();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Teacher teacher)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(department, teacher.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
