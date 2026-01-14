package com.example.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadTest {

    public static Set<String> readFile(String filePath) {
        //String filePath = "/Users/larry/Desktop/所有未升级708.txt"; // 替换为你的文件路径
        Set<String> linesSet = new HashSet<>();

        try {
            // 读取文件的所有行，并将它们添加到Set中
            linesSet.addAll(Files.readAllLines(Paths.get(filePath)));

            // 输出Set的内容，以验证结果
            //linesSet.forEach(System.out::println);
            return linesSet;
        } catch (IOException e) {
            System.err.println("读取文件时发生错误: " + e.getMessage());
        }
        return null;
    }

    @Test
    void collectNotUpgradedTenants() {
        Set<String> allTenants = readFile("/Users/larry/Desktop/所有未升级708.txt");
        Set<String> successTenants = readFile("/Users/larry/Desktop/526家有记录.txt");
        Collection<String> result = CollectionUtils.removeAll(allTenants, successTenants);
        result.forEach(System.out::println);
        System.out.println(result.size());

    }

    @Test
    void write() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Alice");
        map.put("age", 30);
        map.put("city", "Beijing");

        // 创建 ObjectMapper 实例用于序列化
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 创建临时文件
            File tempFile = File.createTempFile("map-output" + "_" + System.currentTimeMillis() + "_", ".json");

            // 将 Map 序列化为 JSON 并写入临时文件
            objectMapper.writeValue(tempFile, map);

            System.out.println("Map 已成功序列化并保存到临时文件: " + tempFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
