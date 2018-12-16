package com.robert.schoolMgr.dao;

import com.robert.schoolMgr.bean.UserInfo;
import com.robert.schoolMgr.bean.XuanTiInfo;

import java.util.List;

/**
 * @auth mengjianzhou
 * @Date 2017/10/28
 */
public interface UserMapper {

    void addXuantiInfo(XuanTiInfo xuanTiInfo);

    String queryByMobile(String mobile);
}
