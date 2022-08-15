package com.example.hanghaeblog.controller;

import com.example.hanghaeblog.domain.Post;
import com.example.hanghaeblog.dto.PostDto;
import com.example.hanghaeblog.repository.PostRepository;
import com.example.hanghaeblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/post")
    public Post createPost(@RequestBody PostDto postDto) {
        Post post = new Post(postDto);
        postRepository.save(post);
        return post;
    }

    @GetMapping("/post")
    public List<Post> getList() {
        return postRepository.findAll();
    }

    @GetMapping("post/{id}")
    public Optional<Post> getPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
        return id;
    }

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

}
