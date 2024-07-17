package com.crio.xlido.services.Implementation;

import java.util.List;
import com.crio.xlido.entities.User;
import com.crio.xlido.exceptions.UserException;
import com.crio.xlido.repositories.IUserRepository;
import com.crio.xlido.services.IUserService;

public class UserService implements IUserService {

    public final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String email, String password) {

        List<User> users = userRepository.findAll();

        for (User u : users) {
            if (u.getEmail().equals(email)) {
                throw new UserException("User with this email already exists");
            }
        }

        return userRepository.save(new User(email, password));
    }

}
