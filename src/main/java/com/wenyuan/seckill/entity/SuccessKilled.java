package com.wenyuan.seckill.entity;

import java.util.Date;

/**
 * Created by Wen on 16/8/20.
 */
public class SuccessKilled {
    private long seckillID;
    private long userPhone;
    private short state;
    private Date createTime;

    //复合属性
    private Seckill seckill;

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillID=" + seckillID +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill.toString() +
                '}';
    }

    public long getSeckillID() {
        return seckillID;
    }

    public void setSeckillID(long seckillID) {
        this.seckillID = seckillID;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
