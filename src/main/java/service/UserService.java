package service;

import po.User;

import java.util.Date;

public interface UserService {
    int insertUser(User user);

    boolean isExistsUserName(String userName);

    boolean isPassCorrect(String userName, String userPass);

    User getUserByUserName(String userName);

    User getUserByUserId(Integer userId);

    int selectRowCount();

    int deleteUser(String userName, String userPass);

    int changePass(String userName, String userPass);

    int updateUser(String userName, String realname, Integer gender, String phone, String email, String alipay, String iconimg, String info);

    int updateUser1(String userName, String userPass, String realname, Integer gender, String phone, String email,
                   String alipay, String iconimg, String info, Date createdTime, Date lastLogin, Integer honesty, Double balance);
}