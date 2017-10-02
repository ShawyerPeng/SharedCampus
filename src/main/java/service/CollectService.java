package service;

import po.Collect;
import po.PagedResult;

public interface CollectService {
    int insertCollect(Collect collect);

    int deleteCollect(Integer collectId);

    PagedResult<Collect> getAllCollects(Integer pageNo, Integer pageSize);
}
