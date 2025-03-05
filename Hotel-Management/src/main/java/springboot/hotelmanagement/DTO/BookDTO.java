package springboot.hotelmanagement.DTO;

import jakarta.persistence.Column;
import lombok.*;
import springboot.hotelmanagement.domain.entity.Book;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDTO {
    private String userID;
    private String userName;
    private int bookID;
    private int roomID;
    private String bookDate;
    private int bookCost;
    private String checkIn;
    private String checkOut;
    private boolean available;

    public Book toEntity()
    {
        Book build = Book.builder()
                .userID(userID)
                .userName(userName)
                .bookID(bookID)
                .roomID(roomID)
                .bookDate(bookDate)
                .bookCost(bookCost)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .available(available)
                .build();
                return build;
    }
    @Builder
    public BookDTO(String userID, String userName, int bookID, int roomID, String bookDate, int bookCost,
                   String checkIn, String checkOut, boolean available)
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
