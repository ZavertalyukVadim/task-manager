package interlink.todolist.controller;

import interlink.todolist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class StartController {

    @Autowired
    ListService listService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String home(ModelMap modelMap) {
        modelMap.addAttribute("ListTasks", listService.getAllListsWithTasks());
        return "home";
    }
}
