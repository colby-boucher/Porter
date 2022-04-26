package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.CharacterItems;

import java.util.List;

public interface CharactersItemDao extends JpaRepository<CharacterItems, Integer> {

    List<CharacterItems>findCharacterItemsByCharacterEquals(@Param("character") Character character);
}