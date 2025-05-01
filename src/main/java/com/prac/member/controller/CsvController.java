package com.prac.member.controller;

import com.prac.member.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

    @Autowired
    private CsvService csvService;

    // CSV 파일 업로드 엔드포인트
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            // CSV 파일을 DB에 저장하는 서비스 호출
            csvService.saveCsvToDatabase(file);
            return ResponseEntity.ok("CSV 파일이 성공적으로 업로드되었습니다.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("파일 처리 중 오류가 발생했습니다.");
        }
    }
}