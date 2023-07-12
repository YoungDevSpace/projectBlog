package com.young.blog.controller;

import com.young.blog.dto.BlogRequestDto;
import com.young.blog.dto.BlogResponseDto;
import com.young.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs")
    public BlogResponseDto save(@RequestBody BlogRequestDto requestDto) {

        // /blog/{title}/{username}/{asjsdkhal}/{ajdlkfj}
        // 1. pathvariable~~

        // blog?title=assdn&username=234&password=gjlgl&
        // 2. RequestPram

        // 우리가 데이터를 body안에 넣어서 보내주는
        // 3. RequestBody

        // param
        // 4. modelatte




        // 컨트롤러에서 리퀘스트디티오를 서비스로 보내줌
        BlogResponseDto responseDto = blogService.save(requestDto);
        return responseDto;
        // 한줄로도 가능 // blogservice -> 내부 로직 수행, -> Responsedto 로 반환!
//        return blogService.save(requestDto);
    }

    // 겟 매핑으로!!


//    @PutMapping("/blogs/{blog_id}")
//    public void update(@PathVariable Long blog_id, @RequestBody BlogRequestDto requestDto){
//        blogService.update(blog_id, requestDto); // service쪽에서 처리, requestDto 수정할 내용
//    }

    @PutMapping("/blogs/{blog_id}")
    public BlogResponseDto update(@RequestParam Long blog_id, @RequestBody BlogRequestDto requestDto){
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













//    @GetMapping("/blogs")
//    public getBlog(@PathVariable Long blog_id) {
//
//        //blogService.getBlog(blog_id);
//        BlogResponseDto responseDto = blogService.getBlog(blog_id);
//        return responseDto;
//    }

//    @GetMapping("/blogs")
//    public getBlogList() {
//        List<BlogResponseDto>blogList = blogService.getBlogList();
//        return blogList;
//        //blogService.getBlogList();
//    }

}
