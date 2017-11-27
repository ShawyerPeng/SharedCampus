package service.impl;

import com.github.pagehelper.PageHelper;
import mapper.DakaFollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.DakaFollow;
import po.Follow;
import po.PagedResult;
import service.DakaFollowService;
import utils.BeanUtil;

public class DakaFollowServiceImpl implements DakaFollowService {
    @Autowired
    private DakaFollowMapper dakaFollowMapper;

    @Override
    public int insertDakaFollow(DakaFollow dakaFollow) {
        return dakaFollowMapper.insert(dakaFollow);
    }

    @Override
    public int deleteDakaFollow(Integer dakaId, Integer followerId) {
        return dakaFollowMapper.deleteByDakaIdAndFollowerId(dakaId, followerId);
    }

    @Override
    public int getFollowerCount(Integer dakaId) {
        return dakaFollowMapper.selectFollowerCount(dakaId);
    }

    @Override
    public PagedResult<DakaFollow> getAllDakaFollows(Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(dakaFollowMapper.selectAllDakaFollows());
    }
}
