package com.varvarigou.accepted.assignment.enums;

import java.util.HashMap;
import java.util.Map;

public enum SportsEnum {
    FOOTBALL(1), BASKETBALL(2);

    private Integer type;

    SportsEnum(Integer type){
        this.type = type;
    }

    private static final Map<Integer, SportsEnum> BY_LABEL = new HashMap<>();

    static {
        for (SportsEnum e: values()) {
            BY_LABEL.put(e.type, e);
        }
    }

    public Integer getType() {
        return type;
    }

    public static SportsEnum valueOfLabel(Integer type) {
        return BY_LABEL.get(type);
    }
}

