package life.majd.asamena.service;


import life.majd.asamena.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String id);

    void deleteUser(String id);

    List<User> getUsers();


}
