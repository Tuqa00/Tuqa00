/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchreservation;

/**
 *
 * @author pc
 */
public class Reservation {
    private int reservationIndex;
    private int ticketIndex;
    private int seatIndex;
    private boolean allowUser;

    public Reservation() {
    }

    public Reservation(int reservationIndex, int ticketIndex, int seatIndex, boolean allowUser) {
        this.reservationIndex = reservationIndex;
        this.ticketIndex = ticketIndex;
        this.seatIndex = seatIndex;
        this.allowUser = allowUser;
    }
    /**
     * @return the reservationIndex
     */
    public int getReservationIndex() {
        return reservationIndex;
    }

    /**
     * @param reservationIndex the reservationIndex to set
     */
    public void setReservationIndex(int reservationIndex) {
        this.reservationIndex = reservationIndex;
    }

    /**
     * @return the ticketIndex
     */
    public int getTicketIndex() {
        return ticketIndex;
    }

    /**
     * @param ticketIndex the ticketIndex to set
     */
    public void setTicketIndex(int ticketIndex) {
        this.ticketIndex = ticketIndex;
    }

    /**
     * @return the seatIndex
     */
    public int getSeatIndex() {
        return seatIndex;
    }

    /**
     * @param seatIndex the seatIndex to set
     */
    public void setSeatIndex(int seatIndex) {
        this.seatIndex = seatIndex;
    }

    /**
     * @return the allowUser
     */
    public boolean isAllowUser() {
        return allowUser;
    }

    /**
     * @param allowUser the allowUser to set
     */
    public void setAllowUser(boolean allowUser) {
        this.allowUser = allowUser;
    }
  
    
}
