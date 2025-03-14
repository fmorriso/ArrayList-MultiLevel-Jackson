import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Objects;

public class State extends POJO {

    private String name;
    private String abbreviation;

    @JsonProperty(required = false)
    private ArrayList<District> schoolDistricts = new ArrayList<District>();

    private State() {/* prevent uninitialized instances */}

    public State(String name, String abbreviation) {
        ensureId();
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() { return name; }
    public String getAbbreviation() { return abbreviation; }

    public void addSchoolDistrict(District district) {
        schoolDistricts.add(district);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("State{")
                .append("name='").append(name).append('\'')
                .append(", abbreviation='").append(abbreviation).append('\'')
                .append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        // same memory address is easy
        if (this == o) return true;
        // if you're not one of us, go away.
        if (!(o instanceof State state)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, state.name)
                && Objects.equals(abbreviation, state.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbreviation);
    }
}
