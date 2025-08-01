package com.post_hub.iam_service.service.Impl;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecondCommenServiceImpl implements CommentService {
    private final List<String> comments = new ArrayList<>();

    @Override
    public void createComment(String commentContent) {
        String advancedComment = LocalDateTime.now().toString() + " " + commentContent.toUpperCase();
        comments.add(commentContent);
        System.out.println(advancedComment);
    }
}
