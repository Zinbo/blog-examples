package mockitocheatsheet;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BlogRepository {

    private Configuration configuration;

    public BlogRepository(Configuration configuration) {
        this.configuration = configuration;
    }

    public boolean checkIfDriverIsPostgres() {
        String driverType = configuration.getRepositoryConfiguration().getDatabaseConfiguration().getDriverConfiguration().getDriverType();
        return (driverType.equals("postgres"));
    }

    public Optional<BlogPost> getBlogPostById(int id) {
        return Optional.empty();
    }

    public List<BlogPost> getAllBlogPosts() {
        configuration.verifyConnectionToDatabaseIsAlive();
        return Collections.singletonList(new BlogPost("my blog post1"));
    }

    public List<BlogPost> getBlogPostsByAuthorAndAfterDate(String author, Date date) {
        return Collections.singletonList(new BlogPost("my blog post1"));
    }


    public boolean checkIfBlogPostHasBeenSaved(BlogPost blogPost) {
        return true;
    }
}
