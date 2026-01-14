package com.example.presentation.template;

import com.example.presentation.annotaion.DoubleWrite;
import com.example.presentation.model.TemplateDTO;
import org.springframework.stereotype.Service;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 11:22
 */
@Service
public class TemplateServiceRDBImpl implements TemplateService {
    @Override
    @DoubleWrite(instance = SaveTemplateConvert.class)
    public void save(TemplateDTO templateDTO) {
        System.out.println("RDB模板保存成功");
        throw new RuntimeException("异常啦");
    }

    @Override
    @DoubleWrite(instance = UpdateTemplateConvert.class)
    public void update(TemplateDTO templateDTO) {
        System.out.println("RDB模板更新成功");
    }

    @Override
    @DoubleWrite(instance = RemoveTemplateConvert.class)
    public void remove(TemplateDTO templateDTO) {
        System.out.println("RDB模板删除成功");
    }
}
