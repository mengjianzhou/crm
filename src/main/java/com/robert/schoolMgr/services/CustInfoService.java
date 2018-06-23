package com.robert.schoolMgr.services;

import com.robert.schoolMgr.bean.CustInfo;
import com.robert.schoolMgr.bean.Pager;

import java.util.List;

/**
 * @auth mengjianzhou
 * @Date 2018/3/7
 */
public interface CustInfoService {
    List<CustInfo> getAllCustInfo();

    List<CustInfo> getAllCustPageInfo(CustInfo custInfo, Pager pager);

    void addCustInfo(CustInfo custInfo);

    int getAllCustInfoCount();
}
