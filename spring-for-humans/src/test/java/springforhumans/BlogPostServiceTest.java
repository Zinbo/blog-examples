package springforhumans;

import org.junit.Assert;
import org.junit.Test;
import springforhumans.BlogPost;
import springforhumans.BlogPostService;
import springforhumans.DatabaseRepository;

public class BlogPostServiceTest {

    @Test
    public void getBlogPostById_withValidId_returnsBlogPost() {
        // arrange
        BlogPost expected = new BlogPost();
        String id = "123";
        expected.setId(id);
        BlogPostService service = new BlogPostService(new MockDatabaseRepository(expected));

        // act
        BlogPost actual = service.getBlogPostById(id);

        // assert
        Assert.assertEquals(expected, actual);
    }

    private class MockDatabaseRepository implements DatabaseRepository {

        private BlogPost expected;

        public MockDatabaseRepository(BlogPost expected) {
            super();
            this.expected = expected;
        }

        @Override
        public BlogPost getBlogPostById(String id) {
            if(id.equals(expected.getId())) return expected;
            return null;
        }
    }
}
