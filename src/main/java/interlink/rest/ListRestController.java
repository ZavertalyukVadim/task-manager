package interlink.rest;

import interlink.todolist.model.TasksList;
import interlink.todolist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ListRestController {

    @Autowired
    ListService listService;

    @RequestMapping(value = "/list")
    @ResponseBody
    List<TasksList> getAllLists() {
        return listService.getAllLists();
    }
}
