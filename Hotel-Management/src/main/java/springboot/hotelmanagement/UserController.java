package springboot.hotelmanagement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springboot.hotelmanagement.DTO.UserDTO;
import springboot.hotelmanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import springboot.hotelmanagement.validator.CheckUserIdValidator;

import java.util.HashMap;
import java.util.List;
@Configuration

//@RestController
@Controller

public class UserController {
    private final CheckUserIdValidator checkUserIdValidator;
    private UserService userService;
    private final Logger log = LoggerFactory.getLogger(getClass());
    public UserController(CheckUserIdValidator checkUserIdValidator, UserService userService) {
        this.checkUserIdValidator = checkUserIdValidator;
        this.userService = userService;
    }
    @InitBinder
    public void validatorBinder(WebDataBinder binder)
    {
        binder.addValidators(checkUserIdValidator);
    }
    @GetMapping("/")
    public String list(Model model)
    {
        List<UserDTO> userDTOList = userService.getUserList();
        System.out.print(userDTOList);
        model.addAttribute("postList",userDTOList);
        return "user/main.html";
    }
    @GetMapping("/login")
    public boolean loginForm()
    {
       return true;
    }
    @ResponseBody
    @PostMapping("/login")
    public boolean login(@RequestBody HashMap<String, Object>map, HttpServletRequest request)
    {
        UserDTO loginDTO = new UserDTO();
        loginDTO.setUserID((String)map.get("userID"));
        loginDTO.setUserPassword((String)map.get("userPassword"));
        loginDTO.setUserName("");
        loginDTO.setUserEmail("");
        loginDTO.setUserTel("");
        System.out.print(map);
        UserDTO loginResult = userService.login(loginDTO);
        if(loginResult!=null) {
            HttpSession httpSession;
            httpSession = request.getSession();
            httpSession.setAttribute("loginID", loginResult.getUserID());
            return true;
        }
        else {
            System.out.println("로그인 실패");
            return false;
        }
    }
    @GetMapping("/logout")
    public boolean logout()
    {
        return true;
    }


    @ResponseBody
    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request, HttpSession httpSession)
    {

        if(httpSession !=null)
        {
            httpSession.invalidate(); //세션 삭제
            httpSession = request.getSession(false);
        }
        if(httpSession !=null)
        {
            return false;
        }
        System.out.println("로그아웃 성공");
        return true;

    }

    @GetMapping("/join")
        public boolean Join(){
            return true;
    }

    @ResponseBody
    @PostMapping("/join")
    public boolean join(@RequestBody HashMap<String, Object>map) throws BadRequestException {
        UserDTO loginDTO = new UserDTO();
        loginDTO.setUserID((String)map.get("userID"));
        loginDTO.setUserPassword((String)map.get("userPassword"));
        loginDTO.setUserName((String)map.get("userName"));
        loginDTO.setUserEmail((String)map.get("userEmail"));
        loginDTO.setUserTel((String)map.get("userTel"));
        System.out.print(map);
        System.out.println((loginDTO.getUserID()));

        if(userService.existsByUserId((loginDTO.getUserID())) || loginDTO.getUserID().isEmpty())
        {
            System.out.println("중복된 아이디 혹은 아이디 입력안 함");
            return false;
        }
        else
        {
            userService.saveUser(loginDTO);
            return true;
        }


    }

}
