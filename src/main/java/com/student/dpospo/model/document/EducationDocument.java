package com.student.dpospo.model.document;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "education_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class EducationDocument extends AbstractBaseDocument {

    @Column(name = "registration_number", nullable = false)
    @NotNull
    private Integer registrationNumber;
}
