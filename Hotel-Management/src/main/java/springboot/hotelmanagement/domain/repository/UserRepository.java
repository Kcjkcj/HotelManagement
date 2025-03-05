package springboot.hotelmanagement.domain.repository;
import org.springframework.stereotype.Repository;
import springboot.hotelmanagement.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserID(String userID);
    boolean existsByUserID(String id);
}
