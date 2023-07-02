package App.service;

import App.dao.repository.OrganizationRepository;
import App.model.dto.OrganizationResp;
import App.model.dto.OrganizationRq;

import java.util.List;

public interface OrganizationService {
    OrganizationResp save(OrganizationRq rq);
    OrganizationResp get(Long id);
    List<OrganizationResp> getAll();
    OrganizationResp update(Long id, OrganizationRq rq);
    void delete(Long id);

}
