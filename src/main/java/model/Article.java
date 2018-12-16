package model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //vise koautora za jedan clanak
    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Coauthor> coauthors;

    @Length(max = 50)
    @Column(nullable = false)
    private String title;

    private String keyWords;

    private String abstract_description;

    private Long working_version;

    private Long final_version;

    private boolean accepted;

    //casopis kome pripada
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magazine_id")
    private Magazine magazine;

    //clanak pripada 1 naucnoj oblasti
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scientific_field_id")
    private ScientificField scientific_field;


    public ScientificField getScientific_field() {
        return scientific_field;
    }

    public void setScientific_field(ScientificField scientific_field) {
        this.scientific_field = scientific_field;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Article() {
        this.accepted = false;
    }

    public Article(@Length(max = 50) String title, String keyWords, String abstract_description, Long working_version, Long final_version, boolean accepted) {

        this.title = title;
        this.keyWords = keyWords;
        this.abstract_description = abstract_description;
        this.working_version = working_version;
        this.final_version = final_version;
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getAbstract_description() {
        return abstract_description;
    }

    public void setAbstract_description(String abstract_description) {
        this.abstract_description = abstract_description;
    }

    public Long getWorking_version() {
        return working_version;
    }

    public void setWorking_version(Long working_version) {
        this.working_version = working_version;
    }

    public Long getFinal_version() {
        return final_version;
    }

    public void setFinal_version(Long final_version) {
        this.final_version = final_version;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
