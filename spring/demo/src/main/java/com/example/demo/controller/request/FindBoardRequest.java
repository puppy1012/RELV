package com.example.demo.controller.request;

import com.example.demo.entity.Board;
import lombok.*;

@ToString
@Setter
@Getter
// Getter 사용 시 클래스 내부의 멤버 변수를 아래와 같이 구성해야 합니다.
// Long id -> getId()
// Long boardId -> getBoardId()
@NoArgsConstructor
@AllArgsConstructor
public class FindBoardRequest {
    Long boardId;
}
