package mockitocheatsheet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

public class VoidMethodsTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllBlogPosts_withBlogPostsInDb_callsVerifyConnectionToDatabaseIsAlive() {
        // arrange
        Configuration configMock = Mockito.mock(Configuration.class);
        BlogRepository blogRepository = new BlogRepository(configMock);

        AtomicBoolean verifyMethodCalled = new AtomicBoolean(false);
        Mockito.doAnswer(invocationOnMock -> {
            // We can do whatever we want here, and it will be executed when
            // verifyConnectionToDatabaseIsAlive
            // If the method had any arguments, we can capture them here
            verifyMethodCalled.set(true);
            return null;
        }).when(configMock).verifyConnectionToDatabaseIsAlive();

        // act
        blogRepository.getAllBlogPosts();

        // assert
        assertTrue(verifyMethodCalled.get());
    }


    @Test(expected = DatabaseDownException.class)
    public void getAllBlogPosts_withConnectionToDbDown_throwsException() {
        // arrange
        Configuration configMock = Mockito.mock(Configuration.class);
        BlogRepository blogRepository = new BlogRepository(configMock);

        AtomicBoolean verifyMethodCalled = new AtomicBoolean(false);
        Mockito.doThrow(new DatabaseDownException()).when(configMock).verifyConnectionToDatabaseIsAlive();

        // act
        blogRepository.getAllBlogPosts();

        // assert
        // Test will pass if exception of type DatabaseDownException is thrown
    }

    @Test
    public void getAllBlogPosts_withBlogPostsInDb_returnsBlogPosts() {
        // arrange
        Configuration configMock = Mockito.mock(Configuration.class);
        BlogRepository blogRepository = new BlogRepository(configMock);

        AtomicBoolean verifyMethodCalled = new AtomicBoolean(false);
        Mockito.doCallRealMethod().when(configMock).verifyConnectionToDatabaseIsAlive();

        // act
        blogRepository.getAllBlogPosts();

        // assert
        // Test will pass if exception of type DatabaseDownException is thrown
    }
}
