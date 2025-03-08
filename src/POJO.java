import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class intended to be persisted to/from JSON and eventually a MongoDB Atlas collection.
 */
public class POJO {


    /**
     * This property is used by MongoDB to uniquely identify an instance of the record in a collection.
     */
    @JsonProperty(value = "_id", required = true)
    protected String id;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
}
