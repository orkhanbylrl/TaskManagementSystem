package App.controller;

import App.model.dto.OrganizationResp;
import App.model.dto.OrganizationRq;
import App.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/org")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResp save(@RequestBody OrganizationRq rq) {
        return service.save(rq);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationResp get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationResp> getAll() {
        return service.getAll();
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationResp update(@PathVariable Long id, @RequestBody OrganizationRq rq) {
        return service.update(id, rq);
    }

    @DeleteMapping("id/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
