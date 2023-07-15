package com.young.blog.Blog.repository;

import com.young.blog.Blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BlogRepository extends JpaRepository<Blog, Long> {
}