import java.util.ArrayList;
import java.util.Objects;

public class Department  extends POJO {
    private String name;
    private String description;
    private ArrayList<Course> courses = new ArrayList<Course>();

    private Department() {/* prevent uninitialized instances */}
    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public ArrayList<Course> getCourses() {return courses;}

    @Override
    public String toString() {
        return new StringBuilder("Department{")
                .append("name='").append(name).append('\'')
                .append(", description='").append(description).append('\'')
                .append('}').toString();
    }

    public void addCourse(Course course) {courses.add(course);}

    /** Check to see if two instances of this class differ only by their underlying MongoDB _id field and courses.
     * @param o - an instance of this class.
     * @return - true if the objects are equal; otherwise, return false.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Department that)) return false;
        return Objects.equals(name, that.name)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
