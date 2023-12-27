package analyzer.controllers;

import analyzer.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private final AuthService authService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("isAuth", false);
        // Провряем, авторизован ли пользователь добавляя переменную isAuth
        model.addAttribute("isAuth", authService.getAuthUser().isPresent());

        // Если пользователь авторизован, то добавляем его в модель
        authService.getAuthUser().ifPresent(user -> model.addAttribute("user", user));
        return "index";
    }
}
