package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    @Autowired
    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody Map<String, Object> requestBody) {
        String title = requestBody.get("title").toString();
        String content = requestBody.get("content").toString();

        String postContent = "Title: " + title + "\nContent: " + content;

        postServiceImpl.addPost(postContent);

        return new ResponseEntity<>(postContent, HttpStatus.OK);
    }
}
