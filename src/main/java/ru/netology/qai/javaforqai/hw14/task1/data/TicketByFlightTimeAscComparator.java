package ru.netology.qai.javaforqai.hw14.task1.data;

import java.util.Comparator;

public class TicketByFlightTimeAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
