package interlink.todolist.dao;

import interlink.todolist.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class TaskDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Task> getAllTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        return (List<Task>) criteria.list();
    }

    public void addNewTask(String title, String details, int listId, String currentDay,String startTime) {
        Task task = new Task(listId, title, details, Boolean.FALSE, startTime, currentDay);
        sessionFactory.getCurrentSession().save(task);
    }

    public void deleteTask(String taskId) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        sessionFactory.getCurrentSession().delete(task);
    }

    public void switchStatusTask(String taskId) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        task.setView(!task.getView());
        sessionFactory.getCurrentSession().update(task);
    }

    public Task getTaskById(String taskId) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId)))
                .uniqueResult();
        task.getTasksList().getList_name();
        return task;
    }

    public void updateTask(String taskId, String title, String details, String startTime, String endTime,String listId) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(eq("id", parseInt(taskId))).uniqueResult();
        task.setTitle(title);
        task.setDetails(details);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
        task.setListId(parseInt(listId));
        sessionFactory.getCurrentSession().update(task);
    }
}
