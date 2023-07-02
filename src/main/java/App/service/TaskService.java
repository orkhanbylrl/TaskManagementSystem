package App.service;

import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {

    TaskResp save(TaskRq taskrq);
    TaskResp get(Long id);
    List<TaskResp> getAll();
    void delete(Long id);
    TaskResp update(Long id, TaskRq taskRq);
    List<TaskResp> searchTasks(String status, String title, String description, LocalDateTime expiredBefore);
}
