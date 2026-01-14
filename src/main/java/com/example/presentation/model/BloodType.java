package com.example.presentation.model;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/4/25 19:40
 */
@Getter
public enum BloodType {
    A("A型血", 1),
    B("B型血", 2),
    AB("AB型血", 3),
    O("O型血", 4);
    private String name;
    private int value;


    public static final Map<String, BloodType> types = Collections.unmodifiableMap(new HashMap<String, BloodType>() {
        {
            for (BloodType v : BloodType.values()) {
                put(v.name, v);
                put(String.valueOf(v.value), v);
            }
        }
    });

    public static Map<String, BloodType> getMap() {
        HashMap<String, BloodType> types = new HashMap<>();
        for (BloodType v : BloodType.values()) {
            types.put(v.name, v);
            types.put(String.valueOf(v.value), v);
        }
        return Collections.unmodifiableMap(types);
    }

    BloodType(String name, int value) {
        this.name = name;
        this.value = value;
    }


    public static BloodType fromName(String name) {
        return types.get(name);
    }


}
