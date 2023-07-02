package App.model.dto;

import App.dao.entity.Organization;
import App.dao.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResp {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private Organization organization;
}
