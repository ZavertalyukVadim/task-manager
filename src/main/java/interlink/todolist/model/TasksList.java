package interlink.todolist.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "list")
public class TasksList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_id;

    @JsonIgnore
    @Cascade(CascadeType.REMOVE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tasksList")
    private List<Task> tasks = new ArrayList();

    @Column(name = "name")
    private String list_name;

    public TasksList() {
    }

    public TasksList(String list_name) {
        this.list_name = list_name;
    }

    public TasksList(Integer list_id, String list_name) {
        this.list_id = list_id;
        this.list_name = list_name;
    }


    public TasksList(Integer list_id, String list_name, List<Task> tasks) {
        this.list_id = list_id;
        this.list_name = list_name;
        this.tasks = tasks;
    }

    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> task) {
        this.tasks = task;
    }


}