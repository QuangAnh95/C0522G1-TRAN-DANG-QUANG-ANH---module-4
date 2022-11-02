package com.blogservice.cotroller;

import com.blogservice.model.Blog;
import com.blogservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping//xem danh sách blog
    public ResponseEntity<List<Blog>> showBlogList(@RequestParam(value = "search",defaultValue = "") String titleSearch){
        List<Blog> blogList = blogService.searchByTitle(titleSearch);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")//xem chi tiết 1 blog
    public ResponseEntity<Blog> showBlogById(@PathVariable int id){
        Optional<Blog> optionalBlog = blogService.findById(id);
        if (optionalBlog.isPresent()){
            return new ResponseEntity<>(optionalBlog.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category_id/{id}")//xem danh sách bài viết của 1 category
    public ResponseEntity<List<Blog>> showBlogByCategory(@PathVariable int id){
        List<Blog> blogList = blogService.showListByCategory(id);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
