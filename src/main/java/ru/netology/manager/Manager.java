package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
public class Manager {
    private TicketRepository repository;

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] newList = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getAirportArrival().equals(to) && ticket.getAirportDeparture().equals(from)) {
                Ticket[] tmp = new Ticket[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = ticket;
                newList = tmp;
            }
        }
        Arrays.sort(newList, comparator);
        return newList;
    }
    public Ticket[] findFromTo(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] newList = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getAirportArrival().equals(to) || ticket.getAirportDeparture().equals(from)) {
                Ticket[] tmp = new Ticket[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = ticket;
                newList = tmp;
            }
        }
        Arrays.sort(newList, comparator);
        return newList;
    }
}