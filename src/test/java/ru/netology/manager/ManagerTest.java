package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private TicketRepository ticketRepository = new TicketRepository();
    private Manager manager = new Manager(ticketRepository);
    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2269, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 2199, "VKO", "KZN", 95);
    private Ticket ticket4 = new Ticket(4, 2287, "VKO", "KZN", 95);
    private Ticket ticket5 = new Ticket(5, 5394, "DME", "OVB", 245);

    @BeforeEach
    public void setUp() {
        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);
        ticketRepository.save(ticket3);
        ticketRepository.save(ticket4);
        ticketRepository.save(ticket5);

    }

    @Test
    void shouldFindAll() {
        Ticket[] expected = {ticket3, ticket2, ticket4};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIndividualTicket() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("SVO", "KZN");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNotFindTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "TOF");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFrom() {
        Ticket[] expected = {ticket3, ticket2, ticket4};
        Ticket[] actual = manager.findFromTo("VKO", "");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTo() {
        Ticket[] expected = {ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = manager.findFromTo("", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNothing() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findFromTo("", "");
        assertArrayEquals(expected, actual);
    }
}


