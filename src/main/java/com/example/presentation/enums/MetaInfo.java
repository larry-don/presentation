package com.example.presentation.enums;

import com.example.presentation.config.MyProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MetaInfo {
    TITLE_INFO(new MyProperties.NestedConfig("title", "Presentation")),
    DESCRIPTION_INFO(new MyProperties.NestedConfig("description", "Presentation")),
    KEYWORDS_INFO(new MyProperties.NestedConfig("keywords", "Presentation"));

    @NonNull
    private final MyProperties.NestedConfig config;

//    MetaInfo(MyProperties.NestedConfig config) {
//        this.config = config;
//    }
}
