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
@Table(name = "identification_document")
public class IdentificationDocument extends AbstractBaseDocument {

    public IdentificationDocument(Integer id, @NotNull Integer documentId,
                                  @NotNull @Size(max = 10) String documentSeries,
                                  @NotBlank @Size(min = 3, max = 20) String documentNumber,
                                  @NotNull LocalDate dateGiveDocument,
                                  @NotBlank String whomGiveDocument,
                                  @NotNull String documentPathDisk,
                                  @NotBlank @Size(min = 5, max = 50) String locationBirth,
                                  @NotNull LocalDate dateBirth,
                                  @NotBlank @Size(min = 2, max = 50) String nationality,
                                  @NotBlank @Size(min = 6, max = 7) String numberDivision,
                                  @NotBlank @Size(min = 10, max = 50) String addressRegistration,
                                  @NotBlank @Size(min = 10, max = 50) String residentialAddress) {
        super(id, documentId, documentSeries, documentNumber, dateGiveDocument, whomGiveDocument, documentPathDisk);
        this.locationBirth = locationBirth;
        this.dateBirth = dateBirth;
        this.nationality = nationality;
        this.numberDivision = numberDivision;
        this.addressRegistration = addressRegistration;
        this.residentialAddress = residentialAddress;
    }

    @Column(name = "location_birth", nullable = false)
    @NotBlank
    @Size(min = 5, max = 50)
    @Getter
    @Setter
    private String locationBirth;

    @Column(name = "date_birth", nullable = false)
    @NotNull
    @Getter
    @Setter
    private LocalDate dateBirth;

    @Column(name = "nationality", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    @Getter
    @Setter
    private String nationality;

    @Column(name = "number_division", nullable = false)
    @NotBlank
    @Size(min = 6, max = 7)
    @Getter
    @Setter
    private String numberDivision;

    @Column(name = "address_registration", nullable = false)
    @NotBlank
    @Size(min = 10, max = 50)
    @Getter
    @Setter
    private String addressRegistration;

    @Column(name = "residential_address", nullable = false)
    @NotBlank
    @Size(min = 10, max = 50)
    @Getter
    @Setter
    private String residentialAddress;

    @Override
    public String toString() {
        return "IdentificationDocument{" +
                "id=" + id +
                ", documentId=" + documentId +
                ", documentSeries='" + documentSeries + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", dateGiveDocument=" + dateGiveDocument +
                ", whomGiveDocument='" + whomGiveDocument + '\'' +
                ", documentPathDisk='" + documentPathDisk + '\'' +
                ", locationBirth='" + locationBirth + '\'' +
                ", dateBirth=" + dateBirth +
                ", nationality='" + nationality + '\'' +
                ", numberDivision='" + numberDivision + '\'' +
                ", addressRegistration='" + addressRegistration + '\'' +
                ", residentialAddress='" + residentialAddress + '\'' +
                '}';
    }
}
