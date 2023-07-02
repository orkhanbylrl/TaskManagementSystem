package App.model.dto;

import App.validator.TaskStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskRq {
    private String title;
    private String description;
    @TaskStatus()
    private String status;
    private LocalDateTime expiredAt;
}
