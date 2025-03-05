package springboot.hotelmanagement.service;
import springboot.hotelmanagement.DTO.BookDTO;
import springboot.hotelmanagement.DTO.RoomDTO;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.domain.entity.Room;
import springboot.hotelmanagement.domain.entity.Book;
import springboot.hotelmanagement.domain.entity.User;
import springboot.hotelmanagement.domain.repository.BookRepository;
import springboot.hotelmanagement.domain.repository.RoomRepository;
import org.springframework.stereotype.Service;
import springboot.hotelmanagement.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    private  BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //@Transactional
    public String saveBook(BookDTO bookDTO)
    {
        return bookRepository.save(bookDTO.toEntity()).getUserID();
    }
    public List<BookDTO> getBookList() //find all board info
    {
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : bookList) {
            BookDTO bookDTO = BookDTO.builder()
                    .userID(book.getUserID())
                    .userName(book.getUserName())
                    .bookID(book.getBookID())
                    .roomID(book.getRoomID())
                    .bookDate(book.getBookDate())
                    .bookCost(book.getBookCost())
                    .checkIn(book.getCheckIn())
                    .checkOut(book.getCheckOut())
                    .available(book.isAvailable())
                    .build();
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
    public BookDTO getMyBook(int bookID) //find board info use board id
    {
        Book myid = bookRepository.findByBookID(bookID).orElse(null);
        BookDTO build =  BookDTO.builder().bookID(myid.getBookID())
                .userID(myid.getUserID())
                .userName(myid.getUserName())
                .roomID(myid.getRoomID())
                .bookDate(myid.getBookDate())
                .bookCost(myid.getBookCost())
                .checkIn(myid.getCheckIn())
                .checkOut(myid.getCheckOut())
                .available(myid.isAvailable())
                .build();
        return build;
    }
}
