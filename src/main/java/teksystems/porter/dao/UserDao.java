package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
}