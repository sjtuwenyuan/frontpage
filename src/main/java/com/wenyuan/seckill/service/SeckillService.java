package com.wenyuan.seckill.service;

import com.wenyuan.seckill.dto.Exposer;
import com.wenyuan.seckill.dto.SeckillExecution;
import com.wenyuan.seckill.entity.Person;
import com.wenyuan.seckill.entity.Seckill;
import com.wenyuan.seckill.exception.RepeatKillException;
import com.wenyuan.seckill.exception.SeckillCloseException;
import com.wenyuan.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by Wen on 16/8/21.
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckilkList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀地址
     * 没开始时输出秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    List<Person> getAllUser();

    void addUser(Person person);
}
