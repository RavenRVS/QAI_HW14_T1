package ru.netology.qai.javaforqai.hw14.task1.services;

import ru.netology.qai.javaforqai.hw14.task1.data.Ticket;
import ru.netology.qai.javaforqai.hw14.task1.data.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    TicketRepository repo = new TicketRepository();

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] searchingResults = new Ticket[0];
        for (Ticket item : repo.getAll()) {
            if (item.getAirportFrom() == from && item.getAirportTo() == to)  {
                Ticket[] tmp = new Ticket[searchingResults.length + 1];
                for (int i = 0; i < searchingResults.length; i++) {
                    tmp[i] = searchingResults[i];
                }
                tmp[tmp.length - 1] = item;
                Arrays.sort(tmp);
                searchingResults = tmp;
            }
        }
        return searchingResults;
    }
    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] searchingResults = findAll(from,to);
        Arrays.sort(searchingResults, comparator);
        return searchingResults;
    }

    public void add(Ticket ticket){
        repo.add(ticket);
    }
}
