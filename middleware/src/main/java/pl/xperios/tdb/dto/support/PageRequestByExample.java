/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/support/PageRequestByExample.java.p.vm
 */
package pl.xperios.tdb.dto.support;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

public class PageRequestByExample<DTO> {
    public DTO example;
    public LazyLoadEvent lazyLoadEvent;

    public Pageable toPageable() {
        return lazyLoadEvent != null ? lazyLoadEvent.toPageable() : null;
    }
}