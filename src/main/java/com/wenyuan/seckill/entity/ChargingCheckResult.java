package com.wenyuan.seckill.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by Wen on 17/2/25.
 */
public class ChargingCheckResult {
    private List<Integer> subscribeFields;
    private Map<String, String> columName;
    private List<Map<String, String>> records;

    public List<Integer> getSubscribeFields() {
        return subscribeFields;
    }

    public void setSubscribeFields(List<Integer> subscribeFields) {
        this.subscribeFields = subscribeFields;
    }

    public Map<String, String> getColumName() {
        return columName;
    }

    public void setColumName(Map<String, String> columName) {
        this.columName = columName;
    }

    public List<Map<String, String>> getRecords() {
        return records;
    }

    public void setRecords(List<Map<String, String>> records) {
        this.records = records;
    }
}
