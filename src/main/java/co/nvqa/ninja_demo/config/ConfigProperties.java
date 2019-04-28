package co.nvqa.ninja_demo.config;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigProperties {

    private static final String RESOURCE_RELATIVE_FILE_PATH = "public_html/index.html";
    private static final String PROTOCOL = "file:///";

    public static String getBaseUrl() {
        URL resource = ConfigProperties.class.getClassLoader().getResource(RESOURCE_RELATIVE_FILE_PATH);
        Path path = null;
        try {
            path = Paths.get(resource.toURI()).toAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return PROTOCOL + path.toString();
    }
}
