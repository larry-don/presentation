package com.example.presentation;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2023/7/28 10:30
 */
@Data
@ToString
public class Entity {

    //private int id;
//    private String name;
    private String code;
    private List<Entity> children;
    private String parentCode;
}
