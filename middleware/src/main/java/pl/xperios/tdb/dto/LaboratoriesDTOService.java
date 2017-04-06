/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/EntityDTOService.java.e.vm
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

import pl.xperios.tdb.domain.Laboratories;
import pl.xperios.tdb.domain.Laboratories_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.LaboratoriesRepository;

/**
 * A simple DTO Facility for Laboratories.
 */
@Service
public class LaboratoriesDTOService {

    @Inject
    private LaboratoriesRepository laboratoriesRepository;

    @Transactional(readOnly = true)
    public LaboratoriesDTO findOne(Integer id) {
        return toDTO(laboratoriesRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<LaboratoriesDTO> complete(String query, int maxResults) {
        List<Laboratories> results = laboratoriesRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<LaboratoriesDTO> findAll(PageRequestByExample<LaboratoriesDTO> req) {
        Example<Laboratories> example = null;
        Laboratories laboratories = toEntity(req.example);

        if (laboratories != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Laboratories_.departments.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Laboratories_.units.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Laboratories_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Laboratories_.description.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Laboratories_.contact.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Laboratories_.state.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(laboratories, matcher);
        }

        Page<Laboratories> page;
        if (example != null) {
            page = laboratoriesRepository.findAll(example, req.toPageable());
        } else {
            page = laboratoriesRepository.findAll(req.toPageable());
        }

        List<LaboratoriesDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public LaboratoriesDTO save(LaboratoriesDTO dto) {
        if (dto == null) {
            return null;
        }

        final Laboratories laboratories;

        if (dto.isIdSet()) {
            Laboratories laboratoriesTmp = laboratoriesRepository.findOne(dto.id);
            if (laboratoriesTmp != null) {
                laboratories = laboratoriesTmp;
            } else {
                laboratories = new Laboratories();
                laboratories.setId(dto.id);
            }
        } else {
            laboratories = new Laboratories();
        }

        laboratories.setScientistId(dto.scientistId);
        laboratories.setDepartments(dto.departments);
        laboratories.setUnits(dto.units);
        laboratories.setName(dto.name);
        laboratories.setDescription(dto.description);
        laboratories.setContact(dto.contact);
        laboratories.setModificationdate(dto.modificationdate);
        laboratories.setPublished(dto.published);
        laboratories.setState(dto.state);

        return toDTO(laboratoriesRepository.save(laboratories));
    }

    /**
     * Converts the passed laboratories to a DTO.
     */
    public LaboratoriesDTO toDTO(Laboratories laboratories) {
        return toDTO(laboratories, 1);
    }

    /**
     * Converts the passed laboratories to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param laboratories
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public LaboratoriesDTO toDTO(Laboratories laboratories, int depth) {
        if (laboratories == null) {
            return null;
        }

        LaboratoriesDTO dto = new LaboratoriesDTO();

        dto.id = laboratories.getId();
        dto.scientistId = laboratories.getScientistId();
        dto.departments = laboratories.getDepartments();
        dto.units = laboratories.getUnits();
        dto.name = laboratories.getName();
        dto.description = laboratories.getDescription();
        dto.contact = laboratories.getContact();
        dto.modificationdate = laboratories.getModificationdate();
        dto.published = laboratories.getPublished();
        dto.state = laboratories.getState();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Laboratories.
     * Convenient for query by example.
     */
    public Laboratories toEntity(LaboratoriesDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Laboratories.
     * Convenient for query by example.
     */
    public Laboratories toEntity(LaboratoriesDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Laboratories laboratories = new Laboratories();

        laboratories.setId(dto.id);
        laboratories.setScientistId(dto.scientistId);
        laboratories.setDepartments(dto.departments);
        laboratories.setUnits(dto.units);
        laboratories.setName(dto.name);
        laboratories.setDescription(dto.description);
        laboratories.setContact(dto.contact);
        laboratories.setModificationdate(dto.modificationdate);
        laboratories.setPublished(dto.published);
        laboratories.setState(dto.state);
        if (depth-- > 0) {
        }

        return laboratories;
    }
}