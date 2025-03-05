package springboot.hotelmanagement.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import springboot.hotelmanagement.domain.entity.User;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "id를 입력 하세요.")
    private String userID;
    @NotBlank(message = "password를 입력 하세요.")
    private String userPassword;
    @NotBlank(message = "이름을 입력 하세요.")
    private String userName;
    @NotBlank(message = "이메일을 입력 하세요.")
    @Email(message = "올바른 이메일 주소를 입력 하세요.")
    private String userEmail;
    @NotBlank(message = "전화번호를 입력 하세요.")
    private String userTel;

    public User toEntity() {
        User build = User.builder()
                .userID(userID)
                .userPassword(userPassword)
                .userName(userName)
                .userEmail(userEmail)
                .userTel(userTel)
                .build();
        return build;
    }

    @Builder
    public UserDTO(String userID, String userPassword, String userName, String userEmail, String userTel) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userTel = userTel;
    }

}
