import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ProgramSettings {

    private static int number_of_disk_loads = 0;
    private static final Path FILE_PATH  = Paths.get(".env");
    private static final HashMap<String, String> settings = new HashMap<>();


    // define a loader for Google Guava cache
    private static final CacheLoader<String, String> CACHE_LOADER = new CacheLoader<>() {
        public String load(String key) {
            return key.toUpperCase();
        }
    };

    // define Google Guava cache using the previously defined loader
    private static final LoadingCache<String, String> STRING_LOADING_CACHE =
            CacheBuilder.newBuilder()
                        .maximumSize(100)
                        .build(CACHE_LOADER);

    public static String getSetting(String key) throws IOException {
        if (number_of_disk_loads++ == 0)
            cacheSettings();;
        return STRING_LOADING_CACHE.getUnchecked(key);
    }

    public static void setSetting(String key, String newValue) {
        STRING_LOADING_CACHE.put(key, newValue);
    }

    private static void persistSettings() throws IOException {
        //TODO: need to iterate the Google Guava cache to get latest key/value pairs
        List<String> lines = ProgramSettings.settings.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());

        Files.write(FILE_PATH, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static void cacheSettings() throws IOException {
        List<String> lines = Files.readAllLines(FILE_PATH);
        for (String line : lines) {
            String[] parts = line.split("=", 2);
            if (parts.length == 2) {
                STRING_LOADING_CACHE.put(parts[0], parts[1]);
            }
        }

    }
}
