package com.db1group.damagecontrol;

import java.util.Locale;
import java.util.ResourceBundle;

public class App {

    public static void main(String[] args) {
        var locale = Locale.getDefault();
        DamageControlConfiguration
                .internationalization()
                .disable()
                .basicName("batata");
        System.out.println(locale);
    }
}
