package mockitocheatsheet;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MatchersTest {

    @Test
    public void getBlogPostByAuthorAndAfterDate_withExistingBlogPostsInDb_returnsBlogPosts() {
        // arrange
        List<BlogPost> expected = Collections.singletonList(new BlogPost("Spring for Humans"));
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Date date = new Date();
        String author = "Shane";
        Mockito.when(blogRepository.getBlogPostsByAuthorAndAfterDate(author, date)).thenReturn(expected);
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        List<BlogPost> actual = service.getBlogPostsByAuthorAndAfterDate(author, date);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void getBlogPostByAuthorAndAfterDate_withoutMatchingBlogPostsInDb_returnsEmptyList() {
        // arrange
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getBlogPostsByAuthorAndAfterDate(Mockito.any(), Mockito.any())).thenReturn(Collections.emptyList());
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        List<BlogPost> actual = service.getBlogPostsByAuthorAndAfterDate("any author", new Date());

        // assert
        assertTrue(actual.isEmpty());
    }

    @Test
    public void getBlogPostByAuthorAndAfterDate_withMatchingAuthorButFutureDate_returnsEmptyList() {
        // arrange
        List<BlogPost> expected = Collections.singletonList(new BlogPost("Spring for Humans"));
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Date date = new Date();
        Mockito.when(blogRepository.getBlogPostsByAuthorAndAfterDate(Mockito.any(), Mockito.eq(date))).thenReturn(expected);
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        List<BlogPost> actual = service.getBlogPostsByAuthorAndAfterDate("any author", date);

        // assert
        assertTrue(actual.isEmpty());
    }

    @Test
    public void checkIfBlogPostHasBeenSaved_withBlogPost_returnsTrue() {
        // arrange
        BlogPost post = new BlogPost("Spring for Humans", "Shane", new Date(5));
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);

        ArgumentMatcher<BlogPost> blogPostMatcher = passedBlogPost ->
                "Shane".equals(passedBlogPost.getAuthor());

        Mockito.when(blogRepository.checkIfBlogPostHasBeenSaved(Mockito.argThat(blogPostMatcher)))
                .thenReturn(true);
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        boolean actual = service.checkIfBlogPostHasBeenSaved(post);

        // assert
        assertTrue(actual);
    }


}
