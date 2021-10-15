package cl.coopeuch.back.service;

import cl.coopeuch.back.dto.TaskDTO;
import cl.coopeuch.back.model.Task;

import java.util.List;

public interface ITaskService {

    public TaskDTO createTaskDTO(TaskDTO taskDTO);

    public String deleteTask(Integer taskId);

    public String updateTask(Task task);

    public List<Task> getAllTasks();


}
