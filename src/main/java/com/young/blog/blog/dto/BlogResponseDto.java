package com.young.blog.blog.dto;

import com.young.blog.blog.entity.Blog;
import lombok.Getter;
@Getter
public class BlogResponseDto {
    String title;
    String username;
    String contents;

    public BlogResponseDto(Blog newblog) {
        this.title = newblog.getTitle();
        this.username = newblog.getUsername();
        this.contents = newblog.getContents();
    }

    // 나중에 ResponseDto가 중요해짐
    // 댓글이라든지, 좋아요 기능을 따로!!
}
