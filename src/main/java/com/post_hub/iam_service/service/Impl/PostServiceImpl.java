package com.post_hub.iam_service.service.Impl;

import com.post_hub.iam_service.mapper.PostMapper;
import com.post_hub.iam_service.model.constants.ApiErrorMessage;
import com.post_hub.iam_service.model.dto.post.PostDTO;
import com.post_hub.iam_service.model.enteties.Post;
import com.post_hub.iam_service.model.exception.NotFoundException;
import com.post_hub.iam_service.model.request.post.PostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repositories.PostRepository;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));
        PostDTO postDTO = postMapper.toPostDTO(post);
        return IamResponse.сreateSuccessful(postDTO);


    }

    @Override
    public IamResponse<PostDTO> createPost(@NotNull PostRequest postRequest) {
        Post post = postMapper.createPost(postRequest);
        Post savedPost = postRepository.save(post);
        PostDTO postDTO = postMapper.toPostDTO(savedPost);
        return IamResponse.сreateSuccessful(postDTO);
    }
}
