package App.mapper;

import App.dao.entity.Task;
import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T18:28:49+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task mapToTask(TaskRq taskRq) {
        if ( taskRq == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.title( taskRq.getTitle() );
        task.description( taskRq.getDescription() );
        task.status( taskRq.getStatus() );
        task.expiredAt( taskRq.getExpiredAt() );

        return task.build();
    }

    @Override
    public TaskResp mapToTaskResp(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResp.TaskRespBuilder taskResp = TaskResp.builder();

        taskResp.id( task.getId() );
        taskResp.title( task.getTitle() );
        taskResp.description( task.getDescription() );
        taskResp.status( task.getStatus() );
        taskResp.createdAt( task.getCreatedAt() );
        taskResp.expiredAt( task.getExpiredAt() );
        taskResp.organization( task.getOrganization() );

        return taskResp.build();
    }
}
