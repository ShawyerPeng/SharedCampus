package service.impl;

import com.github.pagehelper.PageHelper;
import mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Collect;
import po.PagedResult;
import service.CollectService;
import utils.BeanUtil;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int insertCollect(Collect collect) {
        return collectMapper.insert(collect);
    }

    @Override
    public int deleteCollect(Integer collectId) {
        return collectMapper.deleteByPrimaryKey(collectId);
    }

    @Override
    public PagedResult<Collect> getAllCollects(Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(collectMapper.selectAllCollects());
    }
}
