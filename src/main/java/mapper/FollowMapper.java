package mapper;

import org.apache.ibatis.annotations.Param;
import po.Follow;
import po.FollowExample;

import java.util.List;

public interface FollowMapper {
    int countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int deleteByPrimaryKey(Integer followId);

    int insert(Follow record);

    int insertSelective(Follow record);

    List<Follow> selectByExample(FollowExample example);

    Follow selectByPrimaryKey(Integer followId);

    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    List<Follow> selectAllFolloweds(@Param("followerId") Integer followerId);

    List<Follow> selectAllFollowers(@Param("followedId") Integer followedId);

    List<Follow> selectAllFollows();
}