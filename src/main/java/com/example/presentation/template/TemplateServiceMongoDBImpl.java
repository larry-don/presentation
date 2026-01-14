package com.example.presentation.template;

import com.example.presentation.annotaion.DoubleWrite;
import com.example.presentation.model.TemplateDTO;
import org.springframework.stereotype.Service;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 11:23
 */
@Service
public class TemplateServiceMongoDBImpl implements TemplateService {
    @Override
    public void save(TemplateDTO templateDTO) {
        System.out.println("MongoDB模板保存成功");
    }

    @Override
    public void update(TemplateDTO templateDTO) {
        System.out.println("MongoDB模板更新成功");
    }

    @Override
    public void remove(TemplateDTO templateDTO) {
        System.out.println("MongoDB模板删除成功");
    }
}
