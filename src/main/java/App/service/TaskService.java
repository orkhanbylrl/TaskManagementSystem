package App.service;

import App.model.dto.TaskResp;
import App.model.dto.TaskRq;

import java.util.List;

public interface TaskService {

    TaskResp save(TaskRq taskrq);
    TaskResp get(Long id);
    List<TaskResp> getAll();
    void delete(Long id);
    TaskResp update(Long id, TaskRq taskRq);
}
