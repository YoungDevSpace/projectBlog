package com.young.blog.dto;

import com.young.blog.entity.Blog;
import lombok.Getter;
@Getter
public class BlogResponseDto {
    String contents;
    public BlogResponseDto(Blog newblog) {
        this.contents = newblog.getContents();
    }
}
