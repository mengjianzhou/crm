package com.robert.schoolMgr.controller;

import com.alibaba.fastjson.JSON;
import com.robert.schoolMgr.bean.UserInfo;
import com.robert.schoolMgr.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auth mengjianzhou
 * @Date 2017/12/9
 */
@Controller
public class UserInfoController {

//    @Autowired
//    private UserInfoService userInfoService;
//
//    @RequestMapping("selectUserInfo")
//    @ResponseBody
//    public UserInfo selectUserInfo(Integer id){
//        return userInfoService.selectUserInfo(id);
//    }
//
//    @RequestMapping
//    @ResponseBody
//    public String queryUsers(){
//        List<UserInfo> userInfoList = userInfoService.queryUsers();
//        String json = JSON.toJSONString(userInfoList);
//        return json;
//    }
}
