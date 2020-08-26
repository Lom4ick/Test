package com.company.utils;

import lombok.SneakyThrows;
import lombok.var;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import static java.lang.String.format;

public class PropertiesController {

    private static PropertiesController instance;
    private Properties properties = new Properties();

    @SneakyThrows
    private PropertiesController() {
        if (Objects.isNull(System.getProperty(PropertiesNames.ENVIRONMENT)))
            System.setProperty(PropertiesNames.ENVIRONMENT, "test");
        var resource = format("/environments/%s.properties", System.getProperty(PropertiesNames.ENVIRONMENT));
        properties.load(PropertiesController.class.getResourceAsStream(resource));
    }

    public static String getProperty(final String propertyName) {
        instance = Optional.ofNullable(instance).orElseGet(PropertiesController::new);
        if (System.getProperties().containsKey(propertyName) || instance.properties.containsKey(propertyName))
            return System.getProperty(propertyName, instance.properties.getProperty(propertyName)).trim();
        else
            return null;
    }
}
