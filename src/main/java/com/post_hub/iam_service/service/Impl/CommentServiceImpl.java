package com.post_hub.iam_service.service.Impl;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class CommentServiceImpl implements CommentService {

    private final List<String> comments = new ArrayList<>();

    @Override
    public void createComment(String commentContent) {
        comments.add(commentContent);
        System.out.println("Standard Comment Created" + commentContent.toUpperCase());
    }


}
