package springboot.hotelmanagement.domain.repository;
import org.springframework.stereotype.Repository;
import springboot.hotelmanagement.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.hotelmanagement.domain.entity.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
    Optional<Room> findByRoomID(int roomID);
    List<Room> findByUserID(String userID);
    boolean existsByRoomID(int id);
}
