package com.crio.xlido.repositories;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.entities.User;

public interface IUserRepository {

    public User save(User user);

    public List<User> findAll();

    public Optional<User> findById(String id);

}
