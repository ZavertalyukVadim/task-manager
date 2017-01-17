package interlink.todolist.service;

import interlink.todolist.dao.ListDAO;
import interlink.todolist.model.TasksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    ListDAO dao;

    public List<TasksList> getAllListsWithTasks() {
        List<TasksList> list = dao.getAllListTasks();
        return list;
    }

    public List<TasksList> getAllLists() {
        List<TasksList> list = dao.getAllLists();
        return list;
    }

    public void addNewList(String name) {
        dao.addNewList(name);
    }

    public void deleteList(String id) {
        dao.delete(id);
    }

    public TasksList getListById(String id) {
        TasksList tasksList = dao.getListById(id);
        return tasksList;
    }

    public void updateList(String id, String name) {
        dao.updateList(id,name);
    }
}
