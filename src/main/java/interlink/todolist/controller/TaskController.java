package interlink.todolist.controller;

import interlink.todolist.service.ListService;
import interlink.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    ListService listService;

    //about task
    @RequestMapping(value = "/{taskId}/description", method = RequestMethod.GET)
    String aboutTask(ModelMap modelMap, @PathVariable("taskId") String taskId) {
        modelMap.addAttribute("task", taskService.getTaskById(taskId));
        return "aboutTask";
    }

    //New Task
    @RequestMapping(value = "/newTask", method = RequestMethod.GET)
    String addTask(ModelMap modelMap) throws IOException {
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "add_task";
    }

    //view description of task
    @RequestMapping(value = "/{taskId}/changeTask", method = RequestMethod.GET)
    String aboutTask(@PathVariable("taskId") String taskId,
                     ModelMap modelMap) throws IOException {
        modelMap.addAttribute("task", taskService.getTaskById(taskId));
        modelMap.addAttribute("ListTasks", listService.getAllLists());
        return "changeTask";
    }

    //delete task
    @RequestMapping(value = "/{taskId}/delete", method = RequestMethod.POST)
    String deleteTask(@RequestParam("id") String id,
                      HttpServletResponse response, @PathVariable("taskId") String taskId) throws IOException {
        taskService.deleteTask(id);
        return "redirect:/home";
    }

    //switch status
    @RequestMapping(value = "/{taskId}/status", method = RequestMethod.POST)
    String switchTask(@RequestParam("id") String id,
                      HttpServletResponse response,
                      @PathVariable("taskId") String taskId) throws IOException {
        taskService.switchView(id);
        return "redirect:/home";
    }


    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    String newTask(@RequestParam("new_task") String title,
                   @RequestParam("new_description") String description,
                   @RequestParam("new_list") Integer listId,
                   @RequestParam("new_startTime") String startTime,
                   @RequestParam("new_currentTime") String currentTime, HttpServletResponse response
    ) throws IOException {
        taskService.addNewTask(title, description, listId, currentTime, startTime);
        return "redirect:/home";
    }

    //changeTask
    @RequestMapping(value = "/{taskId}/changeTask", method = RequestMethod.POST)
    String changeTask(@RequestParam("taskId") String taskId,
                      @RequestParam("title") String title,
                      @RequestParam("details") String details,
                      @RequestParam("startTime") String startTime,
                      @RequestParam("endTime") String endTime,
                      @RequestParam("new_list") String listId,
                      ModelMap modelMap) {
        taskService.updateTask(taskId, title, details, startTime, endTime, listId);
        modelMap.addAttribute("task", taskService.getTaskById(taskId));
        return "redirect:/task/{taskId}/description";
    }

}
