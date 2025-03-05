package springboot.hotelmanagement.DTO;

import lombok.*;
import springboot.hotelmanagement.domain.entity.Room;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoomDTO {
    private int roomViewID;
    private int roomID;
    private String roomSize;
    private String checkIn;
    private String checkOut;
    private boolean booked;
    private int roomCost;
    private String userID;

    public Room toEntity() {
        Room build = Room.builder()
                .roomID(roomID)
                .roomSize(roomSize)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .booked(booked)
                .roomCost(roomCost)
                .userID(userID)
                .build();
        return build;
    }

    @Builder
    public RoomDTO(int roomID, String roomSize, String checkIn, String checkOut,
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
