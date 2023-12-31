package App.service.impl;

import App.dao.entity.Organization;
import App.dao.entity.Status;
import App.dao.entity.Task;
import App.dao.repository.OrganizationRepository;
import App.dao.repository.TaskRepository;
import App.mapper.TaskMapper;
import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import App.model.exception.OrganizationNotFoundException;
import App.model.exception.TaskNotFoundException;
import App.service.TaskService;
import App.specification.TaskSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;
    private final OrganizationRepository organizationRepo;

    @Override
    public TaskResp save(TaskRq taskRq) {
        log.info("saving task");
        Long organizationId = taskRq.getOrganizationId();
        Organization organization = organizationRepo.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization is not exist!"));
        Task task = TaskMapper.MAPPER.mapToTask(taskRq);
        task.setOrganization(organization);
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
                .title(taskRq.getTitle())
                .description(taskRq.getDescription())
                .status(taskRq.getStatus())
                .createdAt(task.getCreatedAt())
                .expiredAt(taskRq.getExpiredAt())
                .organization(task.getOrganization())
                .build();


        return TaskMapper.MAPPER.mapToTaskResp(repo.save(updatedTask));
    }

    @Override
    public List<TaskResp> searchTasks(String status, String title, String description, LocalDateTime expiredBefore) {
        Specification<Task> spec = Specification.where(null);

        if (status != null) {
            spec = spec.and(TaskSpecifications.withStatus(Status.valueOf(status.toUpperCase())));
        }

        if (title != null) {
            spec = spec.and(TaskSpecifications.withTitle(title));
        }

        if (description != null) {
            spec = spec.and(TaskSpecifications.withDescription(description));
        }

        if (expiredBefore != null) {
            spec = spec.and(TaskSpecifications.expiredBefore(expiredBefore));
        }

        return repo.findAll(spec).stream().map(TaskMapper.MAPPER::mapToTaskResp).toList();
    }


}
