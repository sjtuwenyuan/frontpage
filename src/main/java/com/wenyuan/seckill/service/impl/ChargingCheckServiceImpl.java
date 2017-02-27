package com.wenyuan.seckill.service.impl;

import com.wenyuan.seckill.entity.ChargingCheckResult;
import com.wenyuan.seckill.service.ChargingCheckService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Wen on 17/2/26.
 */
@Service
public class ChargingCheckServiceImpl implements ChargingCheckService {


    public ChargingCheckResult queryUfdr(Date startTime, Date endTime, String imsi) {
        ChargingCheckResult result = new ChargingCheckResult();

        List<Integer> subscribeFields = new ArrayList<Integer>();
        subscribeFields.add(1);
        subscribeFields.add(2);
        subscribeFields.add(3);
        subscribeFields.add(4);
        subscribeFields.add(5);
        subscribeFields.add(6);
        subscribeFields.add(7);
        subscribeFields.add(8);
        subscribeFields.add(9);
        subscribeFields.add(10);
        subscribeFields.add(11);
        subscribeFields.add(12);
        result.setSubscribeFields(subscribeFields);

        Map<String, String> columName = new HashMap<String, String>();
        columName.put("1", "name");
        columName.put("2", "age");
        columName.put("3", "email");
        columName.put("4", "email");
        columName.put("5", "email");
        columName.put("6", "email");
        columName.put("7", "email");
        columName.put("8", "email");
        columName.put("9", "email");
        columName.put("10", "email");
        columName.put("11", "email");
        columName.put("12", "email");
        result.setColumName(columName);

        List<Map<String, String>> records = new ArrayList<Map<String, String>>();
        Map<String, String> record = new HashMap<String, String>();
        record.put("1", "wenyuan");
        record.put("2", "26");
        record.put("3", "wenyuan@163.com");
        record.put("4", "wenyuan@163.com");
        record.put("5", "wenyuan@163.com");
        record.put("6", "wenyuan@163.com");
        record.put("7", "wenyuan@163.com");
        record.put("8", "wenyuan@163.com");
        record.put("9", "wenyuan@163.com");
        record.put("10", "wenyuan@163.com");
        record.put("11", "wenyuan@163.com");
        record.put("12", "wenyuan@163.com");
        records.add(record);
        result.setRecords(records);
        return result;
    }
}
