package org.isma.slick2d.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class GameResourcesLoader {
    private static final String PROPERTIES_FILE = "/game.properties";
    private static final String RESOURCES_PROPERTIES_FILE = "/resources.properties";

    private final Properties properties;
    protected final boolean debugMode;
    private static final String DEBUG_PREFIX = "debug.";

    public GameResourcesLoader(final String rootDirectory) throws IOException {

        File externalPropertiesFile = new File("./" + GameResourcesLoader.PROPERTIES_FILE);
        if (externalPropertiesFile.exists()) {
            properties = loadExternalProperties(externalPropertiesFile);
        } else {
            properties = loadProperties(rootDirectory + PROPERTIES_FILE);
        }

        Properties resProperties = loadProperties(rootDirectory + RESOURCES_PROPERTIES_FILE);
        for (Object key : resProperties.keySet()) {
            properties.put(key, resProperties.get(key));
        }
        debugMode = getBoolean("debug.mode");
    }


    private Properties loadProperties(String propertiesFile) throws IOException {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(propertiesFile);
        props.load(url.openStream());
        return props;
    }

    private Properties loadExternalProperties(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        Properties props = new Properties();
        props.load(fis);
        return props;
    }

    public String get(String name) {
        if (isDebugMode() && properties.getProperty(DEBUG_PREFIX + name) != null) {
            return properties.getProperty(DEBUG_PREFIX + name);
        }
        return properties.getProperty(name);
    }

    private boolean getBoolean(String name) {
        return Boolean.parseBoolean(properties.getProperty(name));
    }

    public boolean isDebugMode() {
        return debugMode;
    }
}
