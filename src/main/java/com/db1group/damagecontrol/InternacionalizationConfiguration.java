package com.db1group.damagecontrol;

public class InternacionalizationConfiguration {

    private static boolean enabled = true;

    private static String basicName = "messages";

    private DamageControlConfiguration damageControlConfiguration;

    public InternacionalizationConfiguration(DamageControlConfiguration damageControlConfiguration) {
        this.damageControlConfiguration = damageControlConfiguration;
    }

    public InternacionalizationConfiguration disable() {
        enabled = false;
        return this;
    }

    public InternacionalizationConfiguration enable() {
        enabled = true;
        return this;
    }

    public InternacionalizationConfiguration basicName(String basicName) {
        this.basicName = basicName;
        return this;
    }

    public DamageControlConfiguration and() {
        return damageControlConfiguration;
    }

}
