package com.student.dpospo.repository;

import com.student.dpospo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface StudentCrudRepository extends JpaRepository<Student, Integer> {

    @RestResource(rel = "by-email", path = "by-email")
    @Query("SELECT s FROM Student s WHERE s.email = LOWER(:email)")
    Optional<Student> findByEmailIgnoreCase(String email);

    @RestResource(rel = "by_lastName", path = "by_lastName")
    Optional<Student> findAllByLastName(String lastName);
}
