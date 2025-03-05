package springboot.hotelmanagement;
import jdk.jfr.Unsigned;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springboot.hotelmanagement.DTO.RoomDTO;
import springboot.hotelmanagement.domain.entity.Room;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.service.UserService;
import springboot.hotelmanagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import springboot.hotelmanagement.validator.CheckUserIdValidator;
import java.util.HashMap;
import java.util.List;

@Controller
@Configuration
public class RoomController {
    private RoomService roomService;
    private UserService userService;
    private int count=1;
    private final Logger log = LoggerFactory.getLogger(getClass());
    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }
    @ResponseBody
    @PostMapping("/book")
    public List<RoomDTO> roomlist(@RequestBody HashMap<String, Object>map)
    {
        List<RoomDTO> roomlist = roomService.getRoomList_UserID((String)map.get("userID"));
        System.out.println(roomlist);
        return roomlist;

    }

    @ResponseBody
    @PostMapping("/cancel")
    public boolean roomcancle(@RequestBody HashMap<String, Object>map)
    {
        System.out.println(roomService.getRoomList_UserID("111"));
        String get_RoomID = (String)map.get("roomID");
        String get_UserID = (String)map.get("userID");
        System.out.println(get_RoomID);
        System.out.println(get_UserID);
        if(get_RoomID.isEmpty() || get_UserID.isEmpty())
        {
            System.out.println("잘못된 정보.");
            return false;
        }
        else if(roomService.existsByRoomId(Integer.parseInt(get_RoomID))
                && roomService.getMyRoom(Integer.parseInt(get_RoomID)).isBooked())
        {
            System.out.println(roomService.getMyRoom(Integer.parseInt(get_RoomID)));
            roomService.deleteByRoomID(roomService.getRoom(Integer.parseInt(get_RoomID)));
            System.out.println("예약을 취소 하였습니다.");
            return true;
        }
        else
        {
            System.out.println("등록되지 않은 방 입니다.");
            return false;
        }

    }


    @ResponseBody
    @PostMapping("/room")
    public boolean room(@RequestBody HashMap<String, Object>map) throws BadRequestException
    {

        RoomDTO bookDTO = new RoomDTO();
        bookDTO.setUserID((String)map.get("userID"));
        bookDTO.setRoomID(Integer.parseInt((String)map.get("roomID")));
        bookDTO.setRoomCost(Integer.parseInt((String)map.get("roomCost")));
        bookDTO.setRoomSize((String)map.get("roomSize"));
        bookDTO.setCheckIn((String)map.get("checkIn"));
        bookDTO.setCheckOut((String)map.get("checkOut"));
        bookDTO.setBooked(true);
        System.out.println(map);
        System.out.println(bookDTO.getUserID());
        if(roomService.existsByRoomId(bookDTO.getRoomID()) && roomService.getMyRoom(bookDTO.getRoomID()).isBooked())
        {
            System.out.println("이미 등록된 방 입니다.");
            return false;
        }
        if(userService.existsByUserId((bookDTO.getUserID()))) {
            System.out.println("존재하는 아이디 입니다.");
            roomService.saveRoom(bookDTO);
            count = count + 1;
            return true;
        }
        else
        {
            System.out.println("존재하지 않는 아이디 입니다.");
            return false;
        }
    }

}
