package com.wenyuan.seckill.web;

import com.wenyuan.seckill.entity.Person;
import com.wenyuan.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Wen on 16/11/1.
 */

@Controller
public class AjaxController {

    private final Logger logger = LoggerFactory.getLogger(AjaxController.class);

    @Autowired
    SeckillService seckillService;

    @RequestMapping(value = "/list/people", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPeoples() {
        return seckillService.getAllUser();
    }


    @RequestMapping(value = "/add/people", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Person person) {
        seckillService.addUser(person);
        return "OK";
    }
}
