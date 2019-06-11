package com.student.dpospo.util.statement;

import com.student.dpospo.model.Student;
import com.student.dpospo.model.document.IdentificationDocument;
import com.student.dpospo.util.exception.IdentificationDocumentNotFoundException;
import lombok.extern.log4j.Log4j;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Log4j
public class ParserTableStatement {

    public static void parseTable(@NotNull IBodyElement element, @NotNull Student student) {
        IdentificationDocument idDoc = getIdentificationDocument(student.getIdentificationDocuments());
        List<XWPFTable> tables = element.getBody().getTables();
        tables.forEach(t -> {
            System.out.println("Total numbers ROWS of the table - " + t.getNumberOfRows());
            t.getRows().forEach(r -> r.getTableCells().forEach(c -> {
                switch (c.getText().trim()) {
                    case "Имя":
                        c.setText(student.getFirstName());
                        break;
                    case "Фамилия":
                        c.setText(student.getLastName());
                        break;
                    case "Отчество":
                        c.setText(student.getMiddleName());
                        break;
                    case "Дата рождения":
                        c.setText(idDoc.getDateBirth().toString());
                        break;
                    case "Место рождения":
                        c.setText(idDoc.getLocationBirth());
                        break;
                    case "Гражданство":
                        c.setText(idDoc.getNationality());
                        break;
                    case "Документ, удостоверяющий личность:":
                        c.setText(idDoc.getDocumentName().equals("passport") ? "Паспорт" : "Свидетельство о рождении");
                        break;
                    case "№":
                        c.setText((idDoc.getDocumentSeries() + " " + idDoc.getDocumentNumber()).trim());
                        break;
                    case "Кем и когда выдан":
                        c.setText(idDoc.getWhomGiveDocument());
                        break;
                }
            }));
        });
    }

    private static IdentificationDocument getIdentificationDocument(List<IdentificationDocument> identificationDocuments) {
        Optional optional = identificationDocuments.stream().
                filter(d -> d.getDocumentName().equals("passport") || d.getDocumentName().equals("birth_sertificate")).findFirst();
        if (optional.isPresent()) {
            return (IdentificationDocument) optional.get();
        } else {
            throw new IdentificationDocumentNotFoundException("Could not found identification document");
        }
    }
}
