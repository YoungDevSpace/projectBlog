package com.young.blog.blog.dto;

import lombok.Getter;
@Getter
public class BlogRequestDto {
    String title;
    String username;
    String contents;
    String password;
}