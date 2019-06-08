package com.student.dpospo.repository;

import com.student.dpospo.model.document.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationDocumentCrudRepository extends JpaRepository<IdentificationDocument, Integer> {
}
