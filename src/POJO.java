import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class intended to be persisted to/from JSON and eventually a MongoDB Atlas collection.
 */
public class POJO {


    /**
     * This property is used by MongoDB to uniquely identify an instance of the record in a collection.
     * @implNote - the value will be null unless the information came from an existing record in a MongoDB
     * Atlas collection.
     */
    @JsonProperty(value = "_id", required = true, defaultValue = "?", index = 1)
    protected String id = "?";

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
}
