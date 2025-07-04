package com.example.demo.controller;

import com.example.demo.controller.request.BoardRequest;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/test")
    public Board justCreateBoard(@RequestBody BoardRequest request) {
        // return new Board("title", "content");
        Board requestedBoard = request.toBoard();
        return boardRepository.save(requestedBoard);
    }

    @PostMapping("/board/find")
    public Board findBoard(@RequestBody FindBoardRequest request) {
        Long boardId = request.getId();
        Optional<Board> maybeBoard = boardRepository.findById(boardId);

        if (maybeBoard.isEmpty()) {
            return null;
        }

        return maybeBoard.get();
    }
}
