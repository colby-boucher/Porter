package teksystems.porter.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.porter.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query
    public User findById(@Param("id") Integer id);

    @Query(value="select * from users where email = :email and password = :password", nativeQuery = true)
    public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value="select * from users where email = :email", nativeQuery = true)
    public User findByEmail(@Param("email") String email);

}