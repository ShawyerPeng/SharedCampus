package mapper;

import org.apache.ibatis.annotations.Param;
import po.DakaFollow;
import po.DakaFollowExample;
import po.Follow;

import java.util.List;

public interface DakaFollowMapper {
    int countByExample(DakaFollowExample example);

    int deleteByExample(DakaFollowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DakaFollow record);

    int insertSelective(DakaFollow record);

    List<DakaFollow> selectByExample(DakaFollowExample example);

    DakaFollow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DakaFollow record, @Param("example") DakaFollowExample example);

    int updateByExample(@Param("record") DakaFollow record, @Param("example") DakaFollowExample example);

    int updateByPrimaryKeySelective(DakaFollow record);

    int updateByPrimaryKey(DakaFollow record);

    int selectFollowerCount(Integer dakaId);

    List<DakaFollow> selectAllDakaFollows();

    int deleteByDakaIdAndFollowerId(@Param("dakaId") Integer dakaId, @Param("followerId") Integer followerId);
}