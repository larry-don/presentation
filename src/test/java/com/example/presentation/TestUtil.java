package com.example.presentation;


import com.example.presentation.enums.DayOfWeek;
import com.example.presentation.model.Grandpa;
import com.example.presentation.model.Son;
import com.example.presentation.model.User;
import com.example.presentation.schedule.ScheduledTasks;
import com.example.presentation.util.DutySchedule;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
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
    public void testOutter() {
        ChildOutter childOutter = new ChildOutter();
        Outter.Inner inner = childOutter.getInner();
        inner.printTest();
    }

    @Test
    public void testSet() {
        List<String> list1 = Arrays.asList("苹果", "香蕉", "樱桃");
        List<String> list2 = Arrays.asList("苹果", "香蕉", "樱桃");
        List<String> collect = list1.stream().filter(s -> s.equals("11")).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    @Test
    public void test002() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "5");
        map.put(5, null);
        map.put(6, null);

        List<String> list = new ArrayList<>();
        map.forEach((key, val) -> {
            System.out.println(key + " " + val);
            list.add(key, val);
        });
        System.out.println(list.size());
        System.out.println(list);

    }

    @Test
    public void test03() {
        String name = "pig";
        List<String> list = Arrays.asList("monkey", "pig", "human");
        String s = Optional.ofNullable(list)
                .map(l -> l.stream().filter(item -> item.equals(name)).findAny().orElse(null)).orElse(null);
        Assertions.assertEquals("pig", s);
    }

    @Test
    public void test04() {
        Pattern pattern = Pattern.compile("RegExr");
//        RegExr
        Matcher matcher1 = pattern.matcher("RegExr");
        Matcher matcher2 = pattern.matcher("Text");
        System.out.println("matcher1.matches() is: " + matcher1.matches());
        System.out.println("matcher1.find() is: " + matcher1.find());
        System.out.println("matcher1.group() is: " + matcher1.group());

        System.out.println("matcher2.matches() is: " + matcher2.matches());
        System.out.println("matcher2.find() is: " + matcher2.find());
        System.out.println("matcher2.group() is: " + matcher2.group());


    }

    @Test
    public void test05() {
        User user = new User("zhagnsan", 10, "北京");
        String name = user.getName();
        name = "lise";

        System.out.println(name);
        System.out.println(user.getName());


    }

    @Test
    public void test06() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "abc_ef");
        map.put(2, "abc_ef");
        map.put(3, "abc_ef");
        map.put(4, "abc_ef");
        map.put(5, "abc_ef");
        List<String> collect = map.values().stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void test07() {
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

        // 向 EnumMap 中添加数据
        String meeting = schedule.put(DayOfWeek.MONDAY, "Meeting");
        System.out.println(meeting);

    }


    @Test
    public void test08() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println("==============");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);
        System.out.println("==============");

        Date parse = simpleDateFormat.parse(time);
        System.out.println(parse);

    }

    @Test
    public void test09() {
        //取整 向零进位
        Assertions.assertEquals(2, 5 / 2);
        Assertions.assertEquals(-2, -5 / 2);

        //取余 模数运算与左边操作数的符号一致
        Assertions.assertEquals(1, 5 % 2);
        Assertions.assertEquals(-1, -5 % 2);
        Assertions.assertEquals(1, 5 % -2);
        Assertions.assertEquals(-1, -5 % -2);

    }

    @Test
    public void test10() {
        Assertions.assertEquals(9, Math.pow(3, 2));
    }

    @Test
    public void test11() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "bob");
        map.put("gender", "male");
        System.out.println(Maps.newHashMap(map));
        map.put("age", "18");
        System.out.println(map);
    }

    @Test
    public void testException() {
        //RuntimeException runtimeException = new RuntimeException("异常");
        ClassCastException classCastException = new ClassCastException("不能随便转换");
        System.out.println((RuntimeException) classCastException instanceof ClassCastException);
    }

    @Test
    public void replace() {
        String s = "abc!123";
        String replace = s.replace("!", "__");
        System.out.println(s);
        System.out.println(replace);
    }


    @Test
    public void test1234() {
        List<Map<String, Object>> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> dataTmp = new HashMap<>();
            dataTmp.put("name", "name" + i);
            dataTmp.put("age", i);
            dataTmp.put("address", "address" + i);
            datas.add(dataTmp);
        }
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Map<String, Object> dataMap : datas) {
            dataList.add(Collections.synchronizedMap(dataMap));
        }
        for (Map<String, Object> stringObjectMap : dataList) {
            stringObjectMap.put("name1", "name1");
        }

        System.out.println(datas);
        System.out.println(dataList);

    }

    @Test
    public void test2234() {
        Grandpa son = new Son();
        son.sayHello();
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test2235() {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> strings = new ArrayList<>();
        set.addAll(list);
        set.addAll(strings);
        set.addAll(null);
        System.out.println(set);

    }

    @Test
    public void test2236() {
        System.out.println((long) 500 * 400 * 300 * 200);
        System.out.println(500 * 400 * 300 * 200);/*-884901888*/
    }

    @Test
    public void test2237() {
        short c = (short) 65534;

        System.out.println(Integer.toBinaryString(c));//11111111111111111111111111111110
        System.out.println(Integer.toBinaryString(c >> 4));//11111111111111111111111111111111  算术右移 左侧补最高有效位的值
        System.out.println(Integer.toBinaryString(c >>> 4));//1111111111111111111111111111  逻辑右移  左侧补0
    }

    @Test
    public void testMessage(){
        //ScheduledTasks.createMessageContentExample();
        ScheduledTasks.sendMessage();
    }

    @Test
    public void testTestDutyPerson(){
        // 测试第一周
        System.out.println("=== 第一周 ===");
        LocalDate firstWeekStart = LocalDate.of(2025, 11, 17);
        for (int i = 0; i < 5; i++) {
            LocalDate date = firstWeekStart.plusDays(i);
            System.out.println(date + " (" + date.getDayOfWeek() + "): " +
                    DutySchedule.getDutyPersonSimple(date));
        }

        // 测试第二周
        System.out.println("\n=== 第二周 ===");
        LocalDate secondWeekStart = LocalDate.of(2025, 11, 24);
        for (int i = 0; i < 5; i++) {
            LocalDate date = secondWeekStart.plusDays(i);
            System.out.println(date + " (" + date.getDayOfWeek() + "): " +
                    DutySchedule.getDutyPersonSimple(date));
        }

        // 查询特定日期
        System.out.println("\n=== 特定日期查询 ===");
        LocalDate queryDate = LocalDate.of(2025, 12, 1); // 星期四
        System.out.println(queryDate + " 值班人员: " +
                DutySchedule.getDutyPersonSimple(queryDate));

        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    @Test
    public void testMap(){
        List<Map<String, Object>> datas = new ArrayList<>();
        datas.forEach(map->map.remove("name"));
        System.out.println(datas);
    }

}
