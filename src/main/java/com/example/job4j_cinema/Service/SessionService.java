package com.example.job4j_cinema.Service;


import com.example.job4j_cinema.Model.Session;
import com.example.job4j_cinema.Persistence.SessionsDBPersistence;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class SessionService {
    private final SessionsDBPersistence bdSessions;

    public SessionService(SessionsDBPersistence bdSessions) {
        this.bdSessions = bdSessions;
    }

    public List<Session> findAll() {
        return this.bdSessions.findAll();
    }

    public Optional<Session> create(Session sessions) {
        return this.bdSessions.create(sessions);
    }

    public Optional<Session> findById(int id) {
        return this.bdSessions.findById(id);
    }

    public boolean update(Session sessions) {
        return this.bdSessions.update(sessions);
    }
}
/*Вычисление свободных мест для сеанса необходимо сделать в слое SessionService.
 Вычисления делаем по купленным билетам.

 */