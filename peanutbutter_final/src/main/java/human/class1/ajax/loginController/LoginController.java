package human.class1.ajax.loginController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import human.class1.ajax.logindto.LoginDTO;
import human.class1.ajax.loginservice.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Admin 페이지로 이동
    @GetMapping("/admin")
    public ModelAndView adminPage() {
        return new ModelAndView("Admin"); // /WEB-INF/views/Admin.jsp로 이동
    }

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String loginPage() {
        return "login/login"; // /WEB-INF/login/login.jsp로 이동
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(
        @RequestParam("id") String id,
        @RequestParam("pw") String password,  // 여기서 password가 제대로 전달되는지 확인
        HttpSession session,
        RedirectAttributes redirectAttributes
    ) {
        // 로그로 입력된 패스워드 값 확인
        System.out.println("입력된 비밀번호: " + password);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(id);
        loginDTO.setPassword(password);  // 여기서 비밀번호가 null이 아닌지 확인

        LoginDTO resultDTO = loginService.loginCheck(loginDTO);

        if (resultDTO != null) {
            System.out.println("로그인 성공 resultDTO : " + resultDTO);
            session.setAttribute("loginDTO", resultDTO);
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid login credentials");
            return "redirect:/login";
        }
    }



    // 회원 가입 처리
    @PostMapping("/login/insert")
    public String insertUser(
        @RequestParam("ename") String ename,
        @RequestParam("id") String id,
        @RequestParam("password") String password,
        @RequestParam("phone_num") String phoneNum,
        @RequestParam("email") String email,
        RedirectAttributes redirectAttributes
    ) {
        // 중복 체크
        if (loginService.checkDuplicateId(id)) {
            redirectAttributes.addFlashAttribute("errorMessage", "이미 사용 중인 아이디입니다.");
            return "redirect:/login/insert";
        }
        if (loginService.checkDuplicatePhoneNum(phoneNum)) {
            redirectAttributes.addFlashAttribute("errorMessage", "이미 사용 중인 전화번호입니다.");
            return "redirect:/login/insert";
        }
        if (loginService.checkDuplicateEmail(email)) {
            redirectAttributes.addFlashAttribute("errorMessage", "이미 사용 중인 이메일입니다.");
            return "redirect:/login/insert";
        }

        String encodedPassword = passwordEncoder.encode(password);
        // 회원 정보 등록
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEname(ename);
        loginDTO.setId(id);
        loginDTO.setPassword(encodedPassword);
        loginDTO.setPhoneNum(phoneNum);
        loginDTO.setEmail(email);

        int result = loginService.insertUser(loginDTO);
        if (result > 0) {
        	redirectAttributes.addFlashAttribute("successMessage", "회원가입에 성공하였습니다.");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "회원가입에 실패했습니다.");
            return "redirect:/login/insert";
        }
    }

    // 아이디 중복 체크
    @GetMapping("/login/checkId")
    @ResponseBody
    public Map<String, Boolean> checkId(@RequestParam("id") String id) {
        boolean available = !loginService.checkDuplicateId(id); // 중복 여부 확인
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("available", available);
        return response;
    }

    // 전화번호 중복 체크
    @GetMapping("/login/checkPhoneNum")
    @ResponseBody
    public Map<String, Boolean> checkPhoneNum(@RequestParam("phone_num") String phoneNum) {
        boolean available = !loginService.checkDuplicatePhoneNum(phoneNum);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("available", available);
        return response;
    }

    // 이메일 중복 체크
    @GetMapping("/login/checkEmail")
    @ResponseBody
    public Map<String, Boolean> checkEmail(@RequestParam("email") String email) {
        boolean available = !loginService.checkDuplicateEmail(email);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("available", available);
        return response;
    }
}
