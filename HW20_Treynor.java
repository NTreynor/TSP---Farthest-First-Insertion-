/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw20_treynor;

// Nicholas Treynor

// Nick Treynor
// HW #20
// May 14, 2017
/**
 *
 * @author Nicholas Treynor
 */
public class HW20_Treynor {

    /**
     * @param args the command line arguments
     */
   
    public static int startIndex = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++){
            startIndex = i;
            TourComputation compute = new TourComputation();
            compute.tourComputation(i);
        }
    }

}
