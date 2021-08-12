package life.majd.asamena.service;

import life.majd.asamena.domain.User;
import life.majd.asamena.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("{} {} has been saved in the DB", user.getFirstname(), user.getLastname());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            log.info("{} {} has been deleted", user.getFirstname(), user.getLastname());
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
