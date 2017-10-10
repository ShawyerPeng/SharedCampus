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

    Task selectTaskByTaskId(Integer taskId);

    PagedResult<Task> queryByPage(Integer pageNo, Integer pageSize);

    PagedResult<Task> selectTask(Integer publisherId, Integer pageNo, Integer pageSize);

    PagedResult<Task> selectUncompletedTask(Integer publisherId, Integer pageNo, Integer pageSize);

    PagedResult<Task> selectCompletedTask(Integer publisherId, Integer pageNo, Integer pageSize);

    PagedResult<Task> selectTaskByTitle(String title, Integer pageNo, Integer pageSize);

    PagedResult<Task> selectTaskByCategory(String category, Integer pageNo, Integer pageSize);
}
