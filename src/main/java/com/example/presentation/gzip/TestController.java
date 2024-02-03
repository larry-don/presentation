package com.example.presentation.gzip;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/2/1 9:32
 */
import com.alibaba.fastjson2.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/getArticle")
    public Map<String, Object> getArticle(@RequestBody ArticleRequestVO articleRequestVO){
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "success");
        System.out.println(JSON.toJSONString(articleRequestVO));
        return result;
    }

}
