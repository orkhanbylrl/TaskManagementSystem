package App.mapper;

import App.dao.entity.Organization;
import App.model.dto.OrganizationResp;
import App.model.dto.OrganizationRq;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-02T15:42:11+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organization mapToOrg(OrganizationRq rq) {
        if ( rq == null ) {
            return null;
        }

        Organization.OrganizationBuilder organization = Organization.builder();

        organization.name( rq.getName() );

        return organization.build();
    }

    @Override
    public OrganizationResp mapToOrgResp(Organization org) {
        if ( org == null ) {
            return null;
        }

        OrganizationResp.OrganizationRespBuilder organizationResp = OrganizationResp.builder();

        organizationResp.id( org.getId() );
        organizationResp.name( org.getName() );

        return organizationResp.build();
    }
}
