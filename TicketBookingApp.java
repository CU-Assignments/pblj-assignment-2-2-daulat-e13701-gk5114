class TicketBookingSystem {
    private final boolean[] seats;

    public TicketBookingSystem(int numSeats) {
        seats = new boolean[numSeats]; 
    }

    public synchronized void bookTicket(String customerType, int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println(customerType + " tried to book an invalid seat: " + (seatNumber + 1));
            return;
        }
        if (!seats[seatNumber]) {
            seats[seatNumber] = true;
            System.out.println(customerType + " successfully booked seat " + (seatNumber + 1));
        } else {
            System.out.println(customerType + " failed to book seat " + (seatNumber + 1) + " (already taken)");
        }
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final String customerType;
    private final int seatNumber;

    public BookingThread(TicketBookingSystem system, String customerType, int seatNumber, int priority) {
        this.bookingSystem = system;
        this.customerType = customerType;
        this.seatNumber = seatNumber;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(customerType, seatNumber);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem ticketSystem = new TicketBookingSystem(5);

        // Create booking threads
        BookingThread vip1 = new BookingThread(ticketSystem, "VIP Customer", 0, Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(ticketSystem, "VIP Customer", 1, Thread.MAX_PRIORITY);
        
        BookingThread regular1 = new BookingThread(ticketSystem, "Regular Customer", 1, Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(ticketSystem, "Regular Customer", 2, Thread.NORM_PRIORITY);
        BookingThread regular3 = new BookingThread(ticketSystem, "Regular Customer", 3, Thread.NORM_PRIORITY);
        BookingThread regular4 = new BookingThread(ticketSystem, "Regular Customer", 4, Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
        regular4.start();
        try {
            vip1.join();
            vip2.join();
            regular1.join();
            regular2.join();
            regular3.join();
            regular4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All bookings completed.");
    }
}
