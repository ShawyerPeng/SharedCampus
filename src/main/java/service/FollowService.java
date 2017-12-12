package service;

import po.Follow;
import po.PagedResult;

public interface FollowService {
    int insertFollow(Follow follow);

    int deleteFollow(Integer followId);

    PagedResult<Follow> getFolloweds(Integer followerId, Integer pageNo, Integer pageSize);

    PagedResult<Follow> getFollowers(Integer followedId, Integer pageNo, Integer pageSize);

    PagedResult<Follow> getAllFollows(Integer pageNo, Integer pageSize);
}
