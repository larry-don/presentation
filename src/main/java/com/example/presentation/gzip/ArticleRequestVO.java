package com.example.presentation.gzip;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/2/1 9:33
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleRequestVO implements Serializable {

    private Long id;

    private String title;

    private String content;

}