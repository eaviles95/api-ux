package cl.coopeuch.back.service.impl;

import cl.coopeuch.back.dto.TaskDTO;
import cl.coopeuch.back.exception.EntityNotFoundException;
import cl.coopeuch.back.model.Task;
import cl.coopeuch.back.repository.ITaskRepository;
import cl.coopeuch.back.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO createTaskDTO(TaskDTO taskDTO) {
        log.info("Iniciando método para agregar una tarea");
        ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(taskDTO, Task.class);
        taskRepository.save(task);
        modelMapper = new ModelMapper();
        return modelMapper.map(task, TaskDTO.class);
    }

    public String deleteTask(Integer taskId) {
        log.info("Iniciando método para eliminar una tarea");
        Task task = taskRepository.findById(taskId).orElseThrow(()
                -> new EntityNotFoundException(taskId, Task.class.getSimpleName()));
        taskRepository.delete(task);
        return "Se ha eliminado la tarea";
    }

    public String updateTask(Task task) {
        Task taskAux = taskRepository.findById(task.getId()).orElseThrow(()
                -> new EntityNotFoundException(task.getId(), Task.class.getSimpleName()));
        taskAux.setDescription(task.getDescription());
        taskAux.setCreatedAt(task.getCreatedAt());
        taskAux.setValid(task.getValid());
        taskRepository.save(taskAux);
        return "Se ha actualizado la tarea";
    }

    public List<Task> getAllTasks() {
        log.info("Se traen todas las estrategias existentes");
        return taskRepository.findAll();
    }


}
