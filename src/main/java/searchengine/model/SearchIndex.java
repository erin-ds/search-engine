package searchengine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "search_index")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @ManyToOne
    @JoinColumn(name = "lemma_id", nullable = false)
    private Lemma lemma;

    @Column(name = "lemma_rank", nullable = false)
    private float lemmaRank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchIndex that)) return false;
        return getId() == that.getId() && Float.compare(that.getLemmaRank(), getLemmaRank()) == 0 && Objects.equals(getPage(), that.getPage()) && Objects.equals(getLemma(), that.getLemma());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPage(), getLemma(), getLemmaRank());
    }
}
