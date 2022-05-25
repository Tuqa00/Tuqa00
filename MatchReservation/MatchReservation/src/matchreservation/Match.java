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
public class Match {
    private int matchIndex;
    private String matchName;
    
    public Match() {
    }

    public Match(int matchIndex, String matchName) {
        this.matchIndex = matchIndex;
        this.matchName = matchName;
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
     * @return the matchName
     */
    public String getMatchName() {
        return matchName;
    }

    /**
     * @param matchName the matchName to set
     */
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }
   public void print()
   {
       System.out.println("Index: "+matchIndex +" Name: "+matchName);
   }
    
}
