package nl.utwente.soa.sampleBlogApplication.services;

import nl.utwente.soa.sampleBlogApplication.domain.Blog;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BlogService {
    private static List<Blog> blogs = new ArrayList<>();

    @PostConstruct
    public void blogSetup(){
        blogs.add(
            new Blog(
                1L,
                "Test Blog 1",
                "Summary1",
                "Content 1"
            )
        );
        blogs.add(
            new Blog(
                2L,
                "Test Blog 2",
                "summary 2",
                "Content 2"
            )
        );
        blogs.add(
                new Blog(
                        3L,
                        "Test Blog 3",
                        "summary 3",
                        "Content 3"
                )
        );
    }

    public List<Blog> getBlogs(){
        return blogs;
    }

    public Blog getBlogById(Long id){
        return blogs.stream().filter(blog -> blog.getId() == id).findFirst().orElse(null);
    }
}
