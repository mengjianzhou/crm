package com.robert.schoolMgr.dao;

import com.robert.schoolMgr.bean.CustInfo;
import com.robert.schoolMgr.bean.Pager;

import java.util.List;
import java.util.Map;

/**
 * @auth mengjianzhou
 * @Date 2018/3/7
 */
public interface CustInfoMapper {

    List<CustInfo> getAllCustInfo();

    void addCustInfo(CustInfo custInfo);

    List<CustInfo> getAllCustPageInfo(Map<String, Object> params);

    int getAllCustInfoCount();
}
