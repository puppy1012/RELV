package com.example.demo.controller.request;

import com.example.demo.entity.SamplePost;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SamplePostRequest {
    String title;
    String content;
    String writer;

    public SamplePost toPost() {
        return new SamplePost(title, content,writer);
    }
}
