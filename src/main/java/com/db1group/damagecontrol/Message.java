package com.db1group.damagecontrol;

import java.util.Locale;

public interface Message {

    static final String DEFAULT_BASE_NAME = "i18n/messages";

    String getValue(String key);

    String getValue(String key, String defaultMessage);

    String getValue(String key, Locale locale);

    String getValue(String key, String defaultMessage, Locale locale);

}
