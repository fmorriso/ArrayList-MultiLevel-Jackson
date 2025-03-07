import java.util.ArrayList;

public class State {

    private String name;
    private String abbreviation;
    private ArrayList<District> schoolDistricts = new ArrayList<District>();

    private State() {/* prevent uninitialized instances */}

    public State(String name, String abbreviation) {
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
}
