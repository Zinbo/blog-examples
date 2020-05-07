package mockitocheatsheet;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BlogPostService {

    private BlogRepository blogRepository;

    public BlogPostService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogRepository.getAllBlogPosts();
    }

    public Optional<BlogPost> getBlogPostById(int id) {
        return blogRepository.getBlogPostById(id);
    }

    public List<BlogPost> getBlogPostsByAuthorAndAfterDate(String author, Date date) {
        List<BlogPost> blogPostsByAuthorAndAfterDate = blogRepository.getBlogPostsByAuthorAndAfterDate(author, date);
        blogPostsByAuthorAndAfterDate.sort(Comparator.comparing(BlogPost::getDate));
        return blogPostsByAuthorAndAfterDate;
    }

    public boolean checkIfBlogPostHasBeenSaved(BlogPost blogPost) {
        return blogRepository.checkIfBlogPostHasBeenSaved(blogPost);
    }
}
