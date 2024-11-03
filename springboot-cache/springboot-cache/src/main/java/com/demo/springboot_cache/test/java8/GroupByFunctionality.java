package com.demo.springboot_cache.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFunctionality {

    public static void main(String args[]){
        List<BlogPost> blogPosts = new ArrayList<>();
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setTitle("News in india");
        blogPost1.setAuthor("new asia");
        blogPost1.setLikes(200);
        blogPost1.setBlogType(BlogPostType.NEWS);
        blogPosts.add(blogPost1);

        BlogPost blogPost2 = new BlogPost();
        blogPost2.setTitle("News in USA");
        blogPost2.setAuthor("news usa");
        blogPost2.setLikes(900);
        blogPost2.setBlogType(BlogPostType.GUIDE);
        blogPosts.add(blogPost2);

        BlogPost blogPost3 = new BlogPost();
        blogPost3.setTitle("News in Europe");
        blogPost3.setAuthor("new europe");
        blogPost3.setLikes(900);
        blogPost3.setBlogType(BlogPostType.NEWS);
        blogPosts.add(blogPost3);

        BlogPost blogPost4 = new BlogPost();
        blogPost4.setTitle("News in india");
        blogPost4.setAuthor("new india");
        blogPost4.setLikes(900);
        blogPost4.setBlogType(BlogPostType.REVIEW);
        blogPosts.add(blogPost4);

        Map<BlogPostType, List<BlogPost>> oneMap = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getBlogType));

        System.out.println("oneMap: "+oneMap);


    }
}
