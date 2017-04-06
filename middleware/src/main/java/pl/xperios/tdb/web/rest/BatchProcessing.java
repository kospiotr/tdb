package pl.xperios.tdb.web.rest;

import lombok.Data;

import java.util.List;

@Data
public class BatchProcessing<MODEL, ID> {

    private List<ID> delete;

}
