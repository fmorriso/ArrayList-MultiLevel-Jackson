import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;
import java.io.IOException;

/**
 * A special class to overcome the issue of serialize/deserialize the MongoDB _id field that
 * often comes through as a wierd dictionary containing a timestamp key/value and a date key/value.
 * This class is designed to overcome that issue.
 * Example usage (e.g., POJO.java):
 * <pre>
 * {@code
 *    @JsonProperty(value = "_id", required = true, index = 1)
 *    @JsonSerialize(using = MongoDbIdSerializer.class)
 *    protected ObjectId id; // allow MongoDB to set this when inserting new records
 * }
 * </pre>
 */
public class MongoDbIdSerializer extends JsonSerializer<ObjectId> {

    @Override
    public void serialize(ObjectId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeStartObject();
            gen.writeStringField("$oid", value.toHexString()); // Store ObjectId as a string
            gen.writeEndObject();
        } else {
            gen.writeNull();
        }
    }

}
