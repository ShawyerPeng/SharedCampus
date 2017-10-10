package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.PagedResult;
import po.Task;
import service.TaskService;
import utils.BeanUtil;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int insertTask(Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime) {
        Task task = new Task(publisherId, title, description, category, price, counts, starttime, endtime);
        return taskMapper.insert(task);
    }

    // TODO：任务图片上传有可能是多张，pic要为数组
    @Override
    public int insertTaskWithPic(Integer publisherId, String title, String description, Integer category,
                                  Double price, Integer counts, Date starttime, Date endtime, String pic) {
        Task task = new Task(publisherId, title, description, category, price, counts, starttime, endtime, pic);
        return taskMapper.insert(task);
    }

    @Override
    public int updateTask(Integer taskId, Integer publisherId, String title, String description, Integer category,
                           Double price, Integer counts, Date starttime, Date endtime) {
        // TODO：如果某一行参数为空，POST过来默认作为空字符串而不是NULL，这回导致更新时将内容更新为空
        if (description.equals("")) description = null;
        Task task = new Task(taskId, publisherId, title, description, category, price, counts, starttime, endtime);
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public int deleteTask(Integer taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    /**
     * 分页查询任务
     * @param pageNo   查询条件，可为空，默认取 1
     * @param pageSize 查询条件，可为空，默认取 10
     */
    @Override
    public PagedResult<Task> queryByPage(Integer pageNo, Integer pageSize) {
        pageNo = (pageNo == null ? 1 : pageNo);
        pageSize = (pageSize == null ? 10 : pageSize);
        PageHelper.startPage(pageNo, pageSize);      //startPage 是告诉拦截器说我要开始分页了。分页参数是这两个。

        return BeanUtil.toPagedResult(taskMapper.selectAllTasks());
    }

    @Override
    public Task selectTaskByTaskId(Integer taskId) {
        return taskMapper.selectByTaskId(taskId);
    }

    @Override
    public List<Task> selectTask(Integer publisherId) {
        return taskMapper.selectByPublisherId(publisherId);
    }

    @Override
    public List<Task> selectUncompletedTask(Integer publisherId) {
        return taskMapper.selectUncompletedByPublisherId(publisherId);
    }

    @Override
    public List<Task> selectCompletedTask(Integer publisherId) {
        return taskMapper.selectCompletedByPublisherId(publisherId);
    }

    @Override
    public List<Task> selectTaskByTitle(String title) {
        return taskMapper.selectByTitle(title);
    }

    @Override
    public List<Task> selectTaskByCategory(String category) {
        Map<String, Object> categoryMap = new HashMap<>();
        // TODO: 修改对应的分类
        categoryMap.put("1", "寻人");
        categoryMap.put("2", "失物招领");
        categoryMap.put("3", "找队友");
        categoryMap.put("4", "办事");
        categoryMap.put("5", "二手交易");
        categoryMap.put("6", "学习辅导");
        categoryMap.put("7", "代取快递");
        categoryMap.put("8", "表白");
        categoryMap.put("9", "推荐");

        int categoryInteger = 0;
        for (Map.Entry<String, Object> entry : categoryMap.entrySet()) {
            if (entry.getValue().equals(category)) {
                categoryInteger = Integer.parseInt(entry.getKey());
            }
        }
        if (categoryInteger != 0) {
            return taskMapper.selectByCategory(categoryInteger);
        }
        return new LinkedList<>();
    }
}
