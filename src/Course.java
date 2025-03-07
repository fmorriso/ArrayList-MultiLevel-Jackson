import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

    @JsonProperty("_id")
    private String id;

    private String name;
    private String description;

    private Course() {/* prevent uninitialized instances */}
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}

    @Override
    public String toString() {
        return new StringBuilder("Course{")
                .append("name='").append(name).append('\'')
                .append(", description='").append(description).append('\'')
                .append('}').toString();
    }
}
