import java.util.Objects;

public class Person extends POJO {

    protected String firstName;
    protected String lastName;

    @Override
    public boolean equals(Object o) {
        // same memory address is easy
        if (this == o) return true;
        // if you're not one of us, go away.
        if (!(o instanceof Person person)) return false;
        return Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

    public String fullNameFirstLast() {
        return String.format("%s %s", firstName, lastName);
    }

    public String fullNameLastFirst() {
        return String.format("%s, %s", lastName, firstName);
    }
}
