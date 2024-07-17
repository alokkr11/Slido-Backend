package com.crio.xlido.repositories.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.xlido.entities.User;
import com.crio.xlido.repositories.IUserRepository;

public class UserRepository implements IUserRepository {

    private final Map<String, User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository() {
        userMap = new HashMap<String, User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement), user.getEmail(), user.getPassword());
            userMap.put(u.getId(), u);
            return u;
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

}
