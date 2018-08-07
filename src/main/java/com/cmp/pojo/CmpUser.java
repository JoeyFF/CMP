package com.cmp.pojo;

import java.io.Serializable;
import java.util.Date;

public class CmpUser implements Serializable {
    /**
     * 用户在此公众平台上唯一标识
     */
    private String openid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 性别 1：男性 2 女性
     */
    private Byte sex;

    /**
     * 用户所在省份
     */
    private String province;

    /**
     * 用户所在城市
     */
    private String city;

    /**
     * 用户所在国家
     */
    private String country;

    /**
     * 用户的详细地址
     */
    private String address;

    /**
     * 用户头像url
     */
    private String headimgurl;

    /**
     * 1 已关注 0 未关注 2 卖家
     */
    private Byte subscribe;

    /**
     * 用户所在分组id
     */
    private Long groupid;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 密码，md5加密
     */
    private String password;

    /**
     * 学校名称
     */
    private String school;

    /**
     * 注册微信号
     */
    private String wx;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 注册时间
     */
    private Date created;

    private static final long serialVersionUID = 1L;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public Byte getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx == null ? null : wx.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(",\"realname\":\"")
                .append(realname).append('\"');
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
        sb.append(",\"remark\":\"")
                .append(remark).append('\"');
        sb.append(",\"created\":\"")
                .append(created).append('\"');
        sb.append('}');
        return sb.toString();
    }
}