package teksystems.porter.entity;

import lombok.*;
import teksystems.porter.entity.CharactersItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", precision = 10)
    private Integer weight;

    @Column(name = "value", precision = 10)
    private BigDecimal value;

    @ToString.Exclude
    @OneToMany(mappedBy = "item")
    private Set<CharactersItem> charactersItems = new LinkedHashSet<>();



}