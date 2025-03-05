package springboot.hotelmanagement.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Table(name="book") //db테이블 매핑
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @Column(length = 45, nullable = false) //VARCHAR(20)
    private String userID;

    @Column(length = 20, nullable = false) //VARCHAR(45)
    private String userName;

    @Column(nullable = true) //VARCHAR(45)
    private int bookID;

    @Column(nullable = true) //VARCHAR(45)
    private int roomID;

    @Column(length = 45, nullable = true) //VARCHAR(45)
    private String bookDate;

    @Column(nullable = true) //VARCHAR(45)
    private int bookCost;

    @Column(length = 45, nullable = true) //VARCHAR(45)
    private String checkIn;

    @Column(length = 45, nullable = true) //VARCHAR(45)
    private String checkOut;

    @Column(nullable = true) //VARCHAR(45)
    private boolean available;

    @Builder
    public Book(String userName, String userID, int bookID, int roomID,
    String bookDate, int bookCost, String checkIn, String checkOut, boolean available)
    {
        this.userID = userID;
        this.userName = userName;
        this.roomID = roomID;
        this.bookID = bookID;
        this.bookCost = bookCost;
        this.bookDate=bookDate;
        this.checkIn =checkIn;
        this.checkOut = checkOut;
        this.available = available;
    }
}
