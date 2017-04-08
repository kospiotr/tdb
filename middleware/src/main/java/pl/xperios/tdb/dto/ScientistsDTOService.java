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

import pl.xperios.tdb.domain.Scientists;
import pl.xperios.tdb.domain.Scientists_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ScientistsRepository;

/**
 * A simple DTO Facility for Scientists.
 */
@Service
public class ScientistsDTOService {

    @Inject
    private ScientistsRepository scientistsRepository;

    @Transactional(readOnly = true)
    public ScientistsDTO findOne(Integer id) {
        return toDTO(scientistsRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<ScientistsDTO> complete(String query, int maxResults) {
        List<Scientists> results = scientistsRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<ScientistsDTO> findAll(PageRequestByExample<ScientistsDTO> req) {
        Example<Scientists> example = null;
        Scientists scientists = toEntity(req.example);

        if (scientists != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Scientists_.firstname.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.lastname.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.sciencetitle.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.department.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.phone.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.departmentunit.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.email.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.specializations.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.homepage.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.experience.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.implementations.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.researches.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.grants.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.evaluations.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.publications.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.ownInventions.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.password.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.uniquestamp.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Scientists_.photo.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(scientists, matcher);
        }

        Page<Scientists> page;
        if (example != null) {
            page = scientistsRepository.findAll(example, req.toPageable());
        } else {
            page = scientistsRepository.findAll(req.toPageable());
        }

        List<ScientistsDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public ScientistsDTO save(ScientistsDTO dto) {
        if (dto == null) {
            return null;
        }

        final Scientists scientists;

        if (dto.isIdSet()) {
            Scientists scientistsTmp = scientistsRepository.findOne(dto.id);
            if (scientistsTmp != null) {
                scientists = scientistsTmp;
            } else {
                scientists = new Scientists();
                scientists.setId(dto.id);
            }
        } else {
            scientists = new Scientists();
        }

        scientists.setFirstname(dto.firstname);
        scientists.setLastname(dto.lastname);
        scientists.setSciencetitle(dto.sciencetitle);
        scientists.setDepartment(dto.department);
        scientists.setPhone(dto.phone);
        scientists.setDepartmentunit(dto.departmentunit);
        scientists.setEmail(dto.email);
        scientists.setSpecializations(dto.specializations);
        scientists.setHomepage(dto.homepage);
        scientists.setExperience(dto.experience);
        scientists.setImplementations(dto.implementations);
        scientists.setResearches(dto.researches);
        scientists.setGrants(dto.grants);
        scientists.setEvaluations(dto.evaluations);
        scientists.setPublications(dto.publications);
        scientists.setOwnInventions(dto.ownInventions);
        scientists.setPassword(dto.password);
        scientists.setValidated(dto.validated);
        scientists.setActivated(dto.activated);
        scientists.setUniquestamp(dto.uniquestamp);
        scientists.setAdmin(dto.admin);
        scientists.setPhoto(dto.photo);

        return toDTO(scientistsRepository.save(scientists));
    }

    /**
     * Converts the passed scientists to a DTO.
     */
    public ScientistsDTO toDTO(Scientists scientists) {
        return toDTO(scientists, 1);
    }

    /**
     * Converts the passed scientists to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param scientists
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public ScientistsDTO toDTO(Scientists scientists, int depth) {
        if (scientists == null) {
            return null;
        }

        ScientistsDTO dto = new ScientistsDTO();

        dto.id = scientists.getId();
        dto.firstname = scientists.getFirstname();
        dto.lastname = scientists.getLastname();
        dto.sciencetitle = scientists.getSciencetitle();
        dto.department = scientists.getDepartment();
        dto.phone = scientists.getPhone();
        dto.departmentunit = scientists.getDepartmentunit();
        dto.email = scientists.getEmail();
        dto.specializations = scientists.getSpecializations();
        dto.homepage = scientists.getHomepage();
        dto.experience = scientists.getExperience();
        dto.implementations = scientists.getImplementations();
        dto.researches = scientists.getResearches();
        dto.grants = scientists.getGrants();
        dto.evaluations = scientists.getEvaluations();
        dto.publications = scientists.getPublications();
        dto.ownInventions = scientists.getOwnInventions();
        dto.password = scientists.getPassword();
        dto.validated = scientists.getValidated();
        dto.activated = scientists.getActivated();
        dto.uniquestamp = scientists.getUniquestamp();
        dto.admin = scientists.getAdmin();
        dto.photo = scientists.getPhoto();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Scientists.
     * Convenient for query by example.
     */
    public Scientists toEntity(ScientistsDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Scientists.
     * Convenient for query by example.
     */
    public Scientists toEntity(ScientistsDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Scientists scientists = new Scientists();

        scientists.setId(dto.id);
        scientists.setFirstname(dto.firstname);
        scientists.setLastname(dto.lastname);
        scientists.setSciencetitle(dto.sciencetitle);
        scientists.setDepartment(dto.department);
        scientists.setPhone(dto.phone);
        scientists.setDepartmentunit(dto.departmentunit);
        scientists.setEmail(dto.email);
        scientists.setSpecializations(dto.specializations);
        scientists.setHomepage(dto.homepage);
        scientists.setExperience(dto.experience);
        scientists.setImplementations(dto.implementations);
        scientists.setResearches(dto.researches);
        scientists.setGrants(dto.grants);
        scientists.setEvaluations(dto.evaluations);
        scientists.setPublications(dto.publications);
        scientists.setOwnInventions(dto.ownInventions);
        scientists.setPassword(dto.password);
        scientists.setValidated(dto.validated);
        scientists.setActivated(dto.activated);
        scientists.setUniquestamp(dto.uniquestamp);
        scientists.setAdmin(dto.admin);
        scientists.setPhoto(dto.photo);
        if (depth-- > 0) {
        }

        return scientists;
    }
}