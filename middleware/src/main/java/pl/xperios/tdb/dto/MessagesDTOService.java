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

import pl.xperios.tdb.domain.Messages;
import pl.xperios.tdb.domain.Messages_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.MessagesRepository;

/**
 * A simple DTO Facility for Messages.
 */
@Service
public class MessagesDTOService {

    @Inject
    private MessagesRepository messagesRepository;

    @Transactional(readOnly = true)
    public MessagesDTO findOne(Integer id) {
        return toDTO(messagesRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<MessagesDTO> complete(String query, int maxResults) {
        List<Messages> results = messagesRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<MessagesDTO> findAll(PageRequestByExample<MessagesDTO> req) {
        Example<Messages> example = null;
        Messages messages = toEntity(req.example);

        if (messages != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Messages_.type.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Messages_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Messages_.description.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Messages_.state.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(messages, matcher);
        }

        Page<Messages> page;
        if (example != null) {
            page = messagesRepository.findAll(example, req.toPageable());
        } else {
            page = messagesRepository.findAll(req.toPageable());
        }

        List<MessagesDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public MessagesDTO save(MessagesDTO dto) {
        if (dto == null) {
            return null;
        }

        final Messages messages;

        if (dto.isIdSet()) {
            Messages messagesTmp = messagesRepository.findOne(dto.id);
            if (messagesTmp != null) {
                messages = messagesTmp;
            } else {
                messages = new Messages();
                messages.setId(dto.id);
            }
        } else {
            messages = new Messages();
        }

        messages.setUserId(dto.userId);
        messages.setScientistId(dto.scientistId);
        messages.setType(dto.type);
        messages.setName(dto.name);
        messages.setDescription(dto.description);
        messages.setModificationdate(dto.modificationdate);
        messages.setPublished(dto.published);
        messages.setState(dto.state);

        return toDTO(messagesRepository.save(messages));
    }

    /**
     * Converts the passed messages to a DTO.
     */
    public MessagesDTO toDTO(Messages messages) {
        return toDTO(messages, 1);
    }

    /**
     * Converts the passed messages to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param messages
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public MessagesDTO toDTO(Messages messages, int depth) {
        if (messages == null) {
            return null;
        }

        MessagesDTO dto = new MessagesDTO();

        dto.id = messages.getId();
        dto.userId = messages.getUserId();
        dto.scientistId = messages.getScientistId();
        dto.type = messages.getType();
        dto.name = messages.getName();
        dto.description = messages.getDescription();
        dto.modificationdate = messages.getModificationdate();
        dto.published = messages.getPublished();
        dto.state = messages.getState();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Messages.
     * Convenient for query by example.
     */
    public Messages toEntity(MessagesDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Messages.
     * Convenient for query by example.
     */
    public Messages toEntity(MessagesDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Messages messages = new Messages();

        messages.setId(dto.id);
        messages.setUserId(dto.userId);
        messages.setScientistId(dto.scientistId);
        messages.setType(dto.type);
        messages.setName(dto.name);
        messages.setDescription(dto.description);
        messages.setModificationdate(dto.modificationdate);
        messages.setPublished(dto.published);
        messages.setState(dto.state);
        if (depth-- > 0) {
        }

        return messages;
    }
}