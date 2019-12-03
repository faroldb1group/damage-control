package com.db1group.damagecontrol;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;

import static java.util.Objects.nonNull;

public class MessageYaml implements Message {

    private final String baseName;


    public MessageYaml() {
        this.baseName = Message.DEFAULT_BASE_NAME;
    }

    public MessageYaml(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public String getValue(String key) {
        return null;
    }

    @Override
    public String getValue(String key, String defaultMessage) {
        return null;
    }

    @Override
    public String getValue(String key, Locale locale) {
        return null;
    }

    @Override
    public String getValue(String key, String defaultMessage, Locale locale) {
        return null;
    }

    public void teste() throws URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("i18n/messages.yaml").getFile());

        System.out.println(path);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Yaml yaml = new Yaml();
        var file = MessageYaml.class.getClassLoader().getResource("i18n/messages.yaml").getFile();
        var input = new FileInputStream(new File(file));
        Map<String, Object> obj = yaml.load(input);
        var apply = getKeyValue("user.a.b.c.d.e", "", obj);
        System.out.println(apply);
        input.close();


    }

    private static String getKeyValue(String matchKey, String currentKey, Map<String, Object> yamlValues) {
        for (Map.Entry<String, Object> entry : yamlValues.entrySet()) {
            var newKey = buildNewKey(currentKey, entry.getKey());
            if (entry.getValue() instanceof Map) {
                return getKeyValue(matchKey, newKey, (Map<String, Object>) entry.getValue());
            } else if (matchKey.equals(newKey)) {
                return entry.getValue().toString();
            }
        }
        return "";
    }

    private static String buildNewKey(String current, String entryKey) {
        return nonNull(current) && !current.isBlank() ? current.concat(".").concat(entryKey) : entryKey;
    }
}
