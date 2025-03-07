import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.InvocationTargetException;

public class PersistenceHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PersistenceHandler() {

        // Register the Java 8 Date/Time module to handle ZonedDateTime fields in the POJO's.
        objectMapper.registerModule(new JavaTimeModule());

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

    /** Rehydrate a POJO from a JSON string representation of an instance of that POJO.
     * @param json - String containing a JSON representation of a POJO.
     * @param classz - the class of the POJO, such as Course.class
     * @param <T> - The type of object to be returned, typically Object which caller casts to desired class.
     * @return - a POJO instance of class T
     */
    public <T> T getPOJOfromJson(String json, Class<T> classz)  {
        try {
            return objectMapper.readValue(json, classz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
