import java.io.Serializable;

public class Author implements Serializable {
    private long id;
    private String author_name;

    public Author(){

    }

    public Author(long id, String author_name) {
        this.id = id;
        this.author_name = author_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}