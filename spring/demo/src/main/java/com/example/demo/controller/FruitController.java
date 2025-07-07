package com.example.demo.controller;

import com.example.demo.controller.request.FruitRequest;
import com.example.demo.controller.request.UpdateFruitRequest;
import com.example.demo.entity.Fruit;
import com.example.demo.controller.request.CreateFruitRequest;
import com.example.demo.controller.request.FindFruitNameRequest;
import com.example.demo.repository.FruitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController

@RequestMapping("/Fruit")
public class FruitController {
    @Autowired
    private FruitRepository fruitRepository;

    //create
    @GetMapping("/create")
    public Fruit createFruit(@RequestBody FruitRequest fruitRequest) {
        log.info("FruitController.getFruit(): {}", fruitRequest);
        Fruit requestPost= fruitRequest.toFruit();
        return fruitRepository.save(requestPost);
    }
    //update
    @PostMapping("/update")
    public Fruit updateFruit(@RequestBody UpdateFruitRequest updateFruitRequest) {
        log.info("FruitController.updateFruit(): {}", updateFruitRequest);
        Long postId= updateFruitRequest.getPostId();
        Optional<Fruit> fruitPost= fruitRepository.findById(postId);
        if(fruitPost.isEmpty()){
            return null;
        }
        Fruit requestPost= fruitPost.get();
        requestPost.setName(updateFruitRequest.getName());
        requestPost.setPrice(updateFruitRequest.getPrice());
        return fruitRepository.save(requestPost);
    }

    //delete
    @GetMapping("/delete")
    public void deleteFruit(@RequestParam Long postId) {
        log.info("FruitController.deleteFruit(): {}", postId);
        fruitRepository.deleteById(postId);
    }
    //list
    @GetMapping("/list")
    public List<Fruit> getFruits() {
        return fruitRepository.findAll();
    }

    //list/{id}
    @PostMapping("/list/{id}")
    public Fruit getFruits(@PathVariable Long id) {
        log.info("FruitController.getFruits(): {}", id);
        Optional<Fruit> fruitPost= fruitRepository.findById(id);
        if(fruitPost.isEmpty()){
            return null;
        }
        return fruitPost.get();

// @RequestMapping("/fruit")
// public class FruitController {

//     @Autowired
//     private FruitRepository fruitRepository;

//     @PostMapping("/create")
//     public Fruit createFruit(@RequestBody CreateFruitRequest request) {
//         log.info("createFruit() -> request: {}", request);

//         Fruit requestedFruit = request.toFruit();
//         return fruitRepository.save(requestedFruit);
//     }

//     @PostMapping("/find")
//     public Fruit findFruitName(@RequestBody FindFruitNameRequest request) {
//         log.info("findFruitName() -> request: {}", request);

//         String fruitName = request.getFruitName();
//         // 주의 사항이라면 findById와는 다르게
//         // Repository 인터페이스에 매서드 프로토타입은 작성해야함
//         Optional<Fruit> maybeFruit = fruitRepository.findByName(fruitName);

//         if (maybeFruit.isEmpty()) {
//             log.info("그런 과일 안 팔아요.");
//             return null;
//         }

//         return maybeFruit.get();
//     }
// }
