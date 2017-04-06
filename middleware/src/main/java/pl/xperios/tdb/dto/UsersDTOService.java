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

import pl.xperios.tdb.domain.Users;
import pl.xperios.tdb.domain.Users_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.UsersRepository;

/**
 * A simple DTO Facility for Users.
 */
@Service
public class UsersDTOService {

    @Inject
    private UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public UsersDTO findOne(Integer id) {
        return toDTO(usersRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<UsersDTO> complete(String query, int maxResults) {
        List<Users> results = usersRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<UsersDTO> findAll(PageRequestByExample<UsersDTO> req) {
        Example<Users> example = null;
        Users users = toEntity(req.example);

        if (users != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Users_.email.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.password.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.industry.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.address.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.phone.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.nip.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.size.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Users_.uniquestamp.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(users, matcher);
        }

        Page<Users> page;
        if (example != null) {
            page = usersRepository.findAll(example, req.toPageable());
        } else {
            page = usersRepository.findAll(req.toPageable());
        }

        List<UsersDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public UsersDTO save(UsersDTO dto) {
        if (dto == null) {
            return null;
        }

        final Users users;

        if (dto.isIdSet()) {
            Users usersTmp = usersRepository.findOne(dto.id);
            if (usersTmp != null) {
                users = usersTmp;
            } else {
                users = new Users();
                users.setId(dto.id);
            }
        } else {
            users = new Users();
        }

        users.setEmail(dto.email);
        users.setPassword(dto.password);
        users.setIndustry(dto.industry);
        users.setName(dto.name);
        users.setAddress(dto.address);
        users.setPhone(dto.phone);
        users.setNip(dto.nip);
        users.setSize(dto.size);
        users.setConnection(dto.connection);
        users.setValidated(dto.validated);
        users.setActivated(dto.activated);
        users.setUniquestamp(dto.uniquestamp);

        return toDTO(usersRepository.save(users));
    }

    /**
     * Converts the passed users to a DTO.
     */
    public UsersDTO toDTO(Users users) {
        return toDTO(users, 1);
    }

    /**
     * Converts the passed users to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param users
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public UsersDTO toDTO(Users users, int depth) {
        if (users == null) {
            return null;
        }

        UsersDTO dto = new UsersDTO();

        dto.id = users.getId();
        dto.email = users.getEmail();
        dto.password = users.getPassword();
        dto.industry = users.getIndustry();
        dto.name = users.getName();
        dto.address = users.getAddress();
        dto.phone = users.getPhone();
        dto.nip = users.getNip();
        dto.size = users.getSize();
        dto.connection = users.getConnection();
        dto.validated = users.getValidated();
        dto.activated = users.getActivated();
        dto.uniquestamp = users.getUniquestamp();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Users.
     * Convenient for query by example.
     */
    public Users toEntity(UsersDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Users.
     * Convenient for query by example.
     */
    public Users toEntity(UsersDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Users users = new Users();

        users.setId(dto.id);
        users.setEmail(dto.email);
        users.setPassword(dto.password);
        users.setIndustry(dto.industry);
        users.setName(dto.name);
        users.setAddress(dto.address);
        users.setPhone(dto.phone);
        users.setNip(dto.nip);
        users.setSize(dto.size);
        users.setConnection(dto.connection);
        users.setValidated(dto.validated);
        users.setActivated(dto.activated);
        users.setUniquestamp(dto.uniquestamp);
        if (depth-- > 0) {
        }

        return users;
    }
}