package service;

import po.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {
    void insertTask(Integer publisherId, String title, String description, Integer category,
                    Double price, Integer counts, Date starttime, Date endtime);

    void insertTaskWithPic(Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime, String pic);

    void updateTask(Integer taskId, Integer publisherId, String title, String description, Integer category,
                    Double price, Integer counts, Date starttime, Date endtime);

    void deleteTask(Integer taskId);

    List<Task> selectTask(Integer publisherId);
}
