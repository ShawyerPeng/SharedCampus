package service.impl;

import com.github.pagehelper.PageHelper;
import mapper.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Follow;
import po.PagedResult;
import service.FollowService;
import utils.BeanUtil;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Override
    public int insertFollow(Follow follow) {
        return followMapper.insert(follow);
    }

    @Override
    public int deleteFollow(Integer followId) {
        return followMapper.deleteByPrimaryKey(followId);
    }

    /**
     * 获取所有被某用户followerId关注了的人
     */
    @Override
    public PagedResult<Follow> getFolloweds(Integer followerId, Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(followMapper.selectAllFolloweds(followerId));
    }

    /**
     * 获取所有关注了某用户followedId的人
     */
    @Override
    public PagedResult<Follow> getFollowers(Integer followedId, Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(followMapper.selectAllFollowers(followedId));
    }

    @Override
    public PagedResult<Follow> getAllFollows(Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(followMapper.selectAllFollows());
    }
}