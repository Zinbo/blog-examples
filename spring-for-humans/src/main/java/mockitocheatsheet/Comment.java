package mockitocheatsheet;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private String id;
    private String commenter;
    private String value;
    private Date date;

    public Comment(String value, String commenter) {
        this.id = UUID.randomUUID().toString();
        this.commenter = commenter;
        this.value = value;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getCommenter() {
        return commenter;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
