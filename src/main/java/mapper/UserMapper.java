package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.User;
import po.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectRowCount();

    User selectByUserName(String userName);

    User selectByUserPass(@Param("userName") String userName, @Param("userPass") String userPass);
}