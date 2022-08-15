package com.example.hanghaeblog.service;

import com.example.hanghaeblog.model.Post;
import com.example.hanghaeblog.dto.PostDto;
import com.example.hanghaeblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다.")
        );
        post.update(postDto);
        return post.getId();
    }


}
