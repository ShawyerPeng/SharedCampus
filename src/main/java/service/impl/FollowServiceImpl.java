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

    @Override
    public PagedResult<Follow> getAllFollows(Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(followMapper.selectAllFollows());
    }
}
