package mockitocheatsheet;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class VerifyTest {

    @Test
    public void getAllBlogPosts_withBlogPost_verifiesThatRepositoryWasCalled() {
        // arrange
        List<BlogPost> expected = Arrays.asList(new BlogPost("Spring for humans"),
                new BlogPost("Mockito Cheatsheet"));
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        Mockito.when(blogRepository.getAllBlogPosts()).thenReturn(expected);
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        service.getAllBlogPosts();

        // assert
        Mockito.verify(blogRepository).getAllBlogPosts();
    }

    @Test
    public void getBlogPostById_withBlogPost_verifiesThatCorrectMethodWasCalled() {
        // arrange
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        BlogPost expected = new BlogPost("Spring for humans");
        Mockito.when(blogRepository.getBlogPostById(1)).thenReturn(Optional.of(expected));
        BlogPostService service = new BlogPostService(blogRepository);

        // act
        service.getBlogPostById(1);

        // assert
        Mockito.verify(blogRepository, Mockito.never()).getBlogPostById(100);
        Mockito.verify(blogRepository).getBlogPostById(1);
    }
    
    @Test
    public void getBlogPostById_withBlogPost_verifiesCorrectArgumentPassed() {
        // arrange
        BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
        int expected = 1;
        Mockito.when(blogRepository.getBlogPostById(expected))
                .thenReturn(Optional.of(new BlogPost("Spring for humans")));
        BlogPostService service = new BlogPostService(blogRepository);
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        // act
        service.getBlogPostById(expected);
        Mockito.verify(blogRepository).getBlogPostById(captor.capture());
        int actual = captor.getValue();

        // assert
        assertEquals(expected, actual);
    }
}
