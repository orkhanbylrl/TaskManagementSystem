package App.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResp {
    private Long id;
    private String fullName;
    private String email;
}
