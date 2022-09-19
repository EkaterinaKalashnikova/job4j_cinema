package com.example.job4j_cinema.Model;

import java.util.Objects;

public class Ticket {
    private int id;
    private int sessId;
    private int posRow;
    private int cell;
    private int userId;

    public Ticket(int id, int sessId, int posRow, int cell, int userId) {
        this.id = id;
        this.sessId = sessId;
        this.posRow = posRow;
        this.cell = cell;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessId() {
        return sessId;
    }

    public void setSessId(int sessId) {
        this.sessId = sessId;
    }

    public int getPosRow() {
        return posRow;
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ticket)) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
