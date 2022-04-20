package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.CharactersItem;

public interface CharactersItemDao extends JpaRepository<CharactersItem, Integer> {
}