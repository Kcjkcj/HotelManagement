package springboot.hotelmanagement.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import springboot.hotelmanagement.domain.entity.User;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class CheckUserIdValidator extends  AbstractVaildator<UserDTO>{
    private final UserRepository userRepository;

    @Override
    protected void doValidate(UserDTO dto,Errors errors)
    {
        if(userRepository.existsByUserID(dto.toEntity().getUserID()))
        {
            errors.rejectValue("username","아이디 중복 오류","이미 사용 중인 아이디 입니다.");
        }
    }

}
