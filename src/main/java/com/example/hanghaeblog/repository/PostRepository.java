package com.example.hanghaeblog.repository;

import com.example.hanghaeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
