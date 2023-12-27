package analyzer.services;

import analyzer.domain.dto.UserRegisterDTO;
import analyzer.domain.models.User;
import analyzer.mapper.UserMapper;
import analyzer.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(User user) {
        userRepository.save(user);
    }


    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getById(int id) {
        return findById(id).orElseThrow();
    }




    public void register(UserRegisterDTO userRegisterDTO) {
        save(userMapper.registerDTOToUser(userRegisterDTO));
    }
}