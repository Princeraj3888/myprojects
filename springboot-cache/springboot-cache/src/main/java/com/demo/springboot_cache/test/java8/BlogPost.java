package com.demo.springboot_cache.test.java8;

import lombok.Data;

@Data
public class BlogPost {

    String title;
    String author;
    BlogPostType blogType;
    int likes;

}
