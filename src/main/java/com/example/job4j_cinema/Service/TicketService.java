package com.example.job4j_cinema.Service;

import com.example.job4j_cinema.Model.Ticket;
import com.example.job4j_cinema.Persistence.TicketDBPersistence;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class TicketService {
    private final TicketDBPersistence ticket;

    public TicketService(TicketDBPersistence ticket) {
        this.ticket = ticket;
    }

    public Optional<Ticket> create(Ticket ticket) {
        return this.ticket.create(ticket);
    }

    public Optional<Ticket> findById(int row, int cell, int idSess, int idUser) {
        return this.ticket.findById(row, cell, idSess, idUser);
    }

    public List<Ticket> findByIdUserAndIdSess(int userId, int sessId) {
        return this.ticket.findByIdUserAndIdSession(userId, sessId);
    }

    public boolean update(Ticket ticket) {
        return this.ticket.update(ticket);
    }

    public boolean delete(Ticket ticket) {
        return this.ticket.delete(ticket);
    }

    public TicketDBPersistence findSession(int id, int userId) {
        return ticket;
    }
}
