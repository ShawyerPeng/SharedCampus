package service;

import po.User;

public interface UserService {
    void insertUser(String userName, String userPass);
    boolean isExistsUserName(String userName);
    boolean isPassCorrect(String userName, String userPass);
    User getUserByUserName(String userName);
}
