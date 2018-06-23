package com.robert.schoolMgr.bean;

/**
 * @auth mengjianzhou
 * @Date 2018/3/7
 */
public class CustInfo {

    private int id;
    /**年龄*/
    private String age;
    private String name;
    private String mobile;
    /**投资金额*/
    private String investAmount;
    /**备注*/
    private String comment;
    /**身份证号*/
    private String idNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }


    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
