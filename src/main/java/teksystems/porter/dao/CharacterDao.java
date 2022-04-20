package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.Character;

public interface CharacterDao extends JpaRepository<Character, Integer> {
}