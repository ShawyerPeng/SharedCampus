package service;

import po.DakaFollow;
import po.Follow;
import po.PagedResult;

public interface DakaFollowService {
    int insertDakaFollow(DakaFollow dakaFollow);

    int deleteDakaFollow(Integer dakaId, Integer followerId);

    int getFollowerCount(Integer dakaId);

    PagedResult<DakaFollow> getAllDakaFollows(Integer pageNo, Integer pageSize);
}
