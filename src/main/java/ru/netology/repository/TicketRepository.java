package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.NoSuchElementException;

public class TicketRepository {
    private Ticket[] list = new Ticket[0];

    public void save(Ticket ticket) {
        int length = list.length + 1;
        Ticket[] addTicket = new Ticket[length];
        for (int i = 0; i < list.length; i++) {
            addTicket[i] = list[i];
        }
        int lastIndex = addTicket.length - 1;
        addTicket[lastIndex] = ticket;
        list = addTicket;
    }

    public Ticket[] getAll() {
        return list;
    }

    public Ticket findById(int id) {
        for (Ticket item : list) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NoSuchElementException();
        }
        int length = list.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : list) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        list = tmp;
    }
}