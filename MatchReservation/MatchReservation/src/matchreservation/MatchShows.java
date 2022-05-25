/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchreservation;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class MatchShows {
    private int showIndex;
    private String date;
    private String time;
    private List<Seat> showSeats;

    public MatchShows() {
    }

    public MatchShows(int showIndex, String date, String time, List<Seat> showSeats) {
        this.showIndex = showIndex;
        this.date = date;
        this.time = time;
        this.showSeats = showSeats;
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

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the showSeats
     */
    public List<Seat> getShowSeats() {
        return showSeats;
    }

    /**
     * @param showSeats the showSeats to set
     */
    public void setShowSeats(List<Seat> showSeats) {
        this.showSeats = showSeats;
    }
    public void print()
   {
       System.out.println("-Show Index: "+showIndex +" in: "+date +" at " +time);
   }
     public void printAvailableSeats()
   {
       List<Seat> availableSeats=getAvailable();
       for (int i = 0; i < availableSeats.size(); i++) {
           availableSeats.get(i).print();
       }
   }
   public List<Seat>  getAvailable()
   {
       List<Seat> availableSeats=new ArrayList<>();
       for (int i = 0; i < showSeats.size(); i++) {
           if(showSeats.get(i).isIsAvaialble())
           {
               availableSeats.add(showSeats.get(i));
           }
       }
       return availableSeats;
   }
   public List<Seat>  getReservedAvailable()
   {
       List<Seat> availableSeats=new ArrayList<>();
       for (int i = 0; i < showSeats.size(); i++) {
           if(!showSeats.get(i).isIsAvaialble())
           {
               availableSeats.add(showSeats.get(i));
           }
       }
       return availableSeats;
   }
   
}
