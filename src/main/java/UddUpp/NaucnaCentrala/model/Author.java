package UddUpp.NaucnaCentrala.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Author extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
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
