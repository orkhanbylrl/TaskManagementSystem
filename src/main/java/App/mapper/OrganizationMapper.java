package App.mapper;

import App.dao.entity.Organization;
import App.model.dto.OrganizationResp;
import App.model.dto.OrganizationRq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);
    Organization mapToOrg(OrganizationRq rq);
    OrganizationResp mapToOrgResp(Organization org);
}
