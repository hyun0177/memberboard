package com.prac.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id 자동 생성
    private Long id;

    private String title;
    private String singer;
    private String lyric;
    private String emotion;

    // 기본 생성자
    public SongEntity() {}

    // 생성자
    public SongEntity(Long id, String title, String singer, String lyric, String emotion) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.lyric = lyric;
        this.emotion = emotion;
    }

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }
    public String getEmotion() {
        return emotion;
    }
}
