package interlink.todolist.service;

import interlink.todolist.dao.TaskDAO;
import interlink.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskDAO dao;

    public void addNewTask(String title, String details, int listId, String currentDay,String startTime) {
        dao.addNewTask(title, details, listId, currentDay,startTime);
    }

    public void deleteTask(String id){
        dao.deleteTask(id);
    }

    public void switchView(String id) {
        dao.switchStatusTask(id);
    }

    public List<Task> getTaskById(String id) {
        List<Task> list = new ArrayList<>();
        Task task =dao.getTaskById(id);
        list.add(task);
        return list;
    }

    public void updateTask(String taskId, String title, String details, String startTime, String endTime,String listId) {
        dao.updateTask(taskId,title,details,startTime,endTime,listId);
    }
}
