package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.CharacterItems;

import java.util.List;
import java.util.Map;

@Repository
public interface CharactersItemDao extends JpaRepository<CharacterItems, Integer> {



    List<CharacterItems>findCharacterItemsByCharacterEquals(@Param("character") Character character);

    String sql =
            "SELECT i.name AS name,"+
                    "SUM(i.weight) AS weight,"+ "" +
                    "SUM(i.value) AS value,"+
                    "COUNT(name) AS quantity,"+
                    "ci.worn AS worn "+
                    "FROM characters_items AS ci "+
                    "LEFT JOIN items AS i ON ci.item_id = i.id "+
                    "WHERE ci.character_id = :id "+
                    "GROUP BY `name`";

    @Query(value = sql, nativeQuery = true)
    public List<Map<String,Object>> join(@Param("id") Integer id);
}