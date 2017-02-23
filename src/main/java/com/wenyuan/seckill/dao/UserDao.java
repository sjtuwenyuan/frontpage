package com.wenyuan.seckill.dao;

import com.wenyuan.seckill.entity.Person;

import java.util.List;

/**
 * Created by Wen on 16/12/18.
 */
public interface UserDao {
    List<Person> getAllUser();

    void addUser(Person person);
}
