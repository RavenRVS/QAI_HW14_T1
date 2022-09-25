package ru.netology.qai.javaforqai.hw14.task1.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.qai.javaforqai.hw14.task1.data.Ticket;
import ru.netology.qai.javaforqai.hw14.task1.data.TicketByFlightTimeAscComparator;
import ru.netology.qai.javaforqai.hw14.task1.data.TicketRepository;

import static org.mockito.Mockito.doReturn;

class TicketManagerTest {
    TicketRepository repo = Mockito.mock(TicketRepository.class);
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 20000, "MOW","LED", 100);
    Ticket ticket2 = new Ticket(2, 12000, "MOW","LED", 120);
    Ticket ticket3 = new Ticket(3, 14000, "MOW","LED", 150);
    Ticket ticket4 = new Ticket(4, 12000, "MOW","LED", 125);
    Ticket ticket5 = new Ticket(5, 18000, "MOW","LED", 110);
    Ticket ticket6 = new Ticket(6, 15000, "LED","MOW", 120);
    Ticket ticket7 = new Ticket(7, 13000, "LED","MOW", 120);
    Ticket ticket8 = new Ticket(8, 16000, "MOW","KUF", 125);
    Ticket ticket9 = new Ticket(9, 16000, "MOW","EGO", 120);
    Ticket ticket10 = new Ticket(10, 13000, "LED","EGO", 120);
    Ticket ticket11 = new Ticket(11, 12000, "KUF","EGO", 220);

    @BeforeEach
    public void setup() {
        Ticket[] items = { ticket1,ticket2,ticket3,ticket4,ticket5,ticket6,ticket7,ticket8,ticket9,ticket10 };
        doReturn(items).when(repo).getAll();
    }

    @Test
    void findAll() {

        Ticket[] expected = {ticket2,ticket4,ticket3,ticket5,ticket1};
        Ticket[] actual = manager.findAll("MOW", "LED");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    void findAllWithMissingAirportArrival() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MOW", "ADL");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    void findAllWithMissingAirportDeparture() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ADL", "LED");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    void findAllWithMissingAirportDepartureAndArrival() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ADL", "GOV");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void findAllWithComparator() {

        TicketByFlightTimeAscComparator comparator = new TicketByFlightTimeAscComparator();
        Ticket[] expected = {ticket1,ticket5,ticket2,ticket4,ticket3};
        Ticket[] actual = manager.findAll("MOW", "LED", comparator);

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void add() {

        manager.add(ticket11);

        Ticket[] expected = { ticket1,ticket2,ticket3,ticket4,ticket5,ticket6,ticket7,ticket8,ticket9,ticket10,ticket11 };;
        Ticket[] actual = manager.findAll("KUF","EGO");
    }
}