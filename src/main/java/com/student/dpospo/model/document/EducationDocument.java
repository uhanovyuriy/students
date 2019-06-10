package com.student.dpospo.model.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.dpospo.model.Student;
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
    private String registrationNumber;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @NotNull
    private Student student;
}
