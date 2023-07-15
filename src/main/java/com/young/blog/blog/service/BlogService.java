package com.young.blog.blog.service;

import com.young.blog.blog.dto.BlogRequestDto;
import com.young.blog.blog.dto.BlogResponseDto;
import com.young.blog.blog.entity.Blog;
import com.young.blog.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor  // 생성자 생성해줌
public class BlogService {
    private final BlogRepository blogRepository;
    public BlogResponseDto save(BlogRequestDto requestDto) {

        Blog newBlog = new Blog(requestDto);

        Blog saveBlog = blogRepository.save(newBlog);
        BlogResponseDto responseDto = new BlogResponseDto(saveBlog);

        return responseDto;
    }

    @Transactional
    public BlogResponseDto update(Long blog_id, BlogRequestDto requestDto) {
        Blog findBlog = blogRepository.findById(blog_id).orElse(null); // 데이터베이스에서 블로그 찾는 것. 찾은 블로그 만들어주는 것


        if(findBlog.getPassword() != requestDto.getPassword()) {
            throw new IllegalArgumentException("wrong password");
        }
        Blog updateBlog = findBlog.update(requestDto);
        BlogResponseDto responseDto = new BlogResponseDto(updateBlog);
        return responseDto;

    }

    public void delete(Long blog_id) {
//        Blog findBlog = blogRepository.findById(blog_id).orElse(null); // 데이터베이스에서 블로그 찾는 것.
//        blogRepository.delete(findBlog);
        blogRepository.deleteById(blog_id);
    }


    public BlogResponseDto getBlog(Long blog_id) {
        Blog findBlog = blogRepository.findById(blog_id).orElse(null); //
        BlogResponseDto responseDto = new BlogResponseDto(findBlog);
        return responseDto;
    }

    // 전체
    public List<BlogResponseDto> getBlogList() {
        List<Blog> foundBlogList = blogRepository.findAll();
        List<BlogResponseDto> blogList = new ArrayList<>();

        for(Blog blog : foundBlogList) {
            blogList.add(new BlogResponseDto(blog));
        }
        return blogList;
    }

}