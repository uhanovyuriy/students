package com.student.dpospo.model.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public abstract class AbstractBaseDocument extends AbstractPersistable<Integer> implements Document {

//    @Column(name = "student_id", nullable = false)
//    @NotNull
//    @JsonIgnore
//    protected Integer studentId;

    @Column(name = "document_name", nullable = false)
    @NotBlank
    protected String documentName;

    @Column(name = "document_series", nullable = false)
    @NotNull
    @Size(max = 10)
    protected String documentSeries;

    @Column(name = "document_number", nullable = false)
    @NotBlank
    protected String documentNumber;

    @Column(name = "date_give_document", nullable = false)
    @NotNull
    protected LocalDate dateGiveDocument;

    @Column(name = "whom_give_document", nullable = false)
    @NotBlank
    protected String whomGiveDocument;

    @Column(name = "document_path_disk", nullable = false)
    @NotNull
    protected String documentPathDisk;
}
