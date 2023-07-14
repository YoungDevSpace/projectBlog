package com.young.blog.service;

import com.young.blog.dto.BlogRequestDto;
import com.young.blog.dto.BlogResponseDto;
import com.young.blog.entity.Blog;
import com.young.blog.repository.BlogRepository;
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
        // ResponseDto 반환 얘는 그냥 내가정한이름 requestdto를 받는거고
        // Entity // dto -> entity 생성자를 통한 객체생성
        Blog newBlog = new Blog(requestDto);
        // entity -> DB
//        blogRepository.save(newBlog);
//        BlogResponseDto responseDto = new BlogResponseDto(newBlog);
        Blog saveBlog = blogRepository.save(newBlog);
        BlogResponseDto responseDto = new BlogResponseDto(saveBlog);
//         newblog (entity) -> blog responseDto 바꿔서 보내주면 될듯???
        return responseDto;
    }

    @Transactional
    public BlogResponseDto update(Long blog_id, BlogRequestDto requestDto) {
        // 1. 어떤 블로그인지 찾아야지?
        // 어떻게 찾아야하나

        // -> Blog를 찾아! id가지고 블로그를 찾아

        // 만약에 ?id에 맞는 블로그가 없다? 그렇다면 null로 반환
        // -> null, 예외를 던지던가까지 조치를 해줘야됨

        // -> 이 찾은 블로그를 만들어 줘야됨

        // 자바의 객체 생성자, 클래스 메서드 만드는 거 알자

        Blog findBlog = blogRepository.findById(blog_id).orElse(null); // 데이터베이스에서 블로그 찾는 것. 찾은 블로그 만들어주는 것
        // .orElse(null)
        // orElse

        // -> 수정은 어떻게? Blog findBlog = 로 실체를 만들어줌
        // 그럼 블로그 엔티티가서 수정한 내용을 받아서
        // 기존내용이랑 수정내용을 바꿔주면 되겠다~!

        // findBlog.update(requestDto);//찾은 내용을 수정
        // 여기까지가 수정 끝

        // 그럼 수정한 내용을 보내주면 된다
        // entity -> dto바꿔서

        // 수정하기전에 비밀번호 확인하면 되겠죠?
        // 찾은 블로그가 위에 있어요~! 저 블로그 안에 비밀번호 있겠죠?
        // 내가 보낸 비밀번호랑 저기 블로그 비밀번호랑 확인하면 되지 않을까요?

//        if(findBlog.getPassword() == requestDto.getPassword()) {
//            Blog updateBlog = findBlog.update(requestDto);
//        } else {
//            throw new IllegalArgumentException("wrong password");
//        }

        if(findBlog.getPassword() != requestDto.getPassword()) {
            throw new IllegalArgumentException("wrong password");
        }
        Blog updateBlog = findBlog.update(requestDto);
        BlogResponseDto responseDto = new BlogResponseDto(updateBlog);
        return responseDto;
        // Blog updateBlog = findBlog.update(requestDto); // ->updateBlog

        // entity -> dto바꿔서
        //BlogResponseDto responseDto = new BlogResponseDto(updateBlog);
        //return responseDto;

    }

    public void delete(Long blog_id) {
//        // 어떤 블로그인지 찾아야지
//        Blog findBlog = blogRepository.findById(blog_id).orElse(null); // 데이터베이스에서 블로그 찾는 것.
//        // 어떻게 찾느냐
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











//    public getBlog(Long blog_id) {
//        Blog findBlog = blogRepository.findById(blog_id).orElse(null);
//
//        // 찾은 blog entity 를 -> 사용자 측 클라이언트한테 보내주어야함
//
//        // 어떻게? 보내줄까요?
//        //우린항상 dto->entity->dto 이렇게 보낸다
//
//        // 지금은 entity->dto 요기만 있으면 됨!
//        //entity -> ReponseDto 바꿔서 보내줨
//        BlogResponseDto responseDto = new BlogResponseDto(findBlog);
//
//        return responseDto;
//
//
//    }
//
//    public getBlogList() {
//        //blog 여러개 잖아요?
//        //여러개를 가지고 오고싶단 말이에요 제말은 아시겠나요?
//        //그러면 즉 list로 만들어야 된다는 말이에요
//        //list를 만드는 방법이 2가지가 있어요
//
//        //1번 외운다
//        // List<BlogResponseDto> blogList = blogRepository.findAll().stream().map(BlogResponseDto::new).toList();
//
//        //2번 for문을 쓴다.
//        ArrayList<BlogResponseDto> blogList = new ArrayList<>();
//        List<Blog> foundBlogList = blogRepository.findAll();
//
//        for(Blog blog : foundBlogList) {
//            blogList.add(new BlogResponseDto(blog));
//        }
//    }
}