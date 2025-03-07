import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PersistenceHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PersistenceHandler() {

        // Register the Java 8 Date/Time module to handle ZonedDateTime
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        // Enable pretty-printing if desired
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /** Return a JSON string representation of the specified POJO instance.
     * @param pojo - an instance of a class to be serialized into a JSON string
     * @return - string containing a JSON representation of the POJO instance.
     */
    public String getJsonFromPOJO(Object pojo)  {
        try {
            return objectMapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
