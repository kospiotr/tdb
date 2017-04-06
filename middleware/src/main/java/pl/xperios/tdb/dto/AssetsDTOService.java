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

import pl.xperios.tdb.domain.Assets;
import pl.xperios.tdb.domain.Assets_;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.AssetsRepository;

/**
 * A simple DTO Facility for Assets.
 */
@Service
public class AssetsDTOService {

    @Inject
    private AssetsRepository assetsRepository;

    @Transactional(readOnly = true)
    public AssetsDTO findOne(Integer id) {
        return toDTO(assetsRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<AssetsDTO> complete(String query, int maxResults) {
        List<Assets> results = assetsRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<AssetsDTO> findAll(PageRequestByExample<AssetsDTO> req) {
        Example<Assets> example = null;
        Assets assets = toEntity(req.example);

        if (assets != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Assets_.type.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Assets_.name.getName(), match -> match.ignoreCase().startsWith())
                    .withMatcher(Assets_.realname.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(assets, matcher);
        }

        Page<Assets> page;
        if (example != null) {
            page = assetsRepository.findAll(example, req.toPageable());
        } else {
            page = assetsRepository.findAll(req.toPageable());
        }

        List<AssetsDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public AssetsDTO save(AssetsDTO dto) {
        if (dto == null) {
            return null;
        }

        final Assets assets;

        if (dto.isIdSet()) {
            Assets assetsTmp = assetsRepository.findOne(dto.id);
            if (assetsTmp != null) {
                assets = assetsTmp;
            } else {
                assets = new Assets();
                assets.setId(dto.id);
            }
        } else {
            assets = new Assets();
        }

        assets.setRelatedid(dto.relatedid);
        assets.setType(dto.type);
        assets.setName(dto.name);
        assets.setRealname(dto.realname);

        return toDTO(assetsRepository.save(assets));
    }

    /**
     * Converts the passed assets to a DTO.
     */
    public AssetsDTO toDTO(Assets assets) {
        return toDTO(assets, 1);
    }

    /**
     * Converts the passed assets to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param assets
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public AssetsDTO toDTO(Assets assets, int depth) {
        if (assets == null) {
            return null;
        }

        AssetsDTO dto = new AssetsDTO();

        dto.id = assets.getId();
        dto.relatedid = assets.getRelatedid();
        dto.type = assets.getType();
        dto.name = assets.getName();
        dto.realname = assets.getRealname();
        if (depth-- > 0) {
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Assets.
     * Convenient for query by example.
     */
    public Assets toEntity(AssetsDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Assets.
     * Convenient for query by example.
     */
    public Assets toEntity(AssetsDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Assets assets = new Assets();

        assets.setId(dto.id);
        assets.setRelatedid(dto.relatedid);
        assets.setType(dto.type);
        assets.setName(dto.name);
        assets.setRealname(dto.realname);
        if (depth-- > 0) {
        }

        return assets;
    }
}