package teksystems.porter.entity;

import teksystems.porter.entity.CharactersItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "weight", precision = 10)
    private BigDecimal weight;

    @Column(name = "value", precision = 10)
    private BigDecimal value;

    @OneToMany(mappedBy = "item")
    private Set<CharactersItem> charactersItems = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Set<CharactersItem> getCharactersItems() {
        return charactersItems;
    }

    public void setCharactersItems(Set<CharactersItem> charactersItems) {
        this.charactersItems = charactersItems;
    }

}