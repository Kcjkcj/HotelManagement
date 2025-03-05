package springboot.hotelmanagement.domain.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import javax.validation.constraints.Email;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Getter
@Entity
@Table(name="user") //db테이블 매핑
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(length = 45, nullable = false) //VARCHAR(20)
    private String userID;

    @Column(length = 45, nullable = false) //VARCHAR(45)
    private String userPassword;

    @Column(length = 20, nullable = false) //VARCHAR(45)
    private String userName;

    //@NotBlank(message = "이메일은 필수 입력값입니다.")
    //@Pattern(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}",message = "올바르지 않은 이메일 형식입니다.")
    @Column(length = 45, nullable = false) //VARCHAR(45)
    private String userEmail;

    @Column(length = 45, nullable = false) //VARCHAR(45)
    private String userTel;

    @Builder
    public User(String userID, String userPassword, String userName, String userEmail, String userTel) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userTel = userTel;
    }
}
