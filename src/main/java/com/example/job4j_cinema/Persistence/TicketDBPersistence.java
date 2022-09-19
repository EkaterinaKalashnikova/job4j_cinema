package com.example.job4j_cinema.Persistence;

import com.example.job4j_cinema.Model.Ticket;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketDBPersistence {
    private static final Logger LOG = LoggerFactory.getLogger(TicketDBPersistence.class.getName());
    private final BasicDataSource pool;

    public TicketDBPersistence(BasicDataSource pool) {
        this.pool = pool;
    }

    public Optional<Ticket> create(Ticket ticket) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("INSERT INTO ticket(sessId, posRow, cell, userId)  VALUES (?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, ticket.getSessId());
            ps.setInt(2, ticket.getPosRow());
            ps.setInt(3, ticket.getCell());
            ps.setInt(4, ticket.getUserId());
            ps.execute();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    ticket.setId(id.getInt(1));
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

        public Optional<Ticket> findById ( int posRow, int cell, int sessId, int userId){
            try (Connection cn = this.pool.getConnection();
                 PreparedStatement ps = cn.prepareStatement(
                         "SELECT * FROM ticket WHERE posRow = ? and cell = ? and sessId = ? and userid = ?")) {
                ps.setInt(1, posRow);
                ps.setInt(2, cell);
                ps.setInt(3, sessId);
                ps.setInt(4, userId);
                try (ResultSet it = ps.executeQuery()) {
                    if (it.next()) {
                        return null;
                    }
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            return Optional.empty();
        }

        public List<Ticket> findByIdUserAndIdSession ( int userId, int sessId){
            List<Ticket> tickets = new ArrayList<>();
            try (Connection cn = this.pool.getConnection();
                 PreparedStatement ps = cn.prepareStatement("SELECT * FROM ticket WHERE userId = ? and sessId = ? and condition = false")) {
                ps.setInt(1, userId);
                ps.setInt(2, sessId);
                try (ResultSet it = ps.executeQuery()) {
                    while (it.next()) {
                        tickets.add((Ticket) it);
                    }
                }
            } catch (Exception eo) {
                LOG.error(eo.getMessage(), eo);
            }
            return tickets;
        }

        public boolean update (Ticket ticket){
            return true;
        }

        public boolean delete (Ticket ticket){
            return true;
        }
    }
