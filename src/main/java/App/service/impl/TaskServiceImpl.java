package App.service.impl;

import App.dao.entity.Task;
import App.dao.repository.TaskRepository;
import App.mapper.TaskMapper;
import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import App.model.exception.TaskNotFoundException;
import App.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    @Override
    public TaskResp save(TaskRq taskRq) {
        log.info("saving task");
        Task task = TaskMapper.MAPPER.mapToTask(taskRq);
        return TaskMapper.MAPPER.mapToTaskResp(repo.save(task));
    }

    @Override
    public TaskResp get(Long id) {
        return TaskMapper.MAPPER.mapToTaskResp(repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task is not exist!")));
    }

    @Override
    public List<TaskResp> getAll() {
        return repo.findAll().stream().map(TaskMapper.MAPPER::mapToTaskResp).toList();
    }

    @Override
    public void delete(Long id) {
        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task is not exist!"));
        repo.delete(task);
    }

    @Override
    public TaskResp update(Long id, TaskRq taskRq) {
        Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task is not found!"));
        Task updatedTask = Task.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .expiredAt(task.getExpiredAt())
                .organization(task.getOrganization())
                .build();

        return TaskMapper.MAPPER.mapToTaskResp(repo.save(updatedTask));
    }
}
