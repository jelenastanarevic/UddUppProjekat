package model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Length(max = 50)
    private String title;

    @NotNull
    @Column(nullable = false)
    @Length(min=9,max=9)
    private String issn;


    //tipovi placanja za svaki casopis - manyTomany klasa izmodelovana sa entitetom MagazinePaymentType
    @OneToMany(mappedBy = "magazine", cascade = CascadeType.REMOVE)
    private List<MagazinePaymentType> magazinePaymentTypes;


    @OneToMany(mappedBy = "magazine", cascade = CascadeType.REMOVE)
    private List<Membership> memberships;

    //artikli jednog casopisa
    @OneToMany(mappedBy = "magazine", cascade = CascadeType.REMOVE)
    private List<Article> articles;


    public Magazine(){}

    public Magazine(String title,String issn) {
        this.title = title;
        this.issn = issn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssn() {
        return issn;
    }


    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
