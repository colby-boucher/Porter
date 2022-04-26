package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.CharacterItems;

public interface CharactersItemDao extends JpaRepository<CharacterItems, Integer> {
}