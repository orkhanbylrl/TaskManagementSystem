package App.service.impl;

import App.dao.entity.Organization;
import App.dao.repository.OrganizationRepository;
import App.mapper.OrganizationMapper;
import App.model.dto.OrganizationResp;
import App.model.dto.OrganizationRq;
import App.model.exception.OrganizationNotFoundException;
import App.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repo;

    @Override
    public OrganizationResp save(OrganizationRq rq) {
        Organization organization = OrganizationMapper.MAPPER.mapToOrg(rq);
        return OrganizationMapper.MAPPER.mapToOrgResp(repo.save(organization));
    }

    @Override
    public OrganizationResp get(Long id) {
        Organization organization = repo.findById(id).
                orElseThrow(() -> new OrganizationNotFoundException("Organization not found!"));
        return OrganizationMapper.MAPPER.mapToOrgResp(organization);
    }

    @Override
    public List<OrganizationResp> getAll() {
        return repo.findAll().stream().map(OrganizationMapper.MAPPER::mapToOrgResp).toList();
    }

    @Override
    public OrganizationResp update(Long id, OrganizationRq rq) {
        Organization organization = repo.findById(id).
                orElseThrow(() -> new OrganizationNotFoundException("Organization is not found!"));
        Organization updated = Organization.builder()
                .id(organization.getId())
                .name(organization.getName())
                .tasks(organization.getTasks())
                .build();
        return OrganizationMapper.MAPPER.mapToOrgResp(updated);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
