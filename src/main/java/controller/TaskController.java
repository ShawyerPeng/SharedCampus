package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import po.PagedResult;
import po.RestResult;
import po.Task;
import service.TaskService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UploadController uploadController;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public RestResult insert(@RequestBody Task task) throws Exception {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        int success = taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("任务添加成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("任务添加失败");
            return result;
        }

    }

    @RequestMapping(value = "/insertWithPic", method = RequestMethod.POST)
    @ResponseBody
    public RestResult insertWithPic(@RequestBody Task task) throws Exception {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        String pic_url = task.getPic();

        int success;
        if (pic_url.isEmpty()) {
            success = taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
        } else {
            success = taskService.insertTaskWithPic(publisherId, title, description, category, price, counts, starttime, endtime, pic_url);
        }

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("任务添加成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("任务添加失败");
            return result;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public RestResult edit(@RequestBody Task task) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer taskId = task.getTaskId();
        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        int success = taskService.updateTask(taskId, publisherId, title, description,
                category, price, counts, starttime, endtime);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("任务修改成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("任务修改失败");
            return result;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResult delete(@RequestBody Task task) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer taskId = task.getTaskId();
        int success = taskService.deleteTask(taskId);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("任务删除成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("任务删除失败");
            return result;
        }
    }

    // http://localhost:8080/task/getTasks?pageNo=1&pageSize=20
    @RequestMapping(value = "/getTasks")
    @ResponseBody
    public PagedResult<Task> getTasks(@RequestBody PagedResult<Task> taskPagedResult) {
        Integer pageNo = taskPagedResult.getPageNo();
        Integer pageSize = taskPagedResult.getPageSize();
        try {
            return taskService.queryByPage(pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // http://localhost:8080/task/getTaskByTaskId?taskId=1
    @RequestMapping(value = "/getTaskByTaskId")
    @ResponseBody
    public List<Task> getTaskByTaskId(@RequestBody Task task) {
        Integer taskId = task.getTaskId();
        return taskService.selectTask(taskId);
    }

    // http://localhost:8080/task/getAllTasksByPublisherId?publisherId=1
    @RequestMapping(value = "/getAllTasksByPublisherId")
    @ResponseBody
    public List<Task> getAllTasksByPublisherId(@RequestBody Task task) {
        Integer publisherId = task.getPublisherId();
        return taskService.selectTask(publisherId);
    }

    @RequestMapping(value = "/getAllTasks2")
    @ResponseBody
    public List<Task> getAllTasksByPublisherId2(@RequestParam("publisherId") Integer publisherId) {
        return taskService.selectTask(publisherId);
    }

    // http://localhost:8080/task/getUncompletedTasks?publisherId=1
    @RequestMapping(value = "/getUncompletedTasks")
    @ResponseBody
    public List<Task> getUncompletedTasksByPublisherId(@RequestBody Task task) {
        Integer publisherId = task.getPublisherId();
        return taskService.selectUncompletedTask(publisherId);
    }

    @RequestMapping(value = "/getUncompletedTasks2")
    @ResponseBody
    public List<Task> getUncompletedTasksByPublisherId2(@RequestParam("publisherId") Integer publisherId) {
        return taskService.selectUncompletedTask(publisherId);
    }

    // http://localhost:8080/task/getCompletedTasks?publisherId=1
    @RequestMapping(value = "/getCompletedTasks")
    @ResponseBody
    public List<Task> getCompletedTasksByPublisherId(@RequestBody Task task) {
        Integer publisherId = task.getPublisherId();
        return taskService.selectCompletedTask(publisherId);
    }

    @RequestMapping(value = "/getCompletedTasks2")
    @ResponseBody
    public List<Task> getCompletedTasksByPublisherId2(@RequestParam("publisherId") Integer publisherId) {
        return taskService.selectCompletedTask(publisherId);
    }

    // http://localhost:8080/task/searchTaskByTitle?title=
    @RequestMapping(value = "/searchTaskByTitle")
    @ResponseBody
    public List<Task> searchTaskByTitle(@RequestBody Task task) {
        String title = task.getTitle();
        return taskService.selectTaskByTitle(title);
    }

    @RequestMapping(value = "/searchTaskByTitle2")
    @ResponseBody
    public List<Task> searchTaskByTitle2(@RequestParam("title") String title) {
        return taskService.selectTaskByTitle(title);
    }

    // http://localhost:8080/task/searchTaskByCategory?category=
    @RequestMapping(value = "/searchTaskByCategory")
    @ResponseBody
    public List<Task> searchTaskByCategory(@RequestBody Task task) {
        String category = task.getCategory().toString();
        return taskService.selectTaskByCategory(category);
    }

    @RequestMapping(value = "/searchTaskByCategory2")
    @ResponseBody
    public List<Task> searchTaskByCategory2(@RequestParam("category") Integer category) {
        return taskService.selectTaskByCategory(category.toString());
    }

}
