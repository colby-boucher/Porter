package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import teksystems.porter.entity.Character;
import teksystems.porter.entity.User;

import java.util.List;

public interface CharacterDao extends JpaRepository<Character, Long> {

    Character findCharacterById(@Param("id") Integer id);

    List<Character>findCharactersByUserEquals(@Param("user") User user);
}