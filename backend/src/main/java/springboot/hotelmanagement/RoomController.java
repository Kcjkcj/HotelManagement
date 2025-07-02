package springboot.hotelmanagement;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import springboot.hotelmanagement.DTO.RoomDTO;
import springboot.hotelmanagement.service.UserService;
import springboot.hotelmanagement.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller
@Configuration
public class RoomController {

    private RoomService roomService;
    private UserService userService;
    private final Logger log = LoggerFactory.getLogger(getClass());
    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/check")
    public List<RoomDTO> roomlist(@RequestBody HashMap<String, Object>map)
    {
        List<RoomDTO> roomlist = roomService.getRoomList_UserID((String)map.get("userID"));
        System.out.println(roomlist);
        return roomlist;

    }

    @ResponseBody
    @PostMapping("/cancel")
    public boolean roomcancel(@RequestBody HashMap<String, Object>map)
    {
        //System.out.println(roomService.getRoomList_UserID("111"));
        String get_RoomID = (String)map.get("roomID");
        String get_UserID = (String)map.get("userID");
        System.out.println(get_RoomID);
        System.out.println(get_UserID);
        if(get_RoomID.isEmpty() || get_UserID.isEmpty())
        {
            System.out.println("잘못된 정보입니다.");
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
    @PostMapping("/book")
    public boolean book(@RequestBody HashMap<String, Object>map) throws BadRequestException
    {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setUserID((String)map.get("userID"));
        roomDTO.setRoomCost(Integer.parseInt((String)map.get("roomCost")));
        roomDTO.setRoomSize((String)map.get("roomSize"));
        roomDTO.setCheckIn((String)map.get("checkIn"));
        roomDTO.setCheckOut((String)map.get("checkOut"));
        roomDTO.setBooked(true);
        System.out.println(map);
        System.out.println(roomDTO.getUserID());
        if(roomService.existsByRoomId(roomDTO.getRoomID()) && roomService.getMyRoom(roomDTO.getRoomID()).isBooked())
        {
            System.out.println("한글테스트");
            return false;
        }
        if(userService.existsByUserId((roomDTO.getUserID()))) {
            System.out.println("존재하는 아이디 입니다.");
            roomService.saveRoom(roomDTO);
            return true;
        }
        else
        {
            System.out.println("존재하지 않는 아이디 입니다.");
            return false;
        }
    }

}
