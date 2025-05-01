package com.prac.member.service;

import com.prac.member.entity.SongEntity;
import com.prac.member.repository.SongRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private SongRepository songRepository;

    // CSV 파일을 읽고 DB에 저장하는 메서드
    @Transactional
    public void saveCsvToDatabase(MultipartFile file) throws IOException {
        // CSV 파일을 읽기 위한 BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

        // CSV 파싱 (헤더가 있을 경우 헤더를 무시할 수 있도록 설정)
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        List<SongEntity> songList = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            // CSV 파일에서 각 열의 값을 가져옵니다. (헤더 기준으로 값을 가져옵니다)
            SongEntity song = new SongEntity();
            song.setTitle(csvRecord.get("title"));
            song.setSinger(csvRecord.get("singer"));
            song.setLyric(csvRecord.get("lyric"));
            song.setEmotion(csvRecord.get("emotion"));

            // 리스트에 Song 객체를 추가
            songList.add(song);
        }

        // 데이터를 DB에 저장
        songRepository.saveAll(songList);

        // 리소스 닫기
        csvParser.close();
        reader.close();
    }
}
