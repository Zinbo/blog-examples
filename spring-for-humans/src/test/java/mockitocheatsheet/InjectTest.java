package mockitocheatsheet;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class InjectTest {

    @Mock
    private BlogRepository blogRepository;
    @InjectMocks
    private BlogPostService blogPostService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        blogPostService = new BlogPostService(blogRepository);
    }

    @Before
    public void setup2() {
        MockitoAnnotations.initMocks(this);
        System.out.println(blogPostService);
    }


}
