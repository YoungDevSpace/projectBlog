
package com.young.blog.controller;

import com.young.blog.dto.BlogRequestDto;
import com.young.blog.dto.BlogResponseDto;
import com.young.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs")
    public BlogResponseDto save(@RequestBody BlogRequestDto requestDto) {
        // 컨트롤러에서 리퀘스트디티오를 서비스로 보내줌
        BlogResponseDto responseDto = blogService.save(requestDto);
        return responseDto;
//        return blogService.save(requestDto);
    }


    @PutMapping("/blogs/{blog_id}")
    public BlogResponseDto update(@RequestParam Long blog_id, @RequestBody BlogRequestDto requestDto) {
        // service쪽에서 처리, requestDto 수정할 내용
        BlogResponseDto blogResponseDto = blogService.update(blog_id, requestDto);
        return blogResponseDto;
    }

    @DeleteMapping("/blogs/{blog_id}")
    public void delete(@PathVariable Long blog_id) {
        blogService.delete(blog_id);
    }

    @GetMapping("/blogs/{blog_id}")
    public BlogResponseDto getBlog(@PathVariable Long blog_id) {
        BlogResponseDto responseDto = blogService.getBlog(blog_id);
        return responseDto;
    }

    @GetMapping("/blogs")
    public List<BlogResponseDto> getBlogList() {
        List<BlogResponseDto> blogList = blogService.getBlogList();
        return blogList;
    }
}