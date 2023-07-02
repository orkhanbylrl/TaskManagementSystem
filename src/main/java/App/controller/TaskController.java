package App.controller;

import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import App.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResp saveTask(@Valid @RequestBody TaskRq taskRq) {
        log.info("saveTask controller");
        return taskService.save(taskRq);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResp getTask(@PathVariable Long id) {
        return taskService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResp> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResp> searchTasks(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) LocalDateTime expiredBefore
    ) {
        return taskService.searchTasks(status, title, description, expiredBefore);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResp updateTask(@PathVariable Long id, @Valid @RequestBody TaskRq taskRq) {
        return taskService.update(id, taskRq);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }

}
