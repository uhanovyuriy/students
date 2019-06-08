package com.student.dpospo.repository;

import com.student.dpospo.model.document.EducationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDocumentCrudRepository extends JpaRepository<EducationDocument, Integer> {
}
