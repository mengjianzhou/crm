package com.robert.schoolMgr.services.impl;

import com.robert.schoolMgr.bean.CustInfo;
import com.robert.schoolMgr.bean.Pager;
import com.robert.schoolMgr.dao.CustInfoMapper;
import com.robert.schoolMgr.services.CustInfoService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auth mengjianzhou
 * @Date 2018/3/7
 */
@Service
public class CustInfoServiceImpl implements CustInfoService{

    private Logger logger = LoggerFactory.getLogger(CustInfoServiceImpl.class);

    @Autowired
    private CustInfoMapper custInfoMapper;

    public List<CustInfo> getAllCustInfo(){
        return custInfoMapper.getAllCustInfo();
    }

    public List<CustInfo> getAllCustPageInfo(CustInfo custInfo, Pager pager) {
        Map<String, Object> map = new HashMap();
        map.put("custName", custInfo.getName());
        map.put("startNo", 1);
        map.put("pageSize", pager.getPageSize());

        List<CustInfo> custInfoList = custInfoMapper.getAllCustPageInfo(map);
        formatDataInfo(custInfoList);

        return custInfoList;
    }

    private void formatDataInfo(List<CustInfo> custInfoList) {
        for(CustInfo custInfo : custInfoList){
            String investAmount = custInfo.getInvestAmount();
            DecimalFormat df = new DecimalFormat("###,###,###.00");
            String formatAmount = df.format(new BigDecimal(investAmount).doubleValue());
            custInfo.setInvestAmount(formatAmount);
            String idNum = custInfo.getIdNum();
            String age = getAge(idNum);
            custInfo.setAge(age);

            String region = getRegion(idNum);
        }
    }

    private String getRegion(String idNum) {
        String appcode = "bd2c028f1d6e4237a544f292c5181ea8";
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = httpClientBuilder.build();
        String requestUrl = "http://jisuidcard.market.alicloudapi.com/idcard/query?idcard="+idNum;
        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.setHeader("Authorization", "APPCODE "+appcode);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");
            System.out.println("@@@["+idNum+"]="+responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getAge(String idNum) {
        String birthYearStr = idNum.substring(6,10);
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int birthYear = Integer.parseInt(birthYearStr);
        String ageStr = String.valueOf(currentYear-birthYear);
        return ageStr;
    }

    public void addCustInfo(CustInfo custInfo) {
        custInfoMapper.addCustInfo(custInfo);
    }

    public int getAllCustInfoCount() {
        return custInfoMapper.getAllCustInfoCount();
    }

}
