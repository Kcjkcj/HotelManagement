package springboot.hotelmanagement.service;
import org.springframework.transaction.annotation.Transactional;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.domain.entity.User;
import springboot.hotelmanagement.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //@Transactional
    public String saveUser(UserDTO userDTO)
    {
        return userRepository.save(userDTO.toEntity()).getUserID();
    }
    @Transactional
    public boolean existsByUserId(String UserID)
    {
        return userRepository.existsByUserID(UserID);
    }
    public List<UserDTO> getUserList() //find all board info
    {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList) {
            UserDTO userDTO = UserDTO.builder()
                    .userID(user.getUserID())
                    .userPassword(user.getUserPassword())
                    .userName(user.getUserName())
                    .userEmail(user.getUserEmail())
                    .userTel(user.getUserTel())
                    .build();
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
    public UserDTO getMyUser(String userId) //find board info use board id
    {
        User myid = userRepository.findById(userId).orElse(null);
        UserDTO build =  UserDTO.builder().userID(myid.getUserID())
                .userPassword(myid.getUserPassword())
                .userName(myid.getUserName())
                .userEmail(myid.getUserEmail())
                .userTel(myid.getUserTel())
                .build();
        return build;
    }
    public UserDTO login(UserDTO userDTO)
    {
        Optional<User> byUserID = userRepository.findByUserID(userDTO.getUserID());
        if (byUserID.isPresent())
        {
            User user = byUserID.get();
            if(user.getUserPassword().equals(userDTO.getUserPassword()))
            {
                return userDTO;
                //비밀번호 ok
            }
            else {return null;}
        }
        else {return null;} //권한 x
    }

}
