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
public class Seat {
    private int seatIndex;
    private String seatName;
    private boolean isAvaialble=true;

    public Seat() {
    }

    public Seat(int seatIndex, String seatName, boolean isAvaialble) {
        this.seatIndex = seatIndex;
        this.seatName = seatName;
        this.isAvaialble = isAvaialble;
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
     * @return the seatName
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * @param seatName the seatName to set
     */
    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    /**
     * @return the isAvaialble
     */
    public boolean isIsAvaialble() {
        return isAvaialble;
    }

    /**
     * @param isAvaialble the isAvaialble to set
     */
    public void setIsAvaialble(boolean isAvaialble) {
        this.isAvaialble = isAvaialble;
    } 
      public void print()
   {
       if(isAvaialble)
       System.out.println("-Seat index: "+seatIndex +" name: "+seatName +" Available");
       else
           System.out.println("-Seat index: "+seatIndex +" name: "+seatName +" Reserved");
   }
}
