package com.example.presentation.controller;

import com.alibaba.fastjson2.JSON;
import com.example.presentation.model.TemplateDTO;
import com.example.presentation.template.TemplateServiceRDBImpl;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 11:27
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateServiceRDBImpl templateService;

    @Value("${template.config.abc:true}")
    private boolean flag = true;

    @Autowired
    @Qualifier("systemCache")
    private Cache<String, Object> system;

    @PostMapping("/save")
    public void save(@RequestBody TemplateDTO templateDTO) {
        templateService.save(templateDTO);
    }

    @PostMapping("/query")
    public TemplateDTO query(){
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setCode("test");
        templateDTO.setName("测试");
        return templateDTO;
    }

    @PostMapping("/query1")
    public void query1(HttpServletResponse response) throws IOException {
        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setCode("test");
        templateDTO.setName("测试");
        String jsonString = JSON.toJSONString(templateDTO);
        response.getWriter().write(jsonString);

    }

}
