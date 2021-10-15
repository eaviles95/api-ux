package cl.coopeuch.back.controller;

import cl.coopeuch.back.dto.TaskDTO;
import cl.coopeuch.back.exception.InvalidInputException;
import cl.coopeuch.back.model.Task;
import cl.coopeuch.back.service.ITaskService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
@RequestMapping(value = "/task")
@Api(value = "Task controller", produces = "application/json")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping(value = "createTaskDTO")
    public ResponseEntity<TaskDTO> createTaskDTO(@RequestBody TaskDTO taskDTO) {
        try {
            return new ResponseEntity<>(taskService.createTaskDTO(taskDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(Task.class.getSimpleName());
        }
    }

    @DeleteMapping(value = "deleteTask")
    public ResponseEntity<String> deleteTask(@RequestParam("id") int taskId) {
        try {
            return new ResponseEntity<>(taskService.deleteTask(taskId), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(Task.class.getSimpleName());
        }
    }

    @GetMapping(value = "getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        try {
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(Task.class.getSimpleName());
        }
    }

    @PutMapping(value = "updateTask")
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(Task.class.getSimpleName());
        }
    }

}
