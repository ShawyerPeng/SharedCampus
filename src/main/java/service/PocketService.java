package service;

import po.User;

public interface PocketService {
    User getUserByPrimaryKey(Integer userId);

    int updatePocket(User user, Double amount);
}
