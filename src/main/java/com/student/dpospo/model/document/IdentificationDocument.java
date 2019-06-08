package com.student.dpospo.model.document;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "identification_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class IdentificationDocument extends AbstractBaseDocument {

    @Column(name = "location_birth", nullable = false)
    @NotBlank
    @Size(min = 5, max = 50)
    private String locationBirth;

    @Column(name = "date_birth", nullable = false)
    @NotNull
    private LocalDate dateBirth;

    @Column(name = "nationality", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String nationality;

    @Column(name = "number_division", nullable = false)
    @NotBlank
    @Size(min = 6, max = 7)
    private String numberDivision;

    @Column(name = "address_registration", nullable = false)
    @NotBlank
    @Size(min = 10, max = 50)
    private String addressRegistration;

    @Column(name = "residential_address", nullable = false)
    @NotBlank
    @Size(min = 10, max = 50)
    private String residentialAddress;
}
