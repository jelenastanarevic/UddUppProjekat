package model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
public class ScientificField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scientific_field_id;

    @Length(max = 50)
    @Column(nullable = false)
    private String scientific_field_name;

    //vise clanaka pripada jednoj naucnoj oblasti
    @OneToMany(mappedBy = "scientific_field", cascade = CascadeType.REMOVE)
    private List<Article> articles;

    public ScientificField() {
    }

    public ScientificField(@Length(max = 50) String scientific_field_name) {
        this.scientific_field_name = scientific_field_name;
    }

    public Long getScientific_field_id() {
        return scientific_field_id;
    }

    public void setScientific_field_id(Long scientific_field_id) {
        this.scientific_field_id = scientific_field_id;
    }

    public String getScientific_field_name() {
        return scientific_field_name;
    }

    public void setScientific_field_name(String scientific_field_name) {
        this.scientific_field_name = scientific_field_name;
    }
}
