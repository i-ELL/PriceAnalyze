package analyzer.services;

import analyzer.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserService userService;

//    private final UserMapper userMapper;

    /**
     * Получение всех пользователей
     */
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Получение пользователя по id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userService.getById(id);
    }
//
//
//    /**
//     * Получение всех Фильмов
//     *
//     * @return
//     */
//    public List<Comment> getAllTests() {
//        return testService.getAllTests();
//    }
//
//
//    /**
//     * Получение теста по id
//     *
//     * @param id
//     * @return
//     */
//    public Test getTestById(int id) {
//        return testService.getById(id);
//    }
//
//    /**
//     * Получение всех вопросов
//     *
//     * @return
//     */
//    public List<Question> getAllQuestions() {
//        return questionService.getAllQuestions();
//    }
//
//    /**
//     * Получение вопроса по id
//     *
//     * @param id
//     * @return
//     */
//
//    public Question getQuestionById(int id) {
//        return questionService.getById(id);
//    }
//
//    /**
//     * Сохранение теста
//     *
//     * @param test
//     */
//    @Transactional
//    public void saveTest(Test test) {
//        testService.save(test);
//    }
//
//    /**
//     * Сохранение вопроса
//     *
//     * @param question
//     */
//    @Transactional
//    public void saveQuestion(Question question) {
//        questionService.save(question);
//    }
}