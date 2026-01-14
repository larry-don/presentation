package com.example.presentation.template;

import com.example.presentation.model.TemplateDTO;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 11:18
 */
public interface TemplateService {
    void save(TemplateDTO templateDTO);

    void update(TemplateDTO templateDTO);

    void remove(TemplateDTO templateDTO);
}
