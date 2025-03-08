import java.util.Objects;

public class Course extends POJO {

    private String name;
    private String description;

    private Course() {/* prevent uninitialized instances */}
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {return name;}
    public String getDescription() {return description;}

    /** Check to see if two instances of this class differ only by their underlying MongoDB _id field.
     * @param o - an instance of this class.
     * @return - true if the objects are equal; otherwise, return false.
     */
    @Override
    public boolean equals(Object o) {
        // if you're not one of us, go away.
        if (!(o instanceof Course course)) return false;
        // check everything except _id for equality.
        return Objects.equals(name, course.name)
            && Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return new StringBuilder("Course{")
                .append("id=").append(id).append('\'')
                .append(", name='").append(name).append('\'')
                .append(", description='").append(description).append('\'')
                .append('}').toString();
    }
}
