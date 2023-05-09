package mockitocheatsheet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MethodsTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllBlogPosts_withBlogPostsInDb_returnsBlogPosts() {
        // arrange
        List<BlogPost> expected = Arrays.asList(new BlogPost("Spring for humans"),
                new BlogPost("Mockito Cheatsheet"));
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getAllBlogPosts()).thenReturn(expected);
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        List<BlogPost> actual = service.getAllBlogPosts();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void getBlogPostById_withExistingBlogPostInDb_returnsBlogPost() {
        // arrange
        BlogPost expected = new BlogPost("Spring for Humans");
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getBlogPostById(Mockito.anyInt())).thenAnswer(invocationOnMock -> {
            int id = invocationOnMock.getArgument(0);
            if(id == 1) return Optional.of(expected);
            else return Optional.empty();
        });
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        BlogPost actual = service.getBlogPostById(1).get();

        // assert
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBlogPostById_withMissingBlogPost_throwsException() {
        // arrange
        BlogPost expected = new BlogPost("Spring for Humans");
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getBlogPostById(1)).thenThrow(new IllegalArgumentException());
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        BlogPost actual = service.getBlogPostById(1).get();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void getBlogPostById_withMissingBlogPost_returnsEmpty() {
        // arrange
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getBlogPostById(1)).thenCallRealMethod();
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        Optional<BlogPost> actual = service.getBlogPostById(1);

        // assert
        assertFalse(actual.isPresent());
    }
}
