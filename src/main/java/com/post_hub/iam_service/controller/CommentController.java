package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.service.CommentService;
import com.post_hub.iam_service.service.Impl.CommentServiceImpl;
import com.post_hub.iam_service.service.Impl.SecondCommenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        commentService.createComment(content);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/createSecond")
    public ResponseEntity<String> switchedToSecondService(@RequestBody Map<String, Object> requestBody) {

        this.commentService = new SecondCommenServiceImpl();
        String content = (String) requestBody.get("content");
        commentService.createComment(content);
        return new ResponseEntity<>("success second", HttpStatus.OK);
    }
}
