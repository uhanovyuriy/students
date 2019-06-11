package com.student.dpospo.service;

import com.student.dpospo.model.Student;
import com.student.dpospo.repository.StudentCrudRepository;
import com.student.dpospo.util.exception.NameCreatingDocumentNotFoundException;
import com.student.dpospo.util.exception.StorageFileNotFoundException;
import com.student.dpospo.util.statement.ParserStatement;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private StudentCrudRepository studentRepository;

    @Override
    public Resource createDocument(Integer studentId, String nameCreatingDocument) {
        Path path = null;
        Assert.notNull(studentId, "The given studentId must not be null!");
        Student student = studentRepository.getOne(studentId);
        switch (nameCreatingDocument) {
            case "statement":
                path = ParserStatement.parsing(student);
                break;
            case "inventory":

                break;
            default:
                throw new NameCreatingDocumentNotFoundException("Could not found document name: " + nameCreatingDocument);
        }
        Assert.notNull(path, "The given path must not be null!");
        return getResourceFromPath(path);
    }

    private Resource getResourceFromPath(@NotNull Path path) {
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + path.toString());
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + path.toString(), e);
        }
    }
}
