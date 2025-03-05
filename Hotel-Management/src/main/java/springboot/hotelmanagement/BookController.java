package springboot.hotelmanagement;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springboot.hotelmanagement.DTO.BookDTO;
import springboot.hotelmanagement.DTO.BookDTO;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.domain.entity.Book;
import springboot.hotelmanagement.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springboot.hotelmanagement.service.RoomService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@CrossOrigin(originPatterns="http:localhost::3000")//리액트 연결 허용
@Controller
@Configuration
public class BookController {
    private BookService bookService;
    private final Logger log = LoggerFactory.getLogger(getClass());
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/book")
    public BookDTO booklist(){
        BookDTO bookDTO =new BookDTO();
        List<BookDTO> booklist = bookService.getBookList();
        System.out.println(booklist);
        return bookDTO;

    }

}
