package service;

import po.Daka;

public interface DakaService {
    int insertDaka(Daka daka);

    int deleteDaka(Integer userId);

    int updateDaka(Daka daka);

    Daka selectDakaByDakaId(Integer dakaId);
}
