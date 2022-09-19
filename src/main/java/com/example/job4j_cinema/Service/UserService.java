package com.example.job4j_cinema.Service;

import com.example.job4j_cinema.Model.User;
import com.example.job4j_cinema.Persistence.UserDBPersistence;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class UserService {
    private final UserDBPersistence userDBStore;

    public UserService(UserDBPersistence userDBStore) {
        this.userDBStore = userDBStore;
    }

    public Optional<User> add(User user) {
        return this.userDBStore.add(user);
    }

    public List<User> findAll() {
        return this.userDBStore.findAll();
    }

    public Optional<User> findUserByEmailAndPassword(String email) {
        return this.userDBStore.findUserByEmail(email);
    }
}
