package searchengine.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lemma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lemma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    @Column(name = "lemma", nullable = false, columnDefinition = "VARCHAR(256)")
    private String lemma;

    @Column(name = "frequency", nullable = false)
    private int frequency;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lemma lemma1)) return false;
        return getId() == lemma1.getId() && getFrequency() == lemma1.getFrequency() && Objects.equals(getSite(), lemma1.getSite()) && Objects.equals(getLemma(), lemma1.getLemma());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSite(), getLemma(), getFrequency());
    }
}
