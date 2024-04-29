package com.SpeechRecognitionAppBackend.service;

import com.SpeechRecognitionAppBackend.entity.SpeechRequest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.netbeans.lib.cvsclient.response.ErrorResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class SpeechService {

    public ResponseEntity<?> saveSpeech( SpeechRequest request) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Transcripts");
        sheet.setColumnWidth(0, 70 * 256);

        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Spoken Text");

        Row dataRow = sheet.createRow(1);
        Cell dataCell = dataRow.createCell(0);
        dataCell.setCellValue(request.getTranscript());
        System.out.println("workbook "+ workbook.getSheetName(0));
        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            byte[] excelBytes = out.toByteArray();
            workbook.close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "Transcripts.xlsx");
            headers.setContentLength(excelBytes.length);

            ByteArrayResource resource = new ByteArrayResource(excelBytes);
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(excelBytes.length)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse());
        }
    }
}
