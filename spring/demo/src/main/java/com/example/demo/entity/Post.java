package com.example.demo.entity;

// 현재 lombok.* 이 import 된 것을 볼 수 있습니다.
// 아래에 있는 모든 내용들이 전부 다 lombok에서 지원하는 내용들이기 때문입니다.
// Getter, Setter, ToString, NoArgsConstructor, AllArgsConstructor 모두 lombok에서 지원합니다.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

// @Entity의 경우 Spring JPA가 자동으로 db 테이블을 생성해줍니다.
@Entity
// Getter의 경우 get으로 시작하는 매서드를 전부 자동화해줍니다.
// 현재 케이스에서는 getTitle() 과 getContent()가 될 것입니다.
@Getter
// Setter의 경우 set으로 시작하는 매서드를 전부 자동화해줍니다.
// setTitle() 과 setContent()가 됩니다.
@Setter
// ToString의 경우 여러분들이 작성한 클래스의 내용을 확인하기 위한 용도로
// 내부에 toString() 매서드를 작성했을 것입니다.
// 클래스 내부의 내용을 출력하기 위한 용도로 사용하며 이를 자동화해줍니다.
@ToString
// NoArgsConstructor의 경우 No Argument (인자 없음) Constructor (생성자) 라고 보면 됩니다.'
// 경우에 따라서 new Post()를 할 수도 있기 때문에 구성하는 부분이라 보면 됩니다.
@NoArgsConstructor
// AllArgsConstructor의 경우 All Argument (모든 인자) Constructor (생성자) 입니다.
// new Post("제목", "내용") 와 같은 형태로 Post 인스턴스(객체)를 생성하기 위해 사용하는 부분입니다.
@AllArgsConstructor
public class Post {
    // Long id에 해당하는 필드가 unique 및 pk가 되도록 구성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;

    /*
    C:\proj\academy\RELV\spring\demo\src\main\java\com\example\demo\controller\PostController.java:78: error: no suitable constructor found for Post(String,String)
        Post createdPost = new Post("제목", "내용");
                           ^
    constructor Post.Post() is not applicable
      (actual and formal argument lists differ in length)
    constructor Post.Post(Long,String,String) is not applicable
      (actual and formal argument lists differ in length)

      위와 같은 에러가 발생할 수 있기 때문에 별도의 생성자를 작성해야 합니다.
      Alt + Insert로 생성자를 자동화합시다.
     */

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
