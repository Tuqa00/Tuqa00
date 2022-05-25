/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchreservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static matchreservation.MatchReservation.reader;

/**
 *
 * @author pc
 */
public class MatchUser {
    final static int price = 150;
    private int userIndex;
    private String name;
    private String password;
    private boolean isAdmin;
    private List<Ticket>UserTickets;
    public MatchUser() {
    }

    public MatchUser(int userInde, String name, String password, boolean isAdmin) {
        this.userIndex = userInde;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    /**
     * @return the userIndex
     */
    public int getUserIndex() {
        return userIndex;
    }

    /**
     * @param userIndex the userIndex to set
     */
    public void setUserIndex(int userIndex) {
        this.userIndex = userIndex;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the UserTickets
     */
    public List<Ticket> getUserTickets() {
        return UserTickets;
    }

    /**
     * @param UserTickets the UserTickets to set
     */
    public void setUserTickets(List<Ticket> UserTickets) {
        this.UserTickets = UserTickets;
    }
   
    public void reserveMatch(List<Ticket> AllTickets,MatchShows matchShows,Scanner reader,int matchIndex)
    {
        System.out.println("Please enter number of seats");
         int number = reader.nextInt();
                if (number > 0) {
                   System.out.println("Available seats are:");
                   matchShows.printAvailableSeats();
                   int[]reservedSeats=new int[number];
                   int i=0;
                   List<Seat>availableSeats=matchShows.getAvailable();
                   if(number>availableSeats.size())
                   {
                        System.out.println("No Available seats with this number");
                        return;
                   }
                   while(i<number)
                   {
                       boolean errorOccurs=true;
                       do
                       {
                        System.out.println("Please enter seat name:");
                        int indexSeat = reader.nextInt();
                        if(!isExsists(availableSeats,indexSeat))
                        {
                             System.out.println("Seat not exists");
                             
                        }
                        else
                        {
                             reservedSeats[i]=indexSeat;
                             errorOccurs=false;   
                        }
                       }while(errorOccurs);
                        i++;
                   }
                    for (int j = 0; j < availableSeats.size(); j++) {
                        for (int k = 0; k < reservedSeats.length; k++) {
                            if(reservedSeats[k]==availableSeats.get(j).getSeatIndex())
                            {
                            availableSeats.get(j).setIsAvaialble(false);
                            }
                        }
                    }
                     System.out.println("Total Payment is :" +number*price);
                     String ticketNumber=matchShows.getShowIndex()+"-"+AllTickets.size();
                     System.out.println("Ticket number is :" +ticketNumber);
                     System.out.println("Ticket Index is :" +AllTickets.size());
                     Ticket ticket=new Ticket(AllTickets.size(),ticketNumber , price,userIndex,matchIndex,matchShows.getShowIndex());
                   
                     List<Reservation> AllReservations=new ArrayList<>();
                      for (int k = 0; k < reservedSeats.length; k++) {
                           AllReservations.add(new Reservation(k, ticket.getTicketIndex(), reservedSeats[k], false));
                        }
                      ticket.AllReservations=AllReservations;
                      ticket.setPayment(number*price);
                     AllTickets.add(ticket);
                } else {
                    System.out.println("Invalid number");
                }
    }
    boolean isExsists(List<Seat>availableSeats,int indexSeat)
    {
        for (int i = 0; i < availableSeats.size(); i++) {
            if(indexSeat==availableSeats.get(i).getSeatIndex())
                return true;
        }
        return false;
    }
}
