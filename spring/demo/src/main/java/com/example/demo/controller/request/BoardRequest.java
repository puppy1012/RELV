package com.example.demo.controller.request;

import com.example.demo.entity.Board;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    String title;
    String content;

    public Board toBoard() {
        return new Board(title, content);
    }
}
