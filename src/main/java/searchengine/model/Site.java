package searchengine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "site")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "status_time")
    private LocalDateTime statusTime;

    @Column
    private String lastError;

    @Column(nullable = false, columnDefinition = "VARCHAR(256)")
    private String url;

    @Column(nullable = false, columnDefinition = "VARCHAR(256)")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Site site)) return false;
        return Objects.equals(getId(), site.getId()) && getStatus() == site.getStatus() && Objects.equals(getStatusTime(), site.getStatusTime()) && Objects.equals(getLastError(), site.getLastError()) && Objects.equals(getUrl(), site.getUrl()) && Objects.equals(getName(), site.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getStatusTime(), getLastError(), getUrl(), getName());
    }

}
