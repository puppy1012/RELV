package com.example.demo.controller.request;

import com.example.demo.entity.Post;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    String title;
    String content;

    public Post toPost() {
        return new Post(title, content);
    }
}
