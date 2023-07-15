package com.young.blog.blog.repository;

import com.young.blog.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BlogRepository extends JpaRepository<Blog, Long> {
}