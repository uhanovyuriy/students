package com.student.dpospo.repository;

import com.student.dpospo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCrudRepository extends JpaRepository<Student, Integer> {
}
