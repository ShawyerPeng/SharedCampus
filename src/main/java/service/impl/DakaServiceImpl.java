package service.impl;

import mapper.DakaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Daka;
import service.DakaService;

@Service
public class DakaServiceImpl implements DakaService {
    @Autowired
    private DakaMapper dakaMapper;

    @Override
    public int insertDaka(Daka daka) {
        return dakaMapper.insert(daka);
    }

    @Override
    public int deleteDaka(Integer userId) {
        return dakaMapper.deleteByUserId(userId);
    }

    @Override
    public int updateDaka(Daka daka) {
        return dakaMapper.updateByPrimaryKeySelective(daka);
    }

    @Override
    public Daka selectDakaByDakaId(Integer dakaId) {
        return dakaMapper.selectByPrimaryKey(dakaId);
    }

}
