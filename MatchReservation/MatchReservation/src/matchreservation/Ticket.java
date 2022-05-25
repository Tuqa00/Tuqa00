/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchreservation;

import java.util.List;

/**
 *
 * @author pc
 */
public class Ticket {
    private int ticketIndex;
    private String TicketNumber;
    private int payment;
     private int userId;
     private int matchIndex;
     private int showIndex;
    public List<Reservation> AllReservations;
    public Ticket() {
    }

    public Ticket(int ticketIndex, String TicketNumber, int payment,int userId,int matchIndex,int showIndex) {
        this.ticketIndex = ticketIndex;
        this.TicketNumber = TicketNumber;
        this.payment = payment;
        this.userId=userId;
        this.matchIndex=matchIndex;
        this.showIndex=showIndex;
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
     * @return the TicketNumber
     */
    public String getTicketNumber() {
        return TicketNumber;
    }

    /**
     * @param TicketNumber the TicketNumber to set
     */
    public void setTicketNumber(String TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    /**
     * @return the payment
     */
    public int getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the matchIndex
     */
    public int getMatchIndex() {
        return matchIndex;
    }

    /**
     * @param matchIndex the matchIndex to set
     */
    public void setMatchIndex(int matchIndex) {
        this.matchIndex = matchIndex;
    }

    /**
     * @return the showIndex
     */
    public int getShowIndex() {
        return showIndex;
    }

    /**
     * @param showIndex the showIndex to set
     */
    public void setShowIndex(int showIndex) {
        this.showIndex = showIndex;
    }
    
     public void print()
   {
       System.out.println("Ticket Index: "+getTicketIndex()+" Ticket Number: "+TicketNumber
       +" Price:" +payment
       );
        System.out.println("Ticket Seats: ");
      
   }
}
