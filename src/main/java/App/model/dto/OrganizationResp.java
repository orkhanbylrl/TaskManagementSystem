package App.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationResp {
    private Long id;
    private String name;
}
