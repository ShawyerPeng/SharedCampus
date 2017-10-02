package service;

import po.Follow;
import po.PagedResult;

public interface FollowService {
    int insertFollow(Follow follow);

    int deleteFollow(Integer followId);

    PagedResult<Follow> getAllFollows(Integer pageNo, Integer pageSize);
}
