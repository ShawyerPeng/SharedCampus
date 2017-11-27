package mapper;

import org.apache.ibatis.annotations.Param;
import po.Daka;
import po.DakaExample;

import java.util.List;

public interface DakaMapper {
    int countByExample(DakaExample example);

    int deleteByExample(DakaExample example);

    int deleteByPrimaryKey(Integer dakaId);

    int insert(Daka record);

    int insertSelective(Daka record);

    List<Daka> selectByExample(DakaExample example);

    Daka selectByPrimaryKey(Integer dakaId);

    int updateByExampleSelective(@Param("record") Daka record, @Param("example") DakaExample example);

    int updateByExample(@Param("record") Daka record, @Param("example") DakaExample example);

    int updateByPrimaryKeySelective(Daka record);

    int updateByPrimaryKey(Daka record);

    int deleteByUserId(Integer userId);
}