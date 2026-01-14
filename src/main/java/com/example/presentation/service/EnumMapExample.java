package com.example.presentation.service;

import com.example.presentation.enums.DayOfWeek;

import java.util.EnumMap;

public class EnumMapExample {
    public static void main(String[] args) {
        // 创建一个 EnumMap 实例
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

        // 向 EnumMap 中添加数据
        schedule.put(DayOfWeek.MONDAY, "Meeting");
        schedule.put(DayOfWeek.TUESDAY, "Work from home");
        schedule.put(DayOfWeek.WEDNESDAY, "Gym");
        schedule.put(DayOfWeek.THURSDAY, "Dinner with friends");
        schedule.put(DayOfWeek.FRIDAY, "Movie night");

        // 获取并打印数据
        System.out.println("Monday's schedule: " + schedule.get(DayOfWeek.MONDAY));
        System.out.println("Tuesday's schedule: " + schedule.get(DayOfWeek.TUESDAY));

        // 遍历 EnumMap
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + ": " + schedule.get(day));
        }
    }
}
