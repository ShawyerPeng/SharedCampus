package po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.CustomDateSerializer;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPass;

    private Date created;

    private Date lastLogin;

    public User() {
    }

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public User(Integer userId, String userName, String userPass, Date created, Date lastLogin) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.created = created;
        this.lastLogin = lastLogin;
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

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}