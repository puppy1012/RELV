package com.example.demo.controller;

import com.example.demo.controller.request.FindPostRequest;
import com.example.demo.controller.request.PostRequest;
import com.example.demo.controller.request.UpdatePostRequest;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// 각종 디버깅 및 로그를 확인하기 위한 목적으로 사용합니다.
// 이 내용이 추가된 이후 `log.info()` 형태로 내용을 확인 할 수 있습니다.
@Slf4j
// RestController의 경우
// `Controller` 게열이 붙어 있지 않으면
// 웹 브라우저 상에서 요청을 처리할 수 없습니다.
// `Controller`가 붙어 있는 클래스의 `모든 함수` 의 리턴값은
// 전부 자동으로 `JSON` 처리가 되어 반환됩니다.
// `JSON` 이란 것은 보편적으로 `key` 와 `value` 로 구성됩니다.
// `문자열의 경우 한정적으로 단일로 나갈 수 있음`
// `사물함의 열쇠` 가 `key` 라고 생각하고
// `사물함에 들어 있는 내용` 을 `value` 라고 생각하면 좋습니다.

// 이 내용은 교재 13 페이지에서 언급이 되고 있습니다.
// @Component 라는 이야기가 나오고 있습니다.
// @Component는 `Spring에서 관리하는 Bean 객체` 입니다.
// `Bean 객체` 는 `Spring 서버가 구동하면서 만들어 놓는 싱글톤(Singleton)` 입니다.
// `싱글톤(Singleton)`은 `유일한 인스턴스` 라는 의미를 가집니다.

// `인스턴스` 와 `객체` 의 차이점이 무엇인가?
// `인스턴스` 의 경우 `특정 class가 객체화`
// `객체` 는 `컴퓨터가 사용하는 메모리에 올라갔다` 라는 의미를 가집니다.
// 즉 `싱글톤` 은 `특정 class의 정보가 메모리에 올라가는데 유일하다는 소리`
// 결론적으로 `Bean 객체` 는 아래와 같이 적을 수 있습니다.
// `Spring 서버가 구동하면서 만들어 놓는 특정 class의 정보 (근데 유일함)`
@RestController
public class PostController {

    // @Autowired의 경우 JpaRepository는 무조건 Bean이 되는데
    // Bean에 해당하는 정보를 변수 이름인 postRepository로 사용하겠다는 뜻입니다.
    @Autowired
    private PostRepository postRepository;

    // http://localhost:8080/test <- 브라우저 요청
    // HTTP(웹) 방식으로
    // `x시 y구 z동` 으로 가서
    // `k아파트 i동 j호` 로 이동하세요.
    // `들어가서 /test 라는 방으로 가세요`
    // `localhost` 를 `우리 동네` 로 생각해도 됩니다.
    // 또한 `내 컴퓨터` 로 생각해도 무방합니다.

    // `http://localhost:8080/test` 를 브라우저에서 입력 했는데
    // 브라우저에서는 `localhost:8080/test` 로 보이는 이유가
    // 무엇인가 라는 의문이 들 수 있어서 정리해 두겠습니다.
    // 브라우저는 `HTTP 프로토콜` 로 동작하기 때문에
    // 앞에 `http://` 를 표기하지 않고 `localhost:8080/test` 만 표기하는 것입니다.
    // 그래서 단순히 `localhost:8080/test` 만 표현을 해도 결과가 나타나는 것을 볼 수 있습니다.

    // GetMapping의 경우 웹 브라우저에서 GET 요청을 수신하는 목적으로 사용합니다.
    // GET 요청을 수신한다는 것은 아래 사항을 의미합니다.

    // 1. 여러분들이 웹 브라우저에 위의 `http://localhost:8080/test` 를 입력합니다.
    // 2. `http://localhost:8080` 을 의미하는 것이 현재 우리가 구동시킨 `Spring 서버` 입니다.
    //    `Spring 서버` 에서 `/test` 로 맵핑된 것이 있는지 찾습니다.
    // 3. 이후 `/test` 에 해당하는 매서드를 구동시켜줍니다.
    // 4. 매서드를 구동하면서 `여러분들이 작성한 코드` 를 진행하게 됩니다.
    // 5. 그리고 `여러분들이 return` 한 내용이 브라우저 화면에 출력됩니다.
    @GetMapping("/test")
    public String test() {
        // 만약 여러분들이 브라우저 상에서 Hello를 보고 싶다면
        // 아래 `return "test";` 를
        // `return "Hello";` 로 바꾸면 됩니다.
        // return "test";
        return "안녕 스프링이야";

        // 내용을 바꿧고 브라우저에 요청을 했는데
        // 전혀 내용이 업데이트 되지 않을 수 있습니다.
        // 당황할 필요 없이 껏다가 다시 켜주시면 됩니다.
    }

    // `http://localhost:8080/post` 로 테스트가 가능합니다.
    // 이번에 우리는 new Post()를 통해 새롭게 생성한
    // Post 객체가 리턴되는 것을 기대해 볼 수 있습니다.
    // 내부의 내용은 "제목", "내용" 에 해당합니다.
    @GetMapping("/post")
    public Post returnPost() {
        // Post 객체가 "제목", "내용" 으로 만들어집니다.
        // 그 만들어진 객체의 이름이 createdPost 입니다.
        // createdPost가 "제목" 과 "내용" 정보를 가지고 있다는 뜻입니다.
        Post createdPost = new Post("제목", "내용");
        // 위와 같이 만들어진 정보를 리턴하게 됩니다.
        // 잘 보면 createdPost의 데이터 타입이 Post 입니다.
        // 그렇기 때문에 `returnPost()` 매서드의
        // 리턴 타입이 `Post` 인 것도 확인할 수 있습니다.
        return createdPost;
        // 출력 결과는 아래와 같이 나옵니다.
        // {"title":"제목","content":"내용"}
        
        // "title" 이라는 key 값에 대응하는 "제목" 이라는 value 값
        // "content" 라는 key 값에 대응하는 "내용" 이라는 value 값
        // 위의 형식이 JSON 형태라는 것입니다.
    }

    // @PostMapping은 POST 방식이라고 해서 JSON 형태로 데이터를 처리
    // 그렇기 때문에 URL에 정보 노출이 안된다는 이점이 있음
    // 웹 브라우저로는 Post 요청을 할 방법이 없기 때문에 postman을 사용합니다.
    // @RequestBody를 통해 JSON 형태의 입력 (파라미터) 을 수신
    @PostMapping("/create")
    public Post createPost(@RequestBody PostRequest request) {
        /*
        postman에서 그냥 http://localhost:8080/create 으로 요청을 보내니 아래와 같은 에러가 발생합니다.

        {
            "timestamp": "2025-07-04T01:25:06.175+00:00",
            "status": 400,
            "error": "Bad Request",
            "path": "/create"
        }

        status: 400은 @RequestBody의 입력 데이터가 잘못 들어간 상태임을 의미합니다.
        그래서 postman의 body를 raw, JSON으로 설정하고 아래 내용을 추가해서 보냅니다.

        {
            "title": "안녕",
            "content": "내용"
        }

        그리고 응답이 아래와 같이 나옵니다.

        {
            "id": null,
            "title": null,
            "content": null
        }

        전부 비어버린 이유는 request가 null 처리되었기 때문입니다.
         */

        // 중괄호 '{}' 내부에 `request` 정보가 배치됩니다.
        // 왜 Getter와 Setter를 추가하자마자 request 정보가 나왔을까?
        // Spring이 내부적으로 JSON 형태로 들어온 정보를 해석해서 먼저 생성자를 만듭니다.
        // 그리고 title 정보와 content 정보가 있을 것인데
        // 직접 생성자가 만든 객체에 set 을 사용해서 정보들을 배치해주기 때문입니다.
        log.info("post create -> request: {}", request);

        // Post requestedPost = request.toPost();
        // return requestedPost;

        Post requestedPost = request.toPost();
        return postRepository.save(requestedPost);
    }

    @PostMapping("/post/find")
    public Post findPost(@RequestBody FindPostRequest request) {
        log.info("post find -> request: {}", request);

        Long id = request.getPostId();
        Optional<Post> maybePost = postRepository.findById(id);

        if (maybePost.isEmpty()) {
            return null;
        }

        return maybePost.get();
    }

    // GetMapping 내부에 `{id}` 형태로 표기된 것이 존재합니다.
    // @PathVariable 의 경우 가변 인자에 해당합니다.
    // id 값이 562번, 788번, 128722번
    // 사전에 미리 번호를 알 수 없기 때문에 이러한 가변 처리가 필요합니다.
    @GetMapping("/post/read/{id}")
    public Post readPost(@PathVariable Long id) {
        // @PathVariable 이 위의 `{id}` 형태로 만들어진 가변 정보를 실제 특정 데이터 타입(Long)으로 바꿉니다.
        // 현재 케이스에서 id는 Long이 되었습니다.
        log.info("post read -> id: {}", id);
        Optional<Post> maybePost = postRepository.findById(id);

        if (maybePost.isEmpty()) {
            return null;
        }

        return maybePost.get();
    }

    @GetMapping("/post/list")
    public List<Post> readPostList() {
        return postRepository.findAll();
    }

    @GetMapping("/post/delete")
    public void deletePost(@RequestParam Long id) {
        log.info("post delete -> id: {}", id);

        postRepository.deleteById(id);
    }

    @PostMapping("/post/update")
    public Post updatePost(@RequestBody UpdatePostRequest request) {
        log.info("post update -> request: {}", request);

        Long postId = request.getPostId();
        Optional<Post> maybePost = postRepository.findById(postId);

        if (maybePost.isEmpty()) {
            return null;
        }

        Post foundPost = maybePost.get();
        foundPost.setTitle(request.getTitle());
        foundPost.setContent(request.getContent());

        return postRepository.save(foundPost);
    }
}
