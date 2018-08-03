package com.cmp.pojo;

import java.util.Date;

/**
 * 用户表
 */
public class CmpUser {
    private String openid; //'用户在此公众平台上唯一标识'
    private String nickname; //'昵称',
    private Integer sex ; //'性别 1：男性 2 女性',
    private String province; // '用户所在省份',
    private String city; //'用户所在城市',
    private String country; //'用户所在国家',
    private String address; //'用户的详细地址',
    private String headimgurl; //'用户头像url',
    private Integer subscribe; //'1 已关注 0 未关注 2 卖家',
    private Integer groupid; //'用户所在分组id',
    private String phone; //'注册手机号',
    private String password; //'密码，md5加密',
    private String school; //学校名称',
    private String wx; //'注册微信号',
    private Date created; //'注册时间',

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"openid\":\"")
                .append(openid).append('\"');
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append(",\"province\":\"")
                .append(province).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append(",\"country\":\"")
                .append(country).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"headimgurl\":\"")
                .append(headimgurl).append('\"');
        sb.append(",\"subscribe\":")
                .append(subscribe);
        sb.append(",\"groupid\":")
                .append(groupid);
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"school\":\"")
                .append(school).append('\"');
        sb.append(",\"wx\":\"")
                .append(wx).append('\"');
        sb.append(",\"created\":\"")
                .append(created).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
