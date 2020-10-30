package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    private TicketRepository ticketRepository = new TicketRepository();
    private Manager manager = new Manager(ticketRepository);
    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2269, "VKO", "KZN", 115);
    private Ticket ticket3 = new Ticket(3, 2199, "VKO", "KZN", 105);
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
        Ticket[] expected = {ticket4, ticket3, ticket2};
        Ticket[] actual = manager.findAll("VKO", "KZN", new TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIndividualTicketQuick() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("SVO", "KZN", new TicketComparator());
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNotFindTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "TOF", new TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFrom() {
        Ticket[] expected = {ticket4, ticket3, ticket2};
        Ticket[] actual = manager.findFromTo("VKO", "", new TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTo() {
        Ticket[] expected = {ticket1, ticket4, ticket3, ticket2};
        Ticket[] actual = manager.findFromTo("", "KZN", new TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFind() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findFromTo("", "", new TicketComparator());
        assertArrayEquals(expected, actual);
    }
}