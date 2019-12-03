package com.db1group.damagecontrol;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class YamlFile {

    private final List<String> options = new ArrayList<>();

    public YamlFile(String baseName, Locale locale) {
        options.add(locale.toString() + ".yaml");
        options.add(baseName + locale.toString() + ".yml");
        options.add(baseName + ".yaml");
        options.add(baseName + ".yml");
    }

    File get() {
        for (var option : options) {
            var resource = YamlFile.class.getClassLoader().getResource(option);
            if (Objects.nonNull(resource)) {
                return new File(resource.getFile());
            }
        }
        throw new RuntimeException();
    }
}
