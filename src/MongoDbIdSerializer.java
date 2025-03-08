import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bson.types.ObjectId;
import java.io.IOException;
import java.util.Map;

/**
 * A special class to overcome the issue of serialize/deserialize the MongoDB _id field that
 * often comes through as a wierd dictionary containing a timestamp key/value and a date key/value.
 * This class is designed to overcome that issue.
 * Example usage (e.g., POJO.java):
 * <pre>
 * {@code
 *    @JsonProperty(value = "_id", required = true, index = 1)
 *    @JsonDeserialize(using = MongoDbIdSerializer.class)
 *    protected ObjectId id; // allow MongoDB to set this when inserting new records
 * }
 * </pre>
 */
public class MongoDbIdSerializer extends JsonDeserializer<ObjectId>{

    @Override
    public ObjectId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Read JSON as a map
        Map<String, String> map = p.readValueAs(Map.class);

        // Check if the map contains "$oid" and return an ObjectId
        if (map != null && map.containsKey("$oid")) {
            return new ObjectId(map.get("$oid"));
        }

        return null; // If no valid _id found
    }
}
