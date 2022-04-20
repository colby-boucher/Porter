package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {
}