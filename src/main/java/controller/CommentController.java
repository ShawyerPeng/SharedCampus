package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Comment;
import service.CommentService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestBody Comment comment) {
        Integer taskId = comment.getTaskId();
        Integer fromUid = comment.getFromUid();
        Integer toUid = comment.getToUid();
        String content = comment.getContent();
        Integer success = commentService.insertComment(taskId, fromUid, toUid, content);

        if (success == 1) {

        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "评论发送成功");

        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Comment comment) {
        Integer commentId = comment.getCommentId();
        Integer success = commentService.deleteComment(commentId);

        if (success == 1) {

        }
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "评论删除成功");

        return map;
    }

    @RequestMapping("/getAllComments")
    @ResponseBody
    public Map<String, Object> getAllComments(@RequestBody Comment comment) {
        Integer fromUid = comment.getFromUid();
        List<Comment> comments = commentService.getAllComments(fromUid);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "用户评论查询成功");
        data.put("comments", comments);

        return map;
    }

    @RequestMapping("/getTaskComments")
    @ResponseBody
    public Map<String, Object> getTaskComments(@RequestBody Comment comment) {
        Integer taskId = comment.getTaskId();
        List<Comment> comments = commentService.getTaskComments(taskId);

        System.out.println(comments);

        for (Comment c : comments) {
            Integer fromUid = c.getFromUid();
            Integer toUid = c.getToUid();
            if (fromUid != null) {
                c.setFromUsername(userService.getUserByUserId(fromUid).getUserName());
            }
            if (toUid != null) {
                c.setToUsername(userService.getUserByUserId(toUid).getUserName());
            }
        }

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "任务评论查询成功");
        data.put("comments", comments);

        return map;
    }
}
