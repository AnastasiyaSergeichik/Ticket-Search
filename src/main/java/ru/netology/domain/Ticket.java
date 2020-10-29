package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int travelTime;

    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }
}
