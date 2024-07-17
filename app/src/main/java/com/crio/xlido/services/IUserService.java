package com.crio.xlido.services;

import com.crio.xlido.entities.User;

public interface IUserService {

    public User create(String email, String password);

}
