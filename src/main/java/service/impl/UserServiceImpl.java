package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.User;
import service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public int insertUser(String userName, String userPass) {
        User user = new User(userName, userPass);
        user.setHonesty(100);
        // 返回自增ID
        return userMapper.insert(user);
    }

    public boolean isExistsUserName(String userName) {
        User user = userMapper.selectByUserName(userName);
        if (user != null) {
            return true;
        }
        return false;
    }

    public boolean isPassCorrect(String userName, String userPass) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        params.put("userPass", userPass);
        User user = userMapper.selectByUserPass(userName, userPass);
        if (user != null) {
            return true;
        }
        return false;
    }

    public User getUserByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    public int selectRowCount() {
        return userMapper.selectRowCount();
    }

    public int deleteUser(String userName, String userPass) {
        User user = userMapper.selectByUserName(userName);
        return userMapper.deleteByPrimaryKey(user.getUserId());
    }

    public int changePass(String userName, String newPass) {
        int userId = getUserByUserName(userName).getUserId();
        User user = new User(userId, userName, newPass);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateUser(String userName, String realname, Integer gender, String phone, String email, String alipay, String iconimg, String info) {
        int userId = getUserByUserName(userName).getUserId();
        User user = new User(userId, userName, realname, gender, phone, email, alipay, iconimg, info);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateUser1(String userName, String userPass, String realname, Integer gender, String phone, String email, String alipay, String iconimg, String info, Date createdTime, Date lastLogin, Integer honesty, Double balance) {
        return 0;
    }

    public int updateUser(String userName, String userPass, String realname, Integer gender, String phone, String email,
                          String alipay, String iconimg, String info, Date createdTime, Date lastLogin, Integer honesty, Double balance) {
        int userId = getUserByUserName(userName).getUserId();
        User user = new User(userId, userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
