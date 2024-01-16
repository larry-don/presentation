package com.example.presentation.order;

import lombok.Data;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:17
 */
@Data
public class OperateRecord {
    public String id;
    public String operateType;
    public String recordNO;

    @Override
    public String toString() {
        return "OperateRecord{" +
                "id='" + id + '\'' +
                ", operateType='" + operateType + '\'' +
                ", recordNO='" + recordNO + '\'' +
                '}';
    }
}
