package App.mapper;

import App.dao.entity.Status;
import App.dao.entity.Task;
import App.model.dto.TaskResp;
import App.model.dto.TaskRq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T14:06:20+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task mapToTask(TaskRq taskRq) {
        if ( taskRq == null ) {
            return null;
        }

        Task task = new Task();

        task.setTitle( taskRq.getTitle() );
        task.setDescription( taskRq.getDescription() );
        if ( taskRq.getStatus() != null ) {
            task.setStatus( Enum.valueOf( Status.class, taskRq.getStatus() ) );
        }
        task.setExpiredAt( taskRq.getExpiredAt() );

        return task;
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
        if ( task.getStatus() != null ) {
            taskResp.status( task.getStatus().name() );
        }
        taskResp.createdAt( task.getCreatedAt() );
        taskResp.expiredAt( task.getExpiredAt() );

        return taskResp.build();
    }
}
