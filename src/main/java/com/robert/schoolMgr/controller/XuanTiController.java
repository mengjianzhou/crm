package com.robert.schoolMgr.controller;

import com.alibaba.druid.util.StringUtils;
import com.robert.schoolMgr.bean.XuanTiInfo;
import com.robert.schoolMgr.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class XuanTiController {

    private static final Logger logger = LoggerFactory.getLogger(XuanTiController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/xuanti",method=RequestMethod.POST)
    @ResponseBody
    public String xuanti(String mobile, String name){
        logger.info("mobile={}, name={}", mobile, name);

        XuanTiInfo xuanTiInfo = new XuanTiInfo();
        xuanTiInfo.setMobile(mobile);
        xuanTiInfo.setName(name);

        String num = userMapper.queryByMobile(mobile);
        if(StringUtils.isEmpty(num)){
            num = getRandomCode();
            xuanTiInfo.setNum(num);
            userMapper.addXuantiInfo(xuanTiInfo);
        }
        return num;
    }

    @RequestMapping("xuanTiResult")
    public ModelAndView xuantiResult(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("xuantiResult");
        List<XuanTiInfo> xuanTiInfoList = userMapper.queryAllXuanTiResult();
        mv.addObject("data", xuanTiInfoList);
        return mv;
    }

    @RequestMapping(value="clearAllXuanTiResult", method=RequestMethod.POST)
    @ResponseBody
    public void clearAllXuanTiResult(){
        userMapper.clearAllXuanTiResult();
    }

    private String getRandomCode(){
        Random random = new Random();
        int a = random.nextInt(10);
        return String.valueOf(a+1);
    }
}
