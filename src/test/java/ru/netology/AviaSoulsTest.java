package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("F.Kennedy", "NY LaGuardia", 1_000, 11_30, 11_45);//15 min
    Ticket ticket2 = new Ticket("F.Kennedy", "NY LaGuardia", 1_500, 11_30, 12_05);//35 min
    Ticket ticket3 = new Ticket("F.Kennedy", "NY LaGuardia", 1_000, 11_30, 14_45);//195 min
    Ticket ticket4 = new Ticket("F.Kennedy", "NY LaGuardia", 3_000, 11_30, 14_45);//195 min
    Ticket ticket5 = new Ticket("F.Kennedy", "NY LaGuardia", 800, 11_30, 12_00);//30 min

    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @Test
    void testPriceCompareTo1() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPriceCompareTo2() {
        int expected = 1;
        int actual = ticket4.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPriceCompareTo3() {
        int expected = 0;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchTicketsInAscendingOrderPrice() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        Ticket[] expected = {ticket5, ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = souls.search("F.Kennedy", "NY LaGuardia");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testCompare1() {
        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCompare2() {
        int expected = 1;
        int actual = timeComparator.compare(ticket3, ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCompare3() {
        int expected = 0;
        int actual = timeComparator.compare(ticket3, ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchAndSortBy() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3, ticket4};
        Ticket[] actual = souls.searchAndSortBy("F.Kennedy", "NY LaGuardia", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
