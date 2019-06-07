package com.student.dpospo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students", uniqueConstraints = {@UniqueConstraint(columnNames = "register_id, last_name", name = "users_unique_register_id_last_name_idx")})
public class Student extends AbstractBaseEntity {

    public Student(Integer id, @NotNull Integer registerId,
                   @NotBlank @Size(min = 2, max = 20) String firstName,
                   @NotBlank @Size(min = 2, max = 20) String lastName,
                   @NotNull String middleName,
                   @NotNull @Size(max = 100) String email,
                   @NotNull @Size(max = 16) String telNumber,
                   @NotNull @Size(max = 16) String telMobileNumber,
                   @NotBlank @Size(max = 10) String language,
                   @NotNull LocalDate registered) {
        super(id);
        this.registerId = registerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.telNumber = telNumber;
        this.telMobileNumber = telMobileNumber;
        this.language = language;
        this.registered = registered;
    }

    @Column(name = "register_id", nullable = false, unique = true)
    @NotNull
    @Getter
    @Setter
    private Integer registerId;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    @NotBlank
    @Size(min = 2, max = 20)
    @Getter
    @Setter
    private String lastName;

    @Column(name = "middle_name", nullable = false)
    @NotNull
    @Getter
    @Setter
    private String middleName;

    @Column(name = "email", nullable = false)
    @NotNull
    @Size(max = 100)
    @Getter
    @Setter
    private String email;

    @Column(name = "tel_number", nullable = false)
    @NotNull
    @Size(max = 16)
    @Getter
    @Setter
    private String telNumber;

    @Column(name = "tel_mobile_number", nullable = false)
    @NotNull
    @Size(max = 16)
    @Getter
    @Setter
    private String telMobileNumber;

    @Column(name = "language", nullable = false)
    @NotBlank
    @Size(max = 10)
    @Getter
    @Setter
    private String language;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull
    @Getter
    private LocalDate registered;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "students")
    @Getter
    @Setter
    private List<AbstractBaseDocument> listDocuments;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", registerId=" + registerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", telMobileNumber='" + telMobileNumber + '\'' +
                ", language='" + language + '\'' +
                ", registered=" + registered +
                '}';
    }
}
