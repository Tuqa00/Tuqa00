/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchreservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class MatchReservation {

    final static int SizeMatches = 3;
    final static int SizeShows = 2;
    final static int NumberSeats = 10;
    static Match[] AllMatchs;
    static MatchShows[][] AllMatchsShows;
    static List<Ticket> AllTickets;

    static List<MatchUser> AllUsers;

    static Scanner reader = new Scanner(System.in);
    static String WELCOMEMSG = "\n.............WELCOME TO Match Reservation PROGRAM.............\n"
            + "enter your Choice"
            + "\n 1: login as User"
            + "\n 2: login as Admin "
            + "\n 3: Match Organizers "
            + "\n 4: exit program?";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitializeMatchs();
        AllTickets = new ArrayList<>();
        AllUsers = new ArrayList<>();
        // TODO code application logic here
        boolean end = false;
        do {
            System.out.println(WELCOMEMSG);
            String c = reader.next().toLowerCase();
            switch (c) {
                case "1": {
                    UserMenu();
                    break;
                }
                case "2": {
                    AdminLogin();
                    break;
                }
                case "3": {
                    OrganizersOptions();
                    break;
                }
                case "4": {
                    end = true;
                    break;
                }
            }

        } while (!end);
    }

    static void InitializeMatchs() {
        AllMatchs = new Match[SizeMatches];
        int index = 0;
        AllMatchs[index] = new Match(index, "Al-Fayha VS Al-Batin");
        index++;
        AllMatchs[index] = new Match(index, "Al-Ettifaq VS Al-Nassr");
        index++;
        AllMatchs[index] = new Match(index, "Al-Fayha VS Al-Nassr");
        // after added 3 matches 
        //we will add matches Shows
        AllMatchsShows = new MatchShows[SizeMatches][];
        int row = 0;
        int col = 0;
        AllMatchsShows[row] = new MatchShows[SizeShows];
        AllMatchsShows[row][col] = new MatchShows(col, "1-4-2022", "10:00 AM", generateShowSeats());
        col++;
        AllMatchsShows[row][col] = new MatchShows(col, "2-4-2022", "12:00 AM", generateShowSeats());
        row++;
        col = 0;
        AllMatchsShows[row] = new MatchShows[SizeShows];
        //assign new match shows
        AllMatchsShows[row][col] = new MatchShows(col, "1-4-2022", "10:00 AM", generateShowSeats());
        col++;
        AllMatchsShows[row][col] = new MatchShows(col, "2-4-2022", "12:00 AM", generateShowSeats());
        row++;
        col = 0;
        AllMatchsShows[row] = new MatchShows[SizeShows];
        //assign new match shows
        AllMatchsShows[row][col] = new MatchShows(col, "1-4-2022", "10:00 AM", generateShowSeats());
        col++;
        AllMatchsShows[row][col] = new MatchShows(col, "2-4-2022", "12:00 AM", generateShowSeats());
    }

    static List<Seat> generateShowSeats() {
        List<Seat> seats = new ArrayList<Seat>();
        int index = 0;
        for (int i = 0; i < NumberSeats; i++) {
            Seat s = new Seat(i, String.valueOf(i + 1), true);
            seats.add(s);
        }
        return seats;
    }

    static void UserMenu() {

        int choice = 1;
        String Main_Menu = "\n.............User Menu.............\n"
                + "1-View Matchs\n"
                + "2-Register \n"
                + "3-Reserve Match \n"
                + "4-Show Reserved Match \n"
                + "5-enter match\n"
                + "6-Return to Home Menu \n"
                + "Your option : ";
        while (choice != 6) {
            System.out.println(Main_Menu);
            choice = reader.nextInt();
            switch (choice) {
                case 1: {
                    ViewMatchs();
                    break;
                }
                case 2: {
                    Register();
                    break;
                }
                case 3: {
                    ReserveMatch();
                    break;
                }
                case 4: {
                    ShowReserveMatch();
                    break;
                }
                case 5: {
                    EnterMatch();
                    break;
                }
                case 6: {
                    break;
                }
            }
        }
    }

    static void AdminMenu() {
        int choice = 1;
        String Main_Menu = "\n.............Admin Menu.............\n"
                + "1-View Matchs\n"
                + "2-Reservations \n"
                + "3-Show Ticket Seats \n"
                + "4-Show Match Details \n"
                + "5-enter user to match\n"
                + "6-Return to Home Menu \n"
                + "Your option : ";
        while (choice != 6) {
            System.out.println(Main_Menu);
            choice = reader.nextInt();
            switch (choice) {
                case 1: {
                    ViewMatchs();
                    break;
                }
                case 2: {
                    Reservations();
                    break;
                }
                case 3: {
                    TicketSeats();
                    break;
                }
                case 4: {
                    ShowMatchDetails();
                    break;
                }
                case 5: {
                    AllowUser();
                    break;
                }
                case 6: {
                    break;
                }
            }
        }
    }

    static void Register() {
        System.out.println("create account ");
        System.out.println("enter Name ");
        String Name = reader.next();
        System.out.println("enter password ");
        String password = reader.next();
        boolean isExists = false;
        for (int i = 0; i < AllUsers.size(); i++) {
            if (Name.equals(AllUsers.get(i).getName()) && password.equals(AllUsers.get(i).getPassword())) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            int index = AllUsers.size();
            System.out.println("new user created with user index: " + index);
            AllUsers.add(new MatchUser(index, Name, password, false));
        } else {
            System.out.println("User exists");
        }
    }

    static void AdminLogin() {
        System.out.println("LOGIN ");
        System.out.println("enter user name");
        String userName = reader.next();
        System.out.println("enter password");
        String password = reader.next();
        if (validate(userName, password)) {
            AdminMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    static boolean validate(String userName, String password) {
        if (userName.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    static MatchUser getUser() {
        MatchUser matchUser = null;
        System.out.println("Please enter User Index");
        int index = reader.nextInt();
        if (index < AllUsers.size() && index >= 0) {
            matchUser = AllUsers.get(index);
        } else {
            System.out.println("Invalid User Index");
        }
        return matchUser;
    }

    static void ViewMatchs() {
        for (int i = 0; i < SizeMatches; i++) {
            AllMatchs[i].print();
            System.out.println("-------------------------------------------");
            for (int j = 0; j < SizeShows; j++) {

                AllMatchsShows[i][j].print();
            }
            System.out.println("-------------------------------------------");
        }
    }

    static void ReserveMatch() {
        MatchUser user = null;
        user = getUser();
        if (user != null) {
            System.out.println("Please enter Match Index");
            int index = reader.nextInt();
            if (index < AllMatchs.length && index >= 0) {
                System.out.println("Please enter Show Index");
                int showIndex = reader.nextInt();
                int rowcount = AllMatchsShows[index].length;
                if (showIndex < AllMatchsShows[index].length) {
                    user.reserveMatch(AllTickets, AllMatchsShows[index][showIndex], reader, index);
                } else {
                    System.out.println("Invalid Index");
                }
            } else {
                System.out.println("Invalid Index");
            }
        }
    }

    static void ShowReserveMatch() {
        MatchUser user = null;
        user = getUser();
        if (user != null) {
            for (int i = 0; i < AllTickets.size(); i++) {
                if (AllTickets.get(i).getUserId() == user.getUserIndex()) {
                    Match match = AllMatchs[AllTickets.get(i).getMatchIndex()];
                    match.print();
                    MatchShows matchShows = AllMatchsShows[AllTickets.get(i).getMatchIndex()][AllTickets.get(i).getShowIndex()];
                    System.out.println("Show Details:");
                    matchShows.print();
                    System.out.println("Ticket Information");
                    AllTickets.get(i).print();
                    for (int k = 0; k < AllTickets.get(i).AllReservations.size(); k++) {
                        matchShows.getShowSeats().get(AllTickets.get(i).AllReservations.get(k).getSeatIndex()).print();
                    }
                }
            }
        }
    }

    static void EnterMatch() {
        System.out.println("Please enter Ticket Index");
        int ticketIndex = reader.nextInt();
        if (ticketIndex < AllTickets.size() && ticketIndex >= 0) {
            Ticket ticket = AllTickets.get(ticketIndex);
            List<Seat> ReservedSeats = new ArrayList<>();
            for (int i = 0; i < AllTickets.get(ticketIndex).AllReservations.size(); i++) {
                Reservation reservation = AllTickets.get(ticketIndex).AllReservations.get(i);
                MatchShows show = AllMatchsShows[ticket.getMatchIndex()][ticket.getShowIndex()];
                Seat s = show.getShowSeats().get(reservation.getSeatIndex());
                System.out.println("\t-Ticket Seat index " + s.getSeatIndex() + " name: " + s.getSeatName());
                ReservedSeats.add(s);
            }

            if (ReservedSeats.size() > 0) {

                System.out.println("Please enter Seat Index");
                int seatIndex = reader.nextInt();
                boolean isExists = false;
                boolean allow = false;
                for (int k = 0; k < ReservedSeats.size(); k++) {
                    if (ReservedSeats.get(k).getSeatIndex() == seatIndex) {
                        if (AllTickets.get(ticketIndex).AllReservations.get(k).isAllowUser()) {
                            allow = true;
                        } else {
                            allow = false;
                        }

                        isExists = true;

                        break;
                    }
                }
                if (!isExists) {
                    System.out.println("Seat not exists");
                } else {
                    if(allow)
                    System.out.println("Welcome to match :)");
                    else
                    System.out.println("User not allowed to enter match please ask admin permission");
                }
            }
        }
         else {
                System.out.println("Invalid Index");
            }
    }

    static void Reservations() {
        if(AllTickets.size()==0)
        {
             System.out.println("No Tickets were found");
        }
        else
        {
        for (int i = 0; i < AllTickets.size(); i++) {
            System.out.println("Ticket index " + i + " Match " + AllMatchs[AllTickets.get(i).getMatchIndex()].getMatchName() + " "
                    + "NO: " + AllTickets.get(i).getTicketNumber()
                    + " Seats Number: " + AllTickets.get(i).AllReservations.size()
                    + " Total: " + AllTickets.get(i).getPayment()
            );
        }
        }
    }

    static void TicketSeats() {
        System.out.println("Please enter Ticket Index");
        int index = reader.nextInt();
        if (index < AllTickets.size() && index >= 0) {
            Ticket ticket = AllTickets.get(index);
            for (int i = 0; i < AllTickets.get(index).AllReservations.size(); i++) {
                Reservation reservation = AllTickets.get(index).AllReservations.get(i);
                MatchShows show = AllMatchsShows[ticket.getMatchIndex()][ticket.getShowIndex()];
                Seat s = show.getShowSeats().get(reservation.getSeatIndex());
                System.out.println("\t-Ticket Seat " + s.getSeatName());

            }

        } else {
            System.out.println("Invalid Ticket Index");
        }

    }

    static void ShowMatchDetails() {
        System.out.println("Please enter Match Index");
        int index = reader.nextInt();
        if (index < AllMatchs.length && index >= 0) {
            System.out.println("Please enter Show Index");
            int showIndex = reader.nextInt();
            int rowcount = AllMatchsShows[index].length;
            if (showIndex < AllMatchsShows[index].length) {
                MatchShows matchShows = AllMatchsShows[index][showIndex];
                List<Seat> availableSeats = matchShows.getAvailable();
                if (availableSeats.size() > 0) {
                    System.out.println("Available Seats:");
                    for (int i = 0; i < availableSeats.size(); i++) {
                        availableSeats.get(i).print();
                    }
                }
                List<Seat> ReservedSeats = matchShows.getReservedAvailable();
                if (ReservedSeats.size() > 0) {
                    System.out.println("Reserved Seats:");
                    for (int i = 0; i < ReservedSeats.size(); i++) {
                        ReservedSeats.get(i).print();
                    }
                }
            } else {
                System.out.println("Invalid Index");
            }
        } else {
            System.out.println("Invalid Index");
        }
    }

    static void AllowUser() {
        System.out.println("Please enter Match Index");
        int index = reader.nextInt();
        if (index < AllMatchs.length && index >= 0) {
            System.out.println("Please enter Show Index");
            int showIndex = reader.nextInt();
            int rowcount = AllMatchsShows[index].length;
            if (showIndex < AllMatchsShows[index].length) {
                MatchShows matchShows = AllMatchsShows[index][showIndex];
                System.out.println("Please enter Ticket Index");
                int ticketIndex = reader.nextInt();
                if (ticketIndex < AllTickets.size() && ticketIndex >= 0) {
                    Ticket ticket = AllTickets.get(ticketIndex);
                    List<Seat> ReservedSeats = new ArrayList<>();
                    for (int i = 0; i < AllTickets.get(ticketIndex).AllReservations.size(); i++) {
                        Reservation reservation = AllTickets.get(ticketIndex).AllReservations.get(i);
                        MatchShows show = AllMatchsShows[ticket.getMatchIndex()][ticket.getShowIndex()];
                        Seat s = show.getShowSeats().get(reservation.getSeatIndex());
                        System.out.println("\t-Ticket Seat index " + s.getSeatIndex() + " name: " + s.getSeatName());
                        ReservedSeats.add(s);
                    }

                    if (ReservedSeats.size() > 0) {

                        System.out.println("Please enter Seat Index");
                        int seatIndex = reader.nextInt();
                        boolean isExists = false;
                        for (int k = 0; k < ReservedSeats.size(); k++) {
                            if (ReservedSeats.get(k).getSeatIndex() == seatIndex) {
                                AllTickets.get(ticketIndex).AllReservations.get(k).setAllowUser(true);
                                System.out.println("User Allowed Successfully");
                                isExists = true;
                                break;
                            }
                        }
                        if (!isExists) {
                            System.out.println("Seat not exists");
                        }
                    } else {
                        System.out.println("No Reserved Seats");
                    }

                } else {
                    System.out.println("Invalid Ticket Index");
                    return;
                }

            } else {
                System.out.println("Invalid Index");
            }
        } else {
            System.out.println("Invalid Index");
        }
    }
   static void OrganizersOptions()
   {
     int choice = 1;
        String Main_Menu = "\n.............Organizers Menu.............\n"
                + "1-View Matchs\n"
                + "2-Reservations \n"
                + "3-Show Ticket Seats \n"
                + "4-Return to Home Menu \n"
                + "Your option : ";
        while (choice != 4) {
            System.out.println(Main_Menu);
            choice = reader.nextInt();
            switch (choice) {
                case 1: {
                    ViewMatchs();
                    break;
                }
                case 2: {
                    Reservations();
                    break;
                }
                case 3: {
                    TicketSeats();
                    break;
                }
                case 4: {
                    break;
                }
            }
        }
   }
}
