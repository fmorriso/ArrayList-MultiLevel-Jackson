import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.bson.types.ObjectId;
import java.io.IOException;
import java.util.Map;

/**
 * A special class to overcome the issue of deserializing the MongoDB _id field that,
 * without this class, would come through as a wierd dictionary containing
 * a timestamp key/value and a date key/value.
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
public class MongoDbIdDeserializer extends JsonDeserializer<ObjectId> {

    @Override
    public ObjectId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Read JSON as a Map
        Map<String, String> map = p.readValueAs(Map.class);

        // Extract "$oid" and create an ObjectId
        if (map != null && map.containsKey("$oid")) {
            return new ObjectId(map.get("$oid"));
        }

        return null; // If no valid ObjectId found
    }

}