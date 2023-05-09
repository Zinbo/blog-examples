package springforhumans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Set up Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("springforhumans");

        BlogPostService blogPostService = context.getBean(BlogPostService.class);
        BlogPost blogpost = blogPostService.getBlogPostById("123");
        System.out.println(String.format("Blog post id='%s' name='%s' content='%s'", blogpost.getId(), blogpost.getName(), blogpost.getContent()));
    }
}
