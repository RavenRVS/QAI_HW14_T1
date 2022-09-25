package ru.netology.qai.javaforqai.hw14.task1.data;

import ru.netology.qai.javaforqai.hw14.task1.services.AlreadyExistsException;
import ru.netology.qai.javaforqai.hw14.task1.services.NotFoundException;

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public TicketRepository() {}

    public Ticket[] getAll() {
        return tickets;
    }

    public void add(Ticket ticket) {
        if (findById(ticket) != null) {
            throw new AlreadyExistsException("Element with id: " + ticket.getId() + " is already in the repository");
        } else {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            for (int i = 0; i < tickets.length; i++) {
                tmp[i] = tickets[i];
            }
            tmp[tmp.length - 1] = ticket;
            tickets = tmp;
        }
    }

    public void remove(Ticket ticket) {
        if (findById(ticket) == null) {
            throw new NotFoundException("Element with id: " + ticket.id + " not found");
        } else {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket item : tickets) {
                if (item.getId() != ticket.id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            tickets = tmp;
        }
    }

    public Ticket findById(Ticket ticket) {
        for (Ticket item : tickets) {
            if (item.getId() == ticket.id) {
                return item;
            }
        }
        return null;
    }
}
