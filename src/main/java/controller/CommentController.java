package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TaskService;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UploadController uploadController;


}
