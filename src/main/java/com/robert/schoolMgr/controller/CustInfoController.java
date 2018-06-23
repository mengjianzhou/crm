package com.robert.schoolMgr.controller;

import com.alibaba.fastjson.JSON;
import com.robert.schoolMgr.bean.CustInfo;
import com.robert.schoolMgr.bean.Pager;
import com.robert.schoolMgr.services.CustInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auth mengjianzhou
 * @Date 2018/3/7
 */
@Controller
public class CustInfoController {

    @Autowired
    private CustInfoService custInfoService;

    @RequestMapping("/custMgr")
    public String custMgrPage(){
        return "custMgr";
    }

    @RequestMapping(value="/getCustInfoList",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCustInfoList(String page,String limit,String custName){
        page = "2";
        limit = "1000";

        CustInfo custInfo = new CustInfo();
        custInfo.setName(custName);
        Pager pager = new Pager();
        pager.setPageNo(Integer.parseInt(page));
        pager.setPageSize(Integer.parseInt(limit));
        Map<String, Object> result = new HashMap();
        List<CustInfo> custInfoList = custInfoService.getAllCustPageInfo(custInfo, pager);
        int count = custInfoService.getAllCustInfoCount();
        result.put("count", count);
        result.put("data", custInfoList);
        result.put("code",0);
        result.put("msg", "");
        String resultJson = JSON.toJSONString(result);
        return resultJson;
    }

    @RequestMapping(value = "/addCustInfo", method = RequestMethod.POST)
    @ResponseBody
    public String addCustInfo(String realName,String mobile, String comment){
        Map<String, Object> result = new HashMap();
        CustInfo custInfo = new CustInfo();
        custInfo.setName(realName);
        custInfo.setMobile(mobile);
        custInfo.setComment(comment);
        custInfoService.addCustInfo(custInfo);

        String resultJson = JSON.toJSONString(result);
        return resultJson;
    }

}
