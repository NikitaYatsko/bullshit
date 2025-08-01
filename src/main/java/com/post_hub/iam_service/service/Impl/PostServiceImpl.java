package com.post_hub.iam_service.service.Impl;

import com.post_hub.iam_service.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final List<String> posts = new ArrayList<>();

    @Override
    public void addPost(String postContent) {
        posts.add(postContent);
    }
}
