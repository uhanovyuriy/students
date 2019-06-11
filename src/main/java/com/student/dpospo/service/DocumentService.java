package com.student.dpospo.service;

import org.springframework.core.io.Resource;

public interface DocumentService {

    Resource createDocument(Integer studentId, String nameCreatedDocument);
}
