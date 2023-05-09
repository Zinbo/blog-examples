package springforhumans;

import org.springframework.stereotype.Component;

@Component
public class PostgresDatabaseRepository implements DatabaseRepository {

    public PostgresDatabaseRepository() {
        // connect to our database here
    }

    public BlogPost getBlogPostById(String id) {
        // We would go to our database here and
        // get our blog post
        BlogPost blogPost = new BlogPost();
        blogPost.setId(id);
        blogPost.setContent("my blog post content");
        blogPost.setName("Spring for Humans");
        return blogPost;
    }
}
