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

import pl.xperios.tdb.domain.Newsletters;
import pl.xperios.tdb.domain.Newsletters_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.NewslettersRepository;

/**
 * A simple DTO Facility for Newsletters.
 */
@Service
public class NewslettersDTOService {

    @Inject
    private NewslettersRepository newslettersRepository;

    @Transactional(readOnly = true)
    public NewslettersDTO findOne(String id) {
        return toDTO(newslettersRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<NewslettersDTO> complete(String query, int maxResults) {
        List<Newsletters> results = newslettersRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<NewslettersDTO> findAll(PageRequestByExample<NewslettersDTO> req) {
        Example<Newsletters> example = null;
        Newsletters newsletters = toEntity(req.example);

        if (newsletters != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Newsletters_.id.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(newsletters, matcher);
        }

        Page<Newsletters> page;
        if (example != null) {
            page = newslettersRepository.findAll(example, req.toPageable());
        } else {
            page = newslettersRepository.findAll(req.toPageable());
        }

        List<NewslettersDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public NewslettersDTO save(NewslettersDTO dto) {
        if (dto == null) {
            return null;
        }

        final Newsletters newsletters;

        if (dto.isIdSet()) {
            Newsletters newslettersTmp = newslettersRepository.findOne(dto.id);
            if (newslettersTmp != null) {
                newsletters = newslettersTmp;
            } else {
                newsletters = new Newsletters();
                newsletters.setId(dto.id);
            }
        } else {
            newsletters = new Newsletters();
        }

        newsletters.setTechnologies(dto.technologies);
        newsletters.setProjects(dto.projects);
        newsletters.setMessages(dto.messages);
        newsletters.setAdmin(dto.admin);

        return toDTO(newslettersRepository.save(newsletters));
    }

    /**
     * Converts the passed newsletters to a DTO.
     */
    public NewslettersDTO toDTO(Newsletters newsletters) {
        return toDTO(newsletters, 1);
    }

    /**
     * Converts the passed newsletters to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param newsletters
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public NewslettersDTO toDTO(Newsletters newsletters, int depth) {
        if (newsletters == null) {
            return null;
        }

        NewslettersDTO dto = new NewslettersDTO();

        dto.id = newsletters.getId();
        dto.technologies = newsletters.getTechnologies();
        dto.projects = newsletters.getProjects();
        dto.messages = newsletters.getMessages();
        dto.admin = newsletters.getAdmin();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Newsletters.
     * Convenient for query by example.
     */
    public Newsletters toEntity(NewslettersDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Newsletters.
     * Convenient for query by example.
     */
    public Newsletters toEntity(NewslettersDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Newsletters newsletters = new Newsletters();

        newsletters.setId(dto.id);
        newsletters.setTechnologies(dto.technologies);
        newsletters.setProjects(dto.projects);
        newsletters.setMessages(dto.messages);
        newsletters.setAdmin(dto.admin);
        if (depth-- > 0) {
        }

        return newsletters;
    }
}