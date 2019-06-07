package com.student.dpospo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "education_document")
public class EducationDocument extends AbstractBaseDocument {

    public EducationDocument(Integer id, @NotNull Integer documentId,
                             @NotNull @Size(max = 10) String documentSeries,
                             @NotBlank @Size(min = 3, max = 20) String documentNumber,
                             @NotNull LocalDate dateGiveDocument,
                             @NotBlank String whomGiveDocument,
                             @NotNull String documentPathDisk,
                             @NotNull Integer registrationNumber) {
        super(id, documentId, documentSeries, documentNumber, dateGiveDocument, whomGiveDocument, documentPathDisk);
        this.registrationNumber = registrationNumber;
    }

    @Column(name = "registration_number", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Integer registrationNumber;

    @Override
    public String toString() {
        return "EducationDocument{" +
                "id=" + id +
                ", documentId=" + documentId +
                ", documentSeries='" + documentSeries + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", dateGiveDocument=" + dateGiveDocument +
                ", whomGiveDocument='" + whomGiveDocument + '\'' +
                ", documentPathDisk='" + documentPathDisk + '\'' +
                ", registrationNumber=" + registrationNumber +
                '}';
    }
}
