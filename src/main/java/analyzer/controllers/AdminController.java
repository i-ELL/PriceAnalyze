package analyzer.controllers;

import analyzer.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    /**
     * Страница пользователей
     *
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String users(
            Model model
    ) {
        model.addAttribute("users", adminService.getAllUsers());
        return "/admin/users";
    }

//
//    //Сортировка тестов по id
//    @GetMapping("/tests")
//    public String tests(
//            Model model
//    ) {
//        model.addAttribute("tests", adminService.getAllTests());
//        return "admin/tests";
//    }
//
//    @GetMapping("/tests/edit/{id}")
//    public String editProduct(
//            @PathVariable("id") int id,
//            Model model
//    ) {
//        model.addAttribute("test", adminService.getTestById(id));
//        return "admin/edit-test";
//    }
//
//    /**
//     * Редактирование теста
//     */
//    @PostMapping("/tests/edit")
//    public String editProductPost(
//            @ModelAttribute("test") Test test
//    ) {
//        adminService.saveTest(test);
//        return "redirect:/admin/tests?success";
//    }
//
//    /**
//     * Добавление теста
//     *
//     * @return
//     */
//    @GetMapping("/tests/add")
//    public String addTest(
//            Model model
//    ) {
//        model.addAttribute("test", new Test());
//        return "admin/add-test";
//    }
//
//    /**
//     * Добавление теста
//     *
//     * @return
//     */
//    @PostMapping("/tests/add")
//    public String addTestPost(
//            @ModelAttribute("test") Test test
//    ) {
//        adminService.saveTest(test);
//        return "redirect:/admin/tests?success";
//    }
//
//
//    @GetMapping("/questions")
//    public String questions(
//            Model model
//    ) {
//        model.addAttribute("questions", adminService.getAllQuestions());
//        return "admin/questions";
//    }
//
//    @GetMapping("/questions/edit/{id}")
//    public String editQuestion(
//            @PathVariable("id") int id,
//            Model model
//    ) {
//        model.addAttribute("question", adminService.getQuestionById(id));
//        return "admin/edit-question";
//    }
//
//    @PostMapping("/questions/edit")
//    public String editQuestionPost(
//            @ModelAttribute("question") Question question
//    ) {
//        adminService.saveQuestion(question);
//        return "redirect:/admin/questions?success";
//    }
//
//    /**
//     * Добавление теста
//     *
//     * @return
//     */
//    @GetMapping("/questions/add")
//    public String addQuestion(
//            Model model
//    ) {
//        model.addAttribute("question", new Question());
//        return "admin/add-question";
//    }
//
//    /**
//     * Добавление теста
//     *
//     * @return
//     */
//    @PostMapping("/questions/add")
//    public String addQuestionPost(
//            @ModelAttribute("question") Question question
//    ) {
//        adminService.saveQuestion(question);
//        return "redirect:/admin/questions?success";
//    }
//

}

