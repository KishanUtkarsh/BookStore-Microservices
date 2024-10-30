package com.appitude.users.Util;

import com.appitude.users.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class DatabaseUtils {

    private static UserRepository repository;

    public DatabaseUtils(UserRepository repository) {
        DatabaseUtils.repository = repository;
    }

    public static boolean checkIfUserExists(String username) {
        return repository.findById(username).isPresent();
    }
}
