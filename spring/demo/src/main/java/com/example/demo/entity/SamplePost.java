package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SamplePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ 이렇게 수정
    Long id;
    String title;
    String writer;      // 첫 생성은 작성자가 존재함, 수정 시 작성자는 변경할 수 없음
    String content;
    //create,update,delete,read,readPostList
    // 생성, 수정, 삭제, 조회, 전체 조회
    public SamplePost(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
