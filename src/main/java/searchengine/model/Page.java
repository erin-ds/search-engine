package searchengine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page", indexes = @Index(name = "pathPage", columnList = "path"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "path", nullable = false, unique = true, columnDefinition = "VARCHAR(256)")
    private String path;

    @Column(name = "code", nullable = false)
    private int code;

    @Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    @OneToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Page page)) return false;
        return getId() == page.getId() && getCode() == page.getCode() && Objects.equals(getPath(), page.getPath()) && Objects.equals(getContent(), page.getContent()) && Objects.equals(getSite(), page.getSite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPath(), getCode(), getContent(), getSite());
    }
}
