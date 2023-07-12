package com.young.blog.repository;

import com.young.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BlogRepository extends JpaRepository<Blog, Long> {
}