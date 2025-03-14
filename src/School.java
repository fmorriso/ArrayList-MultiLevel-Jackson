import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School extends POJO {

    private String name;
    private String abbreviation;
    private String street;
    private String city;
    //
    private List<Teacher> teachers = new ArrayList<Teacher>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    private School() {/* prevent uninitialized instances */}

    public School(String name, String abbreviation, String street, String city) {
        ensureId();
        this.name = name;
        this.abbreviation = abbreviation;
        this.street = street;
        this.city = city;
    }

    public String getName() {return name;}
    public String getAbbreviation() {return abbreviation;}
    public String getStreet() {return street;}
    public String getCity() {return city;}
    //
    @JsonProperty(required = false)
    public List<Teacher> getTeachers() { return teachers;}

    @JsonProperty(required = false)
    public List<Student> getStudents() { return students;}

    @JsonProperty(required = false)
    public List<Course> getCourses() { return courses;}

    @JsonProperty(required = false)
    public List<Department> getDepartments() { return departments;}

    @Override
    public String toString() {
        return new StringBuilder("School{")
                .append("name='").append(name).append('\'')
                .append(", abbreviation='").append(abbreviation).append('\'')
                .append(", street='").append(street).append('\'')
                .append(", city='").append(city).append('\'')
                .append('}').toString();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void addStudent(Student student) { students.add(student); }
    public void addCourse(Course course) { courses.add(course); }
    public void addDepartment(Department department) {departments.add(department); }

    public void displayTeachers() {
        StringBuilder sbr = new StringBuilder();
        sbr.append(this).append("\n");
        for (Teacher teacher : teachers)
            sbr.append("\t").append(teacher).append("\n");
        System.out.println(sbr.toString());
    }

    public void displayStudents() {
        StringBuilder sbr = new StringBuilder();
        sbr.append(this).append("\n");
        for (Student student : students)
            sbr.append("\t").append(student).append("\n");
        System.out.println(sbr.toString());
    }

    public void displayCourses() {
        StringBuilder sbr = new StringBuilder();
        sbr.append(this).append("\n");
        for (Course course : courses)
            sbr.append("\t").append(course).append("\n");
        System.out.println(sbr.toString());
    }

    public void displayDepartments() {
        StringBuilder sbr = new StringBuilder();
        sbr.append(this).append("\n");
        for (Department department : departments)
            sbr.append("\t").append(department).append("\n");
        System.out.println(sbr.toString());
    }

    @Override
    public boolean equals(Object o) {
        // same memory address is easy
        if (this == o) return true;
        if (!(o instanceof School school)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, school.name)
                && Objects.equals(abbreviation, school.abbreviation)
                && Objects.equals(street, school.street)
                && Objects.equals(city, school.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, abbreviation, street, city);
    }
}
