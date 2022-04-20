package teksystems.porter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import teksystems.porter.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
}