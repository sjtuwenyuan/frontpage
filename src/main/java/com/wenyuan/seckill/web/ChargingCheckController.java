package com.wenyuan.seckill.web;

import com.wenyuan.seckill.entity.ChargingCheckResult;
import com.wenyuan.seckill.service.ChargingCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wen on 17/2/26.
 */
@Controller
public class ChargingCheckController extends BaseExceptionHandleAction {

    @Autowired
    private ChargingCheckService chargingCheckService;

    final private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    @RequestMapping(value = "/query/ufdr/starttime/{startTime}/endtime/{endTime}/imsi/{imsi}",
            method = RequestMethod.GET)
    @ResponseBody
    public ChargingCheckResult queryUfdr(@PathVariable("startTime") String startTime,
                                         @PathVariable("endTime") String endTime,
                                         @PathVariable("imsi") String imsi) throws ParseException {
        Date sTime = dateFormat.parse(startTime);
        Date eTime = dateFormat.parse(endTime);
        ChargingCheckResult result = chargingCheckService.queryUfdr(sTime, eTime, imsi);
        return result;
    }
}
