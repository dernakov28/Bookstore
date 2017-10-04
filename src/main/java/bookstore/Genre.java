package bookstore;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @SequenceGenerator(name = "gen", sequenceName = "genres_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen")
    private long id;

    @Column(name = "name")
    private String name;

    protected Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
}
