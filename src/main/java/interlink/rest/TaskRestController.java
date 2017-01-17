package interlink.rest;

import interlink.todolist.model.Task;
import interlink.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task")
    @ResponseBody
    List<Task> getAllLists(){
        return taskService.getTaskById("21");
    }
}