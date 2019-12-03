package com.db1group.damagecontrol;

public class DamageControlConfiguration {

    private static DamageControlConfiguration damageControlConfiguration = new DamageControlConfiguration();

    public static InternacionalizationConfiguration internationalization() {
        return new InternacionalizationConfiguration(damageControlConfiguration);
    }

}
