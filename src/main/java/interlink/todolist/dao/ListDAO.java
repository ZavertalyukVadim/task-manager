package interlink.todolist.dao;

import interlink.todolist.model.TasksList;
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
public class ListDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<TasksList> getAllListTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(TasksList.class);
//        criteria.setFetchMode("tasks",FetchMode.LAZY);
        List<TasksList> listTasks = (List<TasksList>) criteria.list();
        for (TasksList tasksList: listTasks) {
            tasksList.getList_name();
            tasksList.getTasks().forEach(Task::getDetails);
        }
        return listTasks;
    }

    public List<TasksList> getAllLists() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(TasksList.class);
        return (List<TasksList>) criteria.list();
    }

    public void addNewList(String name) {
        TasksList tasksList = new TasksList(name);
        sessionFactory.getCurrentSession().save(tasksList);
    }

    public void delete(String id) {
        TasksList task = (TasksList) sessionFactory.getCurrentSession().createCriteria(TasksList.class)
                .add(eq("id", parseInt(id))).uniqueResult();
        sessionFactory.getCurrentSession().delete(task);
    }

    public void updateList(String id, String name) {
        TasksList tasksList = (TasksList) sessionFactory.getCurrentSession().createCriteria(TasksList.class)
                .add(eq("id", parseInt(id))).uniqueResult();
        tasksList.setList_name(name);
        sessionFactory.getCurrentSession().update(tasksList);
    }

    public TasksList getListById(String id) {
        return (TasksList) sessionFactory.getCurrentSession().createCriteria(TasksList.class)
                .add(eq("id", parseInt(id)))
                .uniqueResult();
    }
}
