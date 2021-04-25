package com.varvarigou.accepted.assignment.enums;

import java.util.HashMap;
import java.util.Map;

public enum SpecifierEnum {
    ONE("1"),
    TWO("2"),
    X("X");

    private String type;

    SpecifierEnum(String type){
        this.type = type;
    }

    private static final Map<String, SpecifierEnum> BY_LABEL = new HashMap<>();

    static {
        for (SpecifierEnum e: values()) {
            BY_LABEL.put(e.type, e);
        }
    }

    public static SpecifierEnum valueOfLabel(String type) {
        return BY_LABEL.get(type);
    }

    public String getType() {
        return type;
    }
}
