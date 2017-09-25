package service.impl;

import mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Task;
import service.TaskService;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    public void insertTask(Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime) {
        Task task = new Task(publisherId, title, description, category, price, counts, starttime, endtime);
        taskMapper.insert(task);
    }

    // TODO：任务图片上传有可能是多张，pic要为数组
    public void insertTaskWithPic(Integer publisherId, String title, String description, Integer category,
                                  Double price, Integer counts, Date starttime, Date endtime, String pic) {
        Task task = new Task(publisherId, title, description, category, price, counts, starttime, endtime, pic);
        taskMapper.insert(task);
    }

    public void updateTask(Integer taskId, Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime) {
        // TODO：如果某一行参数为空，POST过来默认作为空字符串而不是NULL，这回导致更新时将内容更新为空
        if (description.equals("")) description = null;
        Task task = new Task(taskId, publisherId, title, description, category, price, counts, starttime, endtime);
        taskMapper.updateByPrimaryKeySelective(task);
    }

    public void deleteTask(Integer taskId) {
        taskMapper.deleteByPrimaryKey(taskId);
    }

    public List<Task> selectTask(Integer publisherId) {
        return taskMapper.selectByPublisherId(publisherId);
    }

}
