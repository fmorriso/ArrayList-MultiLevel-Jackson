import java.util.ArrayList;

public class Department {
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
}
