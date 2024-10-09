package login.com.logindemoOauth20;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OAuth2User oauth2User) {
        if (oauth2User != null) {
            model.addAttribute("name", oauth2User.getAttribute("name"));
            model.addAttribute("email", oauth2User.getAttribute("email"));
            model.addAttribute("profilePicture", oauth2User.getAttribute("avatar_url"));
        }
        return "home";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/logout-success";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccess() {
        return "logout-success";
    }
}
