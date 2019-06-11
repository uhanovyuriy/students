package com.student.dpospo.util.statement;

import com.student.dpospo.model.Student;
import lombok.extern.log4j.Log4j;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Log4j
public class ParserStatement {

    @Value("${path-folder-for-parsing-files}")
    private static String pathTempFolder;
    @Value("${path-template-file-for-statement}")
    private static String templateFile;

    public static Path parsing(Student student) {
        String fileNameStatementTemp = student.getRegisterId() + "_statement" + ".docx";
        Path pathTemplate = Paths.get(templateFile);
        try (XWPFDocument xwpfDocument = new XWPFDocument(Files.newInputStream(pathTemplate))) {
            List<IBodyElement> iBodyElements = xwpfDocument.getBodyElements();
//        List<XWPFParagraph> paragraphList = document.getParagraphs();
            for (IBodyElement element : iBodyElements) {
                if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    ParserTableStatement.parseTable(element, student);
                }
            }

            generateMSWordFile(xwpfDocument, fileNameStatementTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (XWPFParagraph p: paragraphList) {
//            countParagraph++;
//            System.out.println("------------------------------" + countParagraph + "--------------------------------");
//            System.out.println(p.getText());
//            List<XWPFRun> xwpfRuns = p.getRuns();
//            int countRun = 0;
//            for (XWPFRun run: xwpfRuns) {
//                countRun++;
//                System.out.println("___________" + countRun + "______________");
//                System.out.println(run.toString());
//            }
//        }

        return pathTemplate;
    }

    private static void generateMSWordFile(XWPFDocument xwpfDocument, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(pathTempFolder + fileName)) {
            xwpfDocument.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
