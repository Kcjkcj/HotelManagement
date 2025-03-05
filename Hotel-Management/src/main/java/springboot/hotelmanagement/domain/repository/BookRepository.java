package springboot.hotelmanagement.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import springboot.hotelmanagement.domain.entity.Book;
import springboot.hotelmanagement.domain.entity.Room;

@Repository

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByBookID(int bookID);
}
