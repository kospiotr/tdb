/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/support/PageResponse.java.p.vm
 */
package pl.xperios.tdb.dto.support;

import java.util.List;

public class PageResponse<T> {

    public final int totalPages;
    public final long totalElements;
    public final List<T> content;

    public PageResponse(int totalPages, long totalElements, List<T> content) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.content = content;
    }
}
