package springboot.hotelmanagement.domain.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@Entity
@Table(name="room") //db테이블 매핑
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Room {

    @Column(length = 45, nullable = false) //VARCHAR(20)
    private String userID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) //VARCHAR(45)
    private int roomID;


    @Column(length = 20, nullable = true) //VARCHAR(45)
    private String roomSize;

    @Column(length = 45, nullable = true) //VARCHAR(45)
    private String checkIn;

    @Column(length = 45, nullable = true) //VARCHAR(45)
    private String checkOut;

    @Column(nullable = true) //VARCHAR(45)
    private boolean booked;

    @Column(nullable = true) //VARCHAR(45)
    private int roomCost;
    @Builder
    public Room(int roomID, String roomSize, String checkIn, String checkOut,
                String userID, boolean booked, int roomCost)
    {
        this.roomID = roomID;
        this.roomSize = roomSize;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.booked = booked;
        this.roomCost = roomCost;
        this.userID = userID;
    }
}

