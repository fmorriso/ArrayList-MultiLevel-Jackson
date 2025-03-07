public abstract class Person {

    protected String firstName;
    protected String lastName;

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

    public String fullNameFirstLast() {
        return String.format("%s %s", firstName, lastName);
    }

    public String fullNameLastFirst() {
        return String.format("%s, %s", lastName, firstName);
    }
}
