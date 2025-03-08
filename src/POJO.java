import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bson.types.ObjectId;
/**
 * A class intended to be persisted to/from JSON and eventually a MongoDB Atlas collection.
 */
public class POJO {


    /**
     * This property is used by MongoDB to uniquely identify an instance of the record in a collection.
     * @implNote - the value will be null unless the information came from an existing record in a MongoDB
     * Atlas collection.
     */
    @JsonProperty(value = "_id", required = true, index = 1)
    @JsonDeserialize(using = MongoDbIdSerializer.class)
    protected ObjectId id; // allow MongoDB to set this when inserting new records

    public ObjectId getId() {return id;}
    public void setId(ObjectId id) {this.id = id;}

    public void ensureId() {
        if (this.id == null) {
            this.id = new ObjectId();
        }
    }

}
