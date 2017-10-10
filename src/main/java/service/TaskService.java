package service;

import po.PagedResult;
import po.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {
    int insertTask(Integer publisherId, String title, String description, Integer category,
                    Double price, Integer counts, Date starttime, Date endtime);

    int insertTaskWithPic(Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime, String pic);

    int updateTask(Integer taskId, Integer publisherId, String title, String description, Integer category,
                    Double price, Integer counts, Date starttime, Date endtime);

    int deleteTask(Integer taskId);

    PagedResult<Task> queryByPage(Integer pageNo, Integer pageSize);

    Task selectTaskByTaskId(Integer taskId);

    List<Task> selectTask(Integer publisherId);

    List<Task> selectUncompletedTask(Integer publisherId);

    List<Task> selectCompletedTask(Integer publisherId);

    List<Task> selectTaskByTitle(String title);

    List<Task> selectTaskByCategory(String category);
}
