package mapper;

import org.apache.ibatis.annotations.Param;
import po.PagedResult;
import po.Task;
import po.TaskExample;

import java.util.List;

public interface TaskMapper {
    int countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectAllTasks();

    Task selectByTaskId(Integer taskId);

    List<Task> selectByPublisherId(Integer publisherId);

    List<Task> selectUncompletedByPublisherId(Integer publisherId);

    List<Task> selectCompletedByPublisherId(Integer publisherId);

    List<Task> selectByTitle(String title);

    List<Task> selectByCategory(int category);
}