/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTOService.java.e.vm
 */
package pl.xperios.tdb.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.xperios.tdb.domain.Services;
import pl.xperios.tdb.domain.Services_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ServicesRepository;

/**
 * A simple DTO Facility for Services.
 */
@Service
public class ServicesDTOService {

    @Inject
    private ServicesRepository servicesRepository;

    @Transactional(readOnly = true)
    public ServicesDTO findOne(Integer id) {
        return toDTO(servicesRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ServicesDTO> complete(String query, int maxResults) {
        List<Services> results = servicesRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<ServicesDTO> findAll(PageRequestByExample<ServicesDTO> req) {
        Example<Services> example = null;
        Services services = toEntity(req.example);

        if (services != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Services_.units.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Services_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Services_.department.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Services_.description.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Services_.contact.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Services_.state.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(services, matcher);
        }

        Page<Services> page;
        if (example != null) {
            page = servicesRepository.findAll(example, req.toPageable());
        } else {
            page = servicesRepository.findAll(req.toPageable());
        }

        List<ServicesDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public ServicesDTO save(ServicesDTO dto) {
        if (dto == null) {
            return null;
        }

        final Services services;

        if (dto.isIdSet()) {
            Services servicesTmp = servicesRepository.findOne(dto.id);
            if (servicesTmp != null) {
                services = servicesTmp;
            } else {
                services = new Services();
                services.setId(dto.id);
            }
        } else {
            services = new Services();
        }

        services.setScientistId(dto.scientistId);
        services.setUnits(dto.units);
        services.setName(dto.name);
        services.setDepartment(dto.department);
        services.setDescription(dto.description);
        services.setContact(dto.contact);
        services.setModificationdate(dto.modificationdate);
        services.setPublished(dto.published);
        services.setState(dto.state);

        return toDTO(servicesRepository.save(services));
    }

    /**
     * Converts the passed services to a DTO.
     */
    public ServicesDTO toDTO(Services services) {
        return toDTO(services, 1);
    }

    /**
     * Converts the passed services to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param services
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public ServicesDTO toDTO(Services services, int depth) {
        if (services == null) {
            return null;
        }

        ServicesDTO dto = new ServicesDTO();

        dto.id = services.getId();
        dto.scientistId = services.getScientistId();
        dto.units = services.getUnits();
        dto.name = services.getName();
        dto.department = services.getDepartment();
        dto.description = services.getDescription();
        dto.contact = services.getContact();
        dto.modificationdate = services.getModificationdate();
        dto.published = services.getPublished();
        dto.state = services.getState();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Services.
     * Convenient for query by example.
     */
    public Services toEntity(ServicesDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Services.
     * Convenient for query by example.
     */
    public Services toEntity(ServicesDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Services services = new Services();

        services.setId(dto.id);
        services.setScientistId(dto.scientistId);
        services.setUnits(dto.units);
        services.setName(dto.name);
        services.setDepartment(dto.department);
        services.setDescription(dto.description);
        services.setContact(dto.contact);
        services.setModificationdate(dto.modificationdate);
        services.setPublished(dto.published);
        services.setState(dto.state);
        if (depth-- > 0) {
        }

        return services;
    }
}