package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.User;
import service.PocketService;

@Service
public class PocketServiceImpl implements PocketService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updatePocket(User user, Double amount) {
        int userId = user.getUserId();
        // 原钱包剩余
        Double balance = userMapper.selectByPrimaryKey(userId).getBalance();
        // 减去/加上amount后的钱包剩余
        Double newBalance = balance + amount;
        user.setBalance(newBalance);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
