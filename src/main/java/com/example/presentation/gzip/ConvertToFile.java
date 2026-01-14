package com.example.presentation.gzip;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static com.example.presentation.gzip.GzipUtils.compress;
import static com.example.presentation.gzip.GzipUtils.saveFile;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/2/1 9:34
 */
public class ConvertToFile {
    public static void main(String[] args) {
        ArticleRequestVO vo = new ArticleRequestVO();
        vo.setId(1L);
        vo.setTitle("bug弄潮儿");
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File("C:\\Users\\2230\\Desktop\\凯平项目资料\\改装车项目\\CXSSBOOT_DB_DDL-1.0.9.sql"));
            vo.setContent(new String(bytes));
            byte[] dataBytes = compress(JSON.toJSONString(vo));
            saveFile("d:/vo.txt", dataBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
