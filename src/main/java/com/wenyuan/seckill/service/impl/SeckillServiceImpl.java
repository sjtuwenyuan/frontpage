package com.wenyuan.seckill.service.impl;

import com.wenyuan.seckill.dao.SeckillDao;
import com.wenyuan.seckill.dao.SuccessKilledDao;
import com.wenyuan.seckill.dao.UserDao;
import com.wenyuan.seckill.dto.Exposer;
import com.wenyuan.seckill.dto.SeckillExecution;
import com.wenyuan.seckill.entity.Person;
import com.wenyuan.seckill.entity.Seckill;
import com.wenyuan.seckill.entity.SuccessKilled;
import com.wenyuan.seckill.enums.SeckillStatEnum;
import com.wenyuan.seckill.exception.RepeatKillException;
import com.wenyuan.seckill.exception.SeckillCloseException;
import com.wenyuan.seckill.exception.SeckillException;
import com.wenyuan.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Wen on 16/8/21.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    @Autowired
    private UserDao userDao;

    private final String slat = "adsadsadsadfdsfdsafdasfdffasdasdasxzcnbgsqd";

    public List<Seckill> getSeckilkList() {
        return seckillDao.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }


    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (null == seckill)
            return new Exposer(false, seckillId);
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime())
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());

        String md5 = getMD5(seckillId);

        return new Exposer(true, md5, seckillId);
    }


    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {
        try {
            if (null == md5 || !md5.equals(getMD5(seckillId))) {
                throw new SeckillException("rewrite!");
            }
            Date nowTime = new Date();
            int updataCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updataCount <= 0) {
                throw new SeckillCloseException("closed!");
            } else {
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    throw new RepeatKillException("killed repeated!");
                } else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("inner error" + e.getMessage());
        }
    }

    public List<Person> getAllUser() {
        return userDao.getAllUser();
    }

    public void addUser(Person person) {
        userDao.addUser(person);
    }
}
