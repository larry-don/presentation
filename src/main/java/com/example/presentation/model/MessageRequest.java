package com.example.presentation.model;

import lombok.Data;

import java.util.List;

@Data
public class MessageRequest {
    private String businessId;
    private List<ContentZone> contentZone;

}
