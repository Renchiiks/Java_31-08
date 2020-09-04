package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
    private String name;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String name, int numRow, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRow - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }

    }

    public String getName() {
        return name;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println(" There is no seat: " + seatNumber);
            return false;
        }
//BinarySearch->
//        int low = 0;
//        int high = seats.size() - 1;
//
//        while (low <= high) {
//            System.out.println(".");
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat "+ seatNumber);
//        return false;

// Search item by item->
//        for (Seat seat : seats) {
//            if (seatNumber.equals(seat.getSeatNumber())) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("There is no such seat with number " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
        ;
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reservedSeat = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {

            if (!this.reservedSeat) {
                this.reservedSeat = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }

        }

        public boolean cancel() {
            if (this.reservedSeat) {
                this.reservedSeat = false;
                System.out.println("Reservation of seat " + seatNumber + "is canceled");
                return true;
            } else {
                System.out.println("There is no reservation for this seat");
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareTo(seat.getSeatNumber());
        }
    }
}
