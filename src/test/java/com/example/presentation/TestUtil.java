package com.example.presentation;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtil {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("s", "123");
        String id = (String) map.get("id");
        System.out.println(id);
    }


    @Test
    public void test2() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> result = new ArrayList<>();
        list.stream().filter(item -> item.contains("e"))
                .forEach(item -> {
                    result.add(item);
                });
        System.out.println(result.size());
        System.out.println(result);
    }

    public static List<Entity> buildEntities() {
        List<Entity> list = new ArrayList<>();

        //创建主
        Entity e0 = new Entity();
        e0.setCode("e0");
        list.add(e0);
        //创建子
        Entity e1_1 = new Entity();
        e1_1.setCode("e1_1");
        e1_1.setParentCode("e0");
        Entity e1_2 = new Entity();
        e1_2.setCode("e1_2");
        e1_2.setParentCode("e0");
        list.add(e1_1);
        list.add(e1_2);

        //创建孙
        Entity e2_1 = new Entity();
        e2_1.setCode("e2_1");
        e2_1.setParentCode("e1_1");
        Entity e2_2 = new Entity();
        e2_2.setCode("e2_2");
        e2_2.setParentCode("e1_1");
        list.add(e2_1);
        list.add(e2_2);

        return list;
    }

    public static void buildEntityTree(Entity entity, List<Entity> entities) {
        if (entity.getChildren() == null) {
            for (Entity entity1 : entities) {
                if (entity1.getParentCode() != null && entity1.getParentCode().equals(entity.getCode())) {
                    if (entity.getChildren() == null) {
                        entity.setChildren(new ArrayList<>());
                    }
                    entity.getChildren().add(entity1);
                    buildEntityTree(entity1, entities);
                }
            }
        }
    }

    @Test
    public void test3() {
        List<Entity> list = buildEntities();
        Entity entity = list.stream().filter(l -> l.getParentCode() == null).findFirst().orElse(null);
        buildEntityTree(entity, list);
        System.out.println(entity);
        int depth = caculateDepth(entity);
        System.out.println(depth);
    }


    public static int caculateDepth(Entity entity) {
        List<Entity> children = entity.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            return 1;
        }
        int depth = 1;
        for (Entity child : children) {
            int childDepth = caculateDepth(child);
            if (childDepth > depth) {
                depth = childDepth;
            }
        }
        return depth;
    }

    @Test
    public void testOutter(){
        ChildOutter childOutter = new ChildOutter();
        Outter.Inner inner = childOutter.getInner();
        inner.printTest();
    }

    @Test
    public void testSet(){
        List<String> list1 = Arrays.asList("苹果", "香蕉", "樱桃");
        List<String> list2 = Arrays.asList("苹果", "香蕉", "樱桃");
        List<String> collect = list1.stream().filter(s -> s.equals("11")).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    @Test
    public void test002(){
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"0");
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"5");
        map.put(5,null);
        map.put(6,null);

        List<String> list = new ArrayList<>();
        map.forEach((key,val)->{
            System.out.println(key+" "+val);
            list.add(key,val);
        });
        System.out.println(list.size());
        System.out.println(list);

    }

    @Test
    public void test03(){

    }



}
