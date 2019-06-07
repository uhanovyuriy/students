package com.student.dpospo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@ToString
public abstract class AbstractBaseDocument extends AbstractBaseEntity{

    protected AbstractBaseDocument(Integer id, @NotNull Integer documentId,
                                @NotNull @Size(max = 10) String documentSeries,
                                @NotBlank @Size(min = 3, max = 20) String documentNumber,
                                @NotNull LocalDate dateGiveDocument,
                                @NotBlank String whomGiveDocument,
                                @NotNull String documentPathDisk) {
        super(id);
        this.documentId = documentId;
        this.documentSeries = documentSeries;
        this.documentNumber = documentNumber;
        this.dateGiveDocument = dateGiveDocument;
        this.whomGiveDocument = whomGiveDocument;
        this.documentPathDisk = documentPathDisk;
    }

    @Column(name = "document_id", nullable = false)
    @NotNull
    @Getter
    @Setter
    protected Integer documentId;

    @Column(name = "document_series", nullable = false)
    @NotNull
    @Size(max = 10)
    @Getter
    @Setter
    protected String documentSeries;

    @Column(name = "document_number", nullable = false)
    @NotBlank
    @Size(min = 3, max = 20)
    @Getter
    @Setter
    protected String documentNumber;

    @Column(name = "date_give_document", nullable = false)
    @NotNull
    @Getter
    @Setter
    protected LocalDate dateGiveDocument;

    @Column(name = "whom_give_document", nullable = false)
    @NotBlank
    @Getter
    @Setter
    protected String whomGiveDocument;

    @Column(name = "document_path_disk", nullable = false)
    @NotNull
    @Getter
    @Setter
    protected String documentPathDisk;
}
