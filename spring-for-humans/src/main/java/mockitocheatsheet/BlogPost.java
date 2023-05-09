package mockitocheatsheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BlogPost {
    private String id;
    private List<Comment> comments = new ArrayList<>();
    private Content content;
    private Date date;
    private String author;

    public BlogPost(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = new Content(content);
        this.date = new Date();
    }

    public BlogPost(String content, String author, Date date) {
        this.id = UUID.randomUUID().toString();
        this.content = new Content(content);
        this.author = author;
        this.date = date;
    }

    public int countNumberOfComments() {
        return comments.size();
    }

    public void addComment(String value, String commenter) {
        comments.add(new Comment(value, commenter));
    }

    public String getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Content getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }
}
