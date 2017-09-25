package po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.CustomDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPass;

    private String realname;

    private Integer gender;

    private String phone;

    private String email;

    private String alipay;

    private String iconimg;

    private String info;

    private Date createdTime;

    private Date lastLogin;

    private Integer honesty;

    private Double balance;

    public User() {
    }

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public User(Integer userId, String userName, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
    }

    public User(Integer userId, String userName, String userPass, Date createdTime, Date lastLogin) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.createdTime = createdTime;
        this.lastLogin = lastLogin;
    }

    public User(Integer userId, String userName, String userPass, String realname, Integer gender, String phone, String email,
                String alipay, String iconimg, String info, Date createdTime, Date lastLogin, Integer honesty, Double balance) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.realname = realname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.alipay = alipay;
        this.iconimg = iconimg;
        this.info = info;
        this.createdTime = createdTime;
        this.lastLogin = lastLogin;
        this.honesty = honesty;
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg == null ? null : iconimg.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getHonesty() {
        return honesty;
    }

    public void setHonesty(Integer honesty) {
        this.honesty = honesty;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}