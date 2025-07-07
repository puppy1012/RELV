package com.example.demo.controller;

import com.example.demo.controller.request.SamplePostRequest;
import com.example.demo.controller.request.SampleUpdatePostRequest;
import com.example.demo.controller.request.UpdatePostRequest;
import com.example.demo.entity.SamplePost;
import com.example.demo.repository.SamplePostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class SamplePostController {
    @Autowired
    private SamplePostRepository samplePostRepository;

    @PostMapping("/samplePost/create")
    public SamplePost createSamplePost(@RequestBody SamplePostRequest samplePostRequest) {
        SamplePost samplePost=samplePostRequest.toPost();
        return samplePostRepository.save(samplePost);
    }
    @GetMapping("/samplePost/delete")
    public void deleteSamplePost(@RequestParam Long id) {
        log.info("Delete SamplePost with id:{}",id);
        samplePostRepository.deleteById(id);
    }
    @PostMapping("/samplePost/update")
    public SamplePost updateSamplePost(@RequestBody SampleUpdatePostRequest sampleUpdatePostRequest) {
        log.info("post update -> request:{}",sampleUpdatePostRequest);
        Optional<SamplePost> findPost=samplePostRepository.findById(sampleUpdatePostRequest.getPostId());
        if(findPost.isEmpty()){
            return null;
        }
        SamplePost foundPost=findPost.get();
        foundPost.setTitle(sampleUpdatePostRequest.getTitle());
        foundPost.setContent(sampleUpdatePostRequest.getContent());
        return samplePostRepository.save(foundPost);
    }
    @GetMapping("/samplePost/list")
    public List<SamplePost> getAllSamplePost() {
        return samplePostRepository.findAll();
    }
    @GetMapping("/samplePost/list/{id}")
    public SamplePost getSamplePost(@PathVariable Long id) {
        log.info("get samplePost with id:{}",id);
        Optional<SamplePost> findPost=samplePostRepository.findById(id);
        if(findPost.isEmpty()){
            return null;
        }
        return findPost.get();
    }


}
