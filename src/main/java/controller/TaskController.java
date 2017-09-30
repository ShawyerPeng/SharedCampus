package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import po.PagedResult;
import po.Task;
import service.TaskService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UploadController uploadController;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insert(@RequestBody Task task) throws Exception {
        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
        return title + " " + description;
    }

    @RequestMapping(value = "/insert2", method = RequestMethod.POST)
    @ResponseBody
    public String insert2(@RequestParam("publisherId") Integer publisherId, @RequestParam("title") String title,
                          @RequestParam("description") String description, @RequestParam("category") Integer category,
                          @RequestParam("price") Double price, @RequestParam("counts") Integer counts,
                          @RequestParam("starttime") Date starttime, @RequestParam("endtime") Date endtime) throws Exception {
        taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
        return "ok";
    }

    @RequestMapping(value = "/insertWithPic", method = RequestMethod.POST)
    @ResponseBody
    public String insertWithPic(@RequestBody Task task) throws Exception {
        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        String pic_url = task.getPic();
        if (pic_url.isEmpty()) {
            taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
        } else {
            taskService.insertTaskWithPic(publisherId, title, description, category, price, counts, starttime, endtime, pic_url);
        }
        return "ok";
    }

    @RequestMapping(value = "/insertWithPic2", method = RequestMethod.POST)
    @ResponseBody
    public String insertWithPic2(@RequestParam("publisherId") Integer publisherId, @RequestParam("title") String title,
                                 @RequestParam("description") String description, @RequestParam("category") Integer category,
                                 @RequestParam("price") Double price, @RequestParam("counts") Integer counts,
                                 @RequestParam("starttime") Date starttime, @RequestParam("endtime") Date endtime,
                                 @RequestParam("pic") MultipartFile pic) throws Exception {
        if (pic.isEmpty()) {
            taskService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
        } else {
            String pic_url = uploadController.upload(pic);
            taskService.insertTaskWithPic(publisherId, title, description, category, price, counts, starttime, endtime, pic_url);
        }
        return "ok";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody Task task) {
        Integer taskId = task.getTaskId();
        Integer publisherId = task.getPublisherId();
        String title = task.getTitle();
        String description = task.getDescription();
        Integer category = task.getCategory();
        Double price = task.getPrice();
        Integer counts = task.getCounts();
        Date starttime = task.getStarttime();
        Date endtime = task.getEndtime();
        taskService.updateTask(taskId, publisherId, title, description, category, price, counts, starttime, endtime);
        return "ok";
    }

    @RequestMapping(value = "/edit2", method = RequestMethod.POST)
    @ResponseBody
    public String edit2(@RequestParam("taskId") Integer taskId,
                        @RequestParam("publisherId") Integer publisherId, @RequestParam("title") String title,
                        @RequestParam("description") String description, @RequestParam("category") Integer category,
                        @RequestParam("price") Double price, @RequestParam("counts") Integer counts,
                        @RequestParam("starttime") Date starttime, @RequestParam("endtime") Date endtime) {
        taskService.updateTask(taskId, publisherId, title, description, category, price, counts, starttime, endtime);
        return "ok";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody Task task) {
        Integer taskId = task.getTaskId();
        taskService.deleteTask(taskId);
        return "ok";
    }

    @RequestMapping(value = "/delete2", method = RequestMethod.POST)
    @ResponseBody
    public String delete2(@RequestParam("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
        return "ok";
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
