package App.mapper;

import App.dao.entity.Task;
import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);
    Task mapToTask(TaskRq taskRq);
    TaskResp mapToTaskResp(Task task);
}
