package com.student.dpospo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.student.dpospo.model.document.EducationDocument;
import com.student.dpospo.model.document.IdentificationDocument;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students", uniqueConstraints = {@UniqueConstraint(columnNames = {"register_id", "last_name"},
        name = "students_unique_register_id_last_name_idx")})
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractPersistable<Integer> {

    @Column(name = "register_id", nullable = false, unique = true)
    @NotNull
    private String registerId;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Column(name = "middle_name", nullable = false)
    @NotNull
    private String middleName;

    @Column(name = "email", nullable = false)
    @NotNull
    @Size(max = 100)
    private String email;

    @Column(name = "tel_number", nullable = false)
    @NotNull
    @Size(max = 16)
    private String telNumber;

    @Column(name = "tel_mobile_number", nullable = false)
    @NotNull
    @Size(max = 16)
    private String telMobileNumber;

    @Column(name = "language", nullable = false)
    @NotBlank
    @Size(max = 10)
    private String language;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Setter(AccessLevel.NONE)
    private final LocalDate registered = LocalDate.now();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<IdentificationDocument> identificationDocuments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<EducationDocument> educationDocuments;
}
