import java.io.IOException;

public class DatabaseHelpers {
    public static String getConnectionTemplate() throws IOException {
        return ProgramSettings.getSetting("MONGODB_CONNECTION_TEMPLATE");
    }
}
