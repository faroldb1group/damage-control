package com.db1group.damagecontrol;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public final class YamlFileMetadata {

    private static Map<String, Object> metadata;

    private YamlFileMetadata() {
    }

    public static Map<String, Object> get(String baseName, Locale locale) {
        if (isNull(metadata) || metadata.isEmpty()) {
            initMetadata(baseName, locale);
        }
        return metadata;
    }

    private static void initMetadata(String baseName, Locale locale) {
        try {
            requireNonNull(baseName, "Base name is not be null");
            requireNonNull(locale, "Locale name is not be be null");
            var file = new YamlFile(baseName, locale).get();
            var yaml = new Yaml();
            var input = new FileInputStream(file);
            metadata = yaml.load(input);
            input.close();
        } catch (IOException e) {

        }
    }
}
