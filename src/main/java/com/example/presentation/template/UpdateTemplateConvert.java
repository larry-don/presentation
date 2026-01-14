package com.example.presentation.template;

import com.example.presentation.model.TemplateDTO;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 15:53
 */
public class UpdateTemplateConvert implements TemplateConvert{
    @Override
    public void invoke(Object... args) {
        TemplateServiceMongoDBImpl templateServiceMongoDB = new TemplateServiceMongoDBImpl();
        templateServiceMongoDB.update((TemplateDTO) args[0]);
    }
}
