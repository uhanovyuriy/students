package com.student.dpospo.repository;

import com.student.dpospo.model.document.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IdentificationDocumentCrudRepository extends JpaRepository<IdentificationDocument, Integer> {
}
