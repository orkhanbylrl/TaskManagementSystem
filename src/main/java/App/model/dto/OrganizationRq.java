package App.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationRq {
    private String name;
}
