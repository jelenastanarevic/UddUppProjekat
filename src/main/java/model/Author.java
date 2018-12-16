package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //creator of an article
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Article> articles;

    //moze biti koautor u vise clanaka
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Coauthor> coauthors;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Membership> memberships;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Coauthor> getCoauthors() {
        return coauthors;
    }

    public void setCoauthors(List<Coauthor> coauthors) {
        this.coauthors = coauthors;
    }
}
