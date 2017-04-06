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

import pl.xperios.tdb.domain.Technologies;
import pl.xperios.tdb.domain.Technologies_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.TechnologiesRepository;

/**
 * A simple DTO Facility for Technologies.
 */
@Service
public class TechnologiesDTOService {

    @Inject
    private TechnologiesRepository technologiesRepository;

    @Transactional(readOnly = true)
    public TechnologiesDTO findOne(Integer id) {
        return toDTO(technologiesRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<TechnologiesDTO> complete(String query, int maxResults) {
        List<Technologies> results = technologiesRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<TechnologiesDTO> findAll(PageRequestByExample<TechnologiesDTO> req) {
        Example<Technologies> example = null;
        Technologies technologies = toEntity(req.example);

        if (technologies != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Technologies_.unit.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.department.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.type.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.targets.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.description.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.goodsInnovation.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.goodsConcurency.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.benefits.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.keywords.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.requestnumber.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.requestcountries.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.patentnumber.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.patentcountries.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.scientists.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.state.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Technologies_.info.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(technologies, matcher);
        }

        Page<Technologies> page;
        if (example != null) {
            page = technologiesRepository.findAll(example, req.toPageable());
        } else {
            page = technologiesRepository.findAll(req.toPageable());
        }

        List<TechnologiesDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public TechnologiesDTO save(TechnologiesDTO dto) {
        if (dto == null) {
            return null;
        }

        final Technologies technologies;

        if (dto.isIdSet()) {
            Technologies technologiesTmp = technologiesRepository.findOne(dto.id);
            if (technologiesTmp != null) {
                technologies = technologiesTmp;
            } else {
                technologies = new Technologies();
                technologies.setId(dto.id);
            }
        } else {
            technologies = new Technologies();
        }

        technologies.setUnit(dto.unit);
        technologies.setDepartment(dto.department);
        technologies.setType(dto.type);
        technologies.setName(dto.name);
        technologies.setTargets(dto.targets);
        technologies.setDescription(dto.description);
        technologies.setGoodsInnovation(dto.goodsInnovation);
        technologies.setGoodsConcurency(dto.goodsConcurency);
        technologies.setBenefits(dto.benefits);
        technologies.setKeywords(dto.keywords);
        technologies.setRequestnumber(dto.requestnumber);
        technologies.setRequestdate(dto.requestdate);
        technologies.setRequestcountries(dto.requestcountries);
        technologies.setPatentnumber(dto.patentnumber);
        technologies.setPatentdate(dto.patentdate);
        technologies.setPatentcountries(dto.patentcountries);
        technologies.setScientists(dto.scientists);
        technologies.setModificationdate(dto.modificationdate);
        technologies.setScientistId(dto.scientistId);
        technologies.setPublished(dto.published);
        technologies.setState(dto.state);
        technologies.setInfo(dto.info);

        return toDTO(technologiesRepository.save(technologies));
    }

    /**
     * Converts the passed technologies to a DTO.
     */
    public TechnologiesDTO toDTO(Technologies technologies) {
        return toDTO(technologies, 1);
    }

    /**
     * Converts the passed technologies to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param technologies
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public TechnologiesDTO toDTO(Technologies technologies, int depth) {
        if (technologies == null) {
            return null;
        }

        TechnologiesDTO dto = new TechnologiesDTO();

        dto.id = technologies.getId();
        dto.unit = technologies.getUnit();
        dto.department = technologies.getDepartment();
        dto.type = technologies.getType();
        dto.name = technologies.getName();
        dto.targets = technologies.getTargets();
        dto.description = technologies.getDescription();
        dto.goodsInnovation = technologies.getGoodsInnovation();
        dto.goodsConcurency = technologies.getGoodsConcurency();
        dto.benefits = technologies.getBenefits();
        dto.keywords = technologies.getKeywords();
        dto.requestnumber = technologies.getRequestnumber();
        dto.requestdate = technologies.getRequestdate();
        dto.requestcountries = technologies.getRequestcountries();
        dto.patentnumber = technologies.getPatentnumber();
        dto.patentdate = technologies.getPatentdate();
        dto.patentcountries = technologies.getPatentcountries();
        dto.scientists = technologies.getScientists();
        dto.modificationdate = technologies.getModificationdate();
        dto.scientistId = technologies.getScientistId();
        dto.published = technologies.getPublished();
        dto.state = technologies.getState();
        dto.info = technologies.getInfo();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Technologies.
     * Convenient for query by example.
     */
    public Technologies toEntity(TechnologiesDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Technologies.
     * Convenient for query by example.
     */
    public Technologies toEntity(TechnologiesDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Technologies technologies = new Technologies();

        technologies.setId(dto.id);
        technologies.setUnit(dto.unit);
        technologies.setDepartment(dto.department);
        technologies.setType(dto.type);
        technologies.setName(dto.name);
        technologies.setTargets(dto.targets);
        technologies.setDescription(dto.description);
        technologies.setGoodsInnovation(dto.goodsInnovation);
        technologies.setGoodsConcurency(dto.goodsConcurency);
        technologies.setBenefits(dto.benefits);
        technologies.setKeywords(dto.keywords);
        technologies.setRequestnumber(dto.requestnumber);
        technologies.setRequestdate(dto.requestdate);
        technologies.setRequestcountries(dto.requestcountries);
        technologies.setPatentnumber(dto.patentnumber);
        technologies.setPatentdate(dto.patentdate);
        technologies.setPatentcountries(dto.patentcountries);
        technologies.setScientists(dto.scientists);
        technologies.setModificationdate(dto.modificationdate);
        technologies.setScientistId(dto.scientistId);
        technologies.setPublished(dto.published);
        technologies.setState(dto.state);
        technologies.setInfo(dto.info);
        if (depth-- > 0) {
        }

        return technologies;
    }
}