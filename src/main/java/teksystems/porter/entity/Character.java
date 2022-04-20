package teksystems.porter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "weight_limit", nullable = false, precision = 10)
    private BigDecimal weightLimit;

    @OneToMany(mappedBy = "character")
    private Set<CharactersItem> charactersItems = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(BigDecimal weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Set<CharactersItem> getCharactersItems() {
        return charactersItems;
    }

    public void setCharactersItems(Set<CharactersItem> charactersItems) {
        this.charactersItems = charactersItems;
    }

}