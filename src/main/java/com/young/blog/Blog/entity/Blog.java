package com.young.blog.Blog.entity;

import com.young.blog.Blog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String title;
    @Column
    String username;
    @Column
    String contents;
    @Column
    String password;
    public Blog(BlogRequestDto blogRequestDto) {
        this.title = blogRequestDto.getTitle();
        this.contents = blogRequestDto.getContents();
        this.username = blogRequestDto.getUsername();
        this.password = blogRequestDto.getPassword();
    }
    // 서버가 우리가 보낸걸 저장함
//    public Blog() {
//
//    }
// @NoArgsConstructor

    // 자바의 객체 생성자, 클래스 메서드 만드는 거 알자
    public Blog update(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();

        return new Blog();
    }

}