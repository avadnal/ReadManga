package readManga.daoDB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table GENRE.
 */
public class Genre {

    private Long id;
    private String genreName;

    public Genre() {
    }

    public Genre(Long id) {
        this.id = id;
    }

    public Genre(Long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}