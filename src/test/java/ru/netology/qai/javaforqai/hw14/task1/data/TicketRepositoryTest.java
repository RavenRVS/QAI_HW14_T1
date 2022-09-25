package ru.netology.qai.javaforqai.hw14.task1.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qai.javaforqai.hw14.task1.services.AlreadyExistsException;
import ru.netology.qai.javaforqai.hw14.task1.services.NotFoundException;
import ru.netology.qai.javaforqai.hw14.task1.services.TicketManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 20000, "MOW","LED", 100);
    Ticket ticket2 = new Ticket(2, 12000, "MOW","LED", 120);
    Ticket ticket3 = new Ticket(3, 14000, "MOW","LED", 125);
    Ticket ticket4 = new Ticket(4, 12000, "MOW","LED", 150);
    Ticket ticket5 = new Ticket(5, 18000, "MOW","LED", 120);
    Ticket ticket6 = new Ticket(6, 15000, "LED","MOW", 120);
    Ticket ticket7 = new Ticket(7, 13000, "LED","MOW", 120);
    Ticket ticket8 = new Ticket(8, 16000, "MOW","KUF", 125);
    Ticket ticket9 = new Ticket(9, 16000, "MOW","EGO", 120);
    Ticket ticket10 = new Ticket(10, 13000, "LED","EGO", 120);
    Ticket ticket11 = new Ticket(11, 12000, "KUF","EGO", 220);

    @BeforeEach
    public void setup() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);
        repo.add(ticket10);
    }

    @Test
    void getAll() {

        Ticket[] expected = {ticket1,ticket2,ticket3,ticket4,ticket5,ticket6,ticket7,ticket8,ticket9,ticket10};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {

        Ticket expected = ticket3;
        Ticket actual = repo.findById(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByIdMissingTicket() {

        Ticket expected = null;
        Ticket actual = repo.findById(ticket11);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTicketWithRepeatId() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(ticket2);;
        });
    }

    @Test
    void remove() {
        repo.remove(ticket3);

        Ticket[] expected = {ticket1,ticket2,ticket4,ticket5,ticket6,ticket7,ticket8,ticket9,ticket10};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeMissingTicket() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(ticket11);;
        });
    }
}