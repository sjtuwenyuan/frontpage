package com.wenyuan.seckill.service;

import com.wenyuan.seckill.entity.ChargingCheckResult;

import java.util.Date;

/**
 * Created by Wen on 17/2/26.
 */
public interface ChargingCheckService {
    ChargingCheckResult queryUfdr(Date startTime, Date endTime, String imsi);
}
