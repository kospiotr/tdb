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

import pl.xperios.tdb.domain.Research;
import pl.xperios.tdb.domain.Research_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ResearchRepository;

/**
 * A simple DTO Facility for Research.
 */
@Service
public class ResearchDTOService {

    @Inject
    private ResearchRepository researchRepository;

    @Transactional(readOnly = true)
    public ResearchDTO findOne(Integer id) {
        return toDTO(researchRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ResearchDTO> complete(String query, int maxResults) {
        List<Research> results = researchRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<ResearchDTO> findAll(PageRequestByExample<ResearchDTO> req) {
        Example<Research> example = null;
        Research research = toEntity(req.example);

        if (research != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Research_.departments.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.unit.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.type.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.projecttarget.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.description.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.projecttime.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.foundingsources.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.partners.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.results.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.industries.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.keywords.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.benefits.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.injBenefits.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.scientists.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Research_.state.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(research, matcher);
        }

        Page<Research> page;
        if (example != null) {
            page = researchRepository.findAll(example, req.toPageable());
        } else {
            page = researchRepository.findAll(req.toPageable());
        }

        List<ResearchDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public ResearchDTO save(ResearchDTO dto) {
        if (dto == null) {
            return null;
        }

        final Research research;

        if (dto.isIdSet()) {
            Research researchTmp = researchRepository.findOne(dto.id);
            if (researchTmp != null) {
                research = researchTmp;
            } else {
                research = new Research();
                research.setId(dto.id);
            }
        } else {
            research = new Research();
        }

        research.setScientistId(dto.scientistId);
        research.setDepartments(dto.departments);
        research.setUnit(dto.unit);
        research.setName(dto.name);
        research.setType(dto.type);
        research.setProjecttarget(dto.projecttarget);
        research.setDescription(dto.description);
        research.setProjecttime(dto.projecttime);
        research.setCost(dto.cost);
        research.setFoundingsources(dto.foundingsources);
        research.setPartners(dto.partners);
        research.setResults(dto.results);
        research.setIndustries(dto.industries);
        research.setKeywords(dto.keywords);
        research.setBenefits(dto.benefits);
        research.setInjBenefits(dto.injBenefits);
        research.setScientists(dto.scientists);
        research.setModificationdate(dto.modificationdate);
        research.setPublished(dto.published);
        research.setState(dto.state);

        return toDTO(researchRepository.save(research));
    }

    /**
     * Converts the passed research to a DTO.
     */
    public ResearchDTO toDTO(Research research) {
        return toDTO(research, 1);
    }

    /**
     * Converts the passed research to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param research
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public ResearchDTO toDTO(Research research, int depth) {
        if (research == null) {
            return null;
        }

        ResearchDTO dto = new ResearchDTO();

        dto.id = research.getId();
        dto.scientistId = research.getScientistId();
        dto.departments = research.getDepartments();
        dto.unit = research.getUnit();
        dto.name = research.getName();
        dto.type = research.getType();
        dto.projecttarget = research.getProjecttarget();
        dto.description = research.getDescription();
        dto.projecttime = research.getProjecttime();
        dto.cost = research.getCost();
        dto.foundingsources = research.getFoundingsources();
        dto.partners = research.getPartners();
        dto.results = research.getResults();
        dto.industries = research.getIndustries();
        dto.keywords = research.getKeywords();
        dto.benefits = research.getBenefits();
        dto.injBenefits = research.getInjBenefits();
        dto.scientists = research.getScientists();
        dto.modificationdate = research.getModificationdate();
        dto.published = research.getPublished();
        dto.state = research.getState();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Research.
     * Convenient for query by example.
     */
    public Research toEntity(ResearchDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Research.
     * Convenient for query by example.
     */
    public Research toEntity(ResearchDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Research research = new Research();

        research.setId(dto.id);
        research.setScientistId(dto.scientistId);
        research.setDepartments(dto.departments);
        research.setUnit(dto.unit);
        research.setName(dto.name);
        research.setType(dto.type);
        research.setProjecttarget(dto.projecttarget);
        research.setDescription(dto.description);
        research.setProjecttime(dto.projecttime);
        research.setCost(dto.cost);
        research.setFoundingsources(dto.foundingsources);
        research.setPartners(dto.partners);
        research.setResults(dto.results);
        research.setIndustries(dto.industries);
        research.setKeywords(dto.keywords);
        research.setBenefits(dto.benefits);
        research.setInjBenefits(dto.injBenefits);
        research.setScientists(dto.scientists);
        research.setModificationdate(dto.modificationdate);
        research.setPublished(dto.published);
        research.setState(dto.state);
        if (depth-- > 0) {
        }

        return research;
    }
}