package App.model.dto;

import App.dao.entity.Status;
import App.validator.TaskStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskRq {
    private String title;
    private String description;
    @TaskStatus()
    private Status status;
    private LocalDateTime expiredAt;
    @NotNull
    private Long organizationId;
}
