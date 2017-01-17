package interlink.todolist.controller;


import interlink.todolist.service.ListService;
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
@RequestMapping(value = "/list")
public class ListController {
    @Autowired
    ListService listService;

    //add new list
    @RequestMapping(value = "/newList", method = RequestMethod.GET)
    String addList() throws IOException {
        return "add_list";
    }

    //view descr of task
    @RequestMapping(value = "/{listId}/description", method = RequestMethod.GET)
    String viewList(ModelMap modelMap,
                    @PathVariable("listId") String listId) throws IOException {
        modelMap.addAttribute("list", listService.getListById(listId));
        return "changeList";
    }

    //update task
    @RequestMapping(value = "/{listId}/update", method = RequestMethod.POST)
    String updateTask(@RequestParam("id") String id,
                      @RequestParam("name") String name,
                      HttpServletResponse response,
                      @PathVariable("listId") String listId) throws IOException {
        listService.updateList(id, name);
        return "redirect:/home";
    }

    //create new task
    @RequestMapping(value = "/newList", method = RequestMethod.POST)
    String newList(@RequestParam("name") String name) throws IOException {
        listService.addNewList(name);
        return "redirect:/home";
    }

    //delete list
    @RequestMapping(value = "/{listId}/delete", method = RequestMethod.POST)
    String deleteList(@RequestParam("id") String id,
                      HttpServletResponse response,
                      @PathVariable("listId") String listId) throws IOException {
        listService.deleteList(id);
        return "redirect:/home";
    }
}
