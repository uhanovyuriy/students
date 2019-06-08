package com.student.dpospo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class AbstractBaseDocument extends AbstractPersistable<Integer> {

    @Column(name = "student_id", nullable = false)
    @NotNull
    protected Integer studentId;

    @Column(name = "document_series", nullable = false)
    @NotNull
    @Size(max = 10)
    protected String documentSeries;

    @Column(name = "document_number", nullable = false)
    @NotBlank
    @Size(min = 3, max = 20)
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    protected Student student;
}
