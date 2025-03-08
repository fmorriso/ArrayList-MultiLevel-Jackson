# Java ArrayList Multilevel

An example of a multilevel arraylist using a model of:

* A single State
* multiple school districts (District) within that state
* multiple schools (School) within each school district
* multiple courses (Course) taught at each school
* multiple departments (Department) within each school that teach multiple courses
* multiple teachers (Teacher) at each school teaching multiple courses
* multiple students (Student) at each school taking multiple courses
* A generic person class (Person) to avoid duplicating code for both teachers and students.

NOTES:
<em><b>Not every possible scenario is provided in this example.
You are encouraged to further modify this code to suit your needs</b></em>

This example is similar to the [original project](https://github.com/fmorriso/Java-ArrayList-Multilevel) 
with the added feature of being able to dehydrate a POJO into a JSON string and hydrate an instance of a POJO using
a JSON string representation of that POJO.

For example, courses can be added to both schools and departments, but you
may elect to have only the departments keep track of which courses they are
in charge of. If you decide to keep track of available courses only within departments,
you'll need a way to pull up a unique set of courses taught by the school from all the departments
if multiple departments can teach the same course to avoid the resulting list
containing duplicate courses.

This project uses the Jackson library to persist Java POJO's to from JSON.

## Tools Used

| Tool         |    Version |
|:-------------|-----------:|
| Java         |   23.0.2.0 |
| IntelliJ     | 2024.3.4.1 |
| VSCode       |     1.98.0 |
| Jackson      |     2.18.3 |
| MongoDB JARs |      5.1.3 |

## Change History

| Date       | Description                                                                 |
|:-----------|:----------------------------------------------------------------------------|
| 2025-03-07 | Initial creation by coping parts of ArrayList Multilevel and adding Jackson |

## References

* [POJO to JSON persistence example](https://github.com/fmorriso/json-simple-example)
* [Jackson Library Documentation and Tutorials](https://github.com/FasterXML/jackson-docs)

