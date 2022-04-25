package teksystems.porter.entity;

import lombok.*;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "character")
    private Set<CharactersItem> charactersItems = new LinkedHashSet<>();



}