package springforhumans;

import org.springframework.stereotype.Component;

@Component
public class BlogPostService {

    private DatabaseRepository databaseRepository;

    public BlogPostService(DatabaseRepository databaseRepository) {

        this.databaseRepository = databaseRepository;
    }

    public BlogPost getBlogPostById(String id) {
        return databaseRepository.getBlogPostById(id);
    }
}
