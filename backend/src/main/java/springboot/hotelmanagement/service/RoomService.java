package springboot.hotelmanagement.service;
import org.springframework.transaction.annotation.Transactional;
import springboot.hotelmanagement.DTO.RoomDTO;
import springboot.hotelmanagement.domain.entity.Room;
import springboot.hotelmanagement.domain.repository.RoomRepository;
import org.springframework.stereotype.Service;
import springboot.hotelmanagement.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RoomService {
    private RoomRepository roomRepository;
    private UserRepository userRepository;
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Transactional
    public boolean existsByRoomId(int id)
    {
        return roomRepository.existsByRoomID(id);
    }
    public String saveRoom(RoomDTO roomDTO)
    {
        return roomRepository.save(roomDTO.toEntity()).getUserID();
    }
    public List<RoomDTO> getRoomList() //find all board info
    {
        List<Room> roomList = roomRepository.findAll();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for(Room room : roomList) {
            RoomDTO roomDTO = RoomDTO.builder()
                            .roomID(room.getRoomID())
                            .roomSize(room.getRoomSize())
                            .checkIn(room.getCheckIn())
                            .checkOut(room.getCheckOut())
                             .booked(room.isBooked())
                            .roomCost(room.getRoomCost())
                            .userID(room.getUserID())
                                    .build();
            roomDTOList.add(roomDTO);
        }
        return roomDTOList;
    }

    public List<RoomDTO> getRoomList_UserID(String userID) //find all board info
    {
        List<Room> roomList = roomRepository.findByUserID(userID);
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for(Room room : roomList) {
            RoomDTO roomDTO = RoomDTO.builder()
                    .roomID(room.getRoomID())
                    .roomSize(room.getRoomSize())
                    .checkIn(room.getCheckIn())
                    .checkOut(room.getCheckOut())
                    .booked(room.isBooked())
                    .roomCost(room.getRoomCost())
                    .userID(room.getUserID())
                    .build();
            roomDTOList.add(roomDTO);
        }
        return roomDTOList;
    }
    public RoomDTO getMyRoom(int roomID) //find board info use board id
    {
        Room myid = roomRepository.findByRoomID(roomID).orElse(null);
        RoomDTO build =  RoomDTO.builder().userID(myid.getUserID())
                .roomSize(myid.getRoomSize())
                .checkIn(myid.getCheckIn())
                .checkOut(myid.getCheckOut())
                .booked(myid.isBooked())
                .roomCost(myid.getRoomCost())
                .roomID(myid.getRoomID())
                .build();
        return build;
    }

    public Room getRoom(int roomID) //find board info use board id
    {
        Room room = roomRepository.findByRoomID(roomID).orElse(null);
        return room;
    }

    public void deleteByRoomID(Room room)
    {
        roomRepository.delete(room);
    }
}
