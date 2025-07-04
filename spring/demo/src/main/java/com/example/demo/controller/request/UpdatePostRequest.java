package com.example.demo.controller.request;

import com.example.demo.entity.Post;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {
    Long postId;
    String title;
    String content;
}
