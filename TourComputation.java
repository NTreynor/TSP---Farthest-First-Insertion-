/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw20_treynor;

import static hw20_treynor.EuropeanCapital.capitals;
//import static hw20_treynor.HW20_Treynor.startIndex;
/**
 *
 * @author Nicholas Treynor
 */
public class TourComputation {

    static int cities = 41;
    //static 
    static int startIndex = 12; // Edit this index to produce different tours
    static double currentTourLength = 0;
    static EuropeanCapital startLocation = capitals[1];
    // static EuropeanCapital[] currentRoute = new EuropeanCapital[cities];
    static int[] currentRouteInts = new int[cities];

    static EuropeanCapital[] remainingCities = new EuropeanCapital[capitals.length];

    static double[][] distanceMatrix;

    public static void main(String[] args) {
        
        for (int capitalIndex = 0; capitalIndex < capitals.length; capitalIndex++){
            remainingCities[capitalIndex] = capitals[capitalIndex];
        }
        
        
        
        
        // currentRoute[0] = capitals[startIndex]; //init
        currentRouteInts[0] = startIndex; //init 

        for (int z = 1; z < cities; z++) { //Fill index array with -1 to differentiate
            currentRouteInts[z] = -1;
        }

        computeDistanceMatrix();
        for (int i = 0; i < cities; i++) {
            for (int x = 0; x < cities; x++) {
                System.out.print(distanceMatrix[i][x] + " ");

            }
            System.out.println();
        }

        for (int x : currentRouteInts) {
            System.out.println("routeints: " + x);

        }

        while (currentRouteInts[40] == -1) { //Run till route is filled
            remainingCities[startIndex] = null;
            int index = findNextCityIndex();
            insertCityIndex(index);
            remainingCities[index] = null;
            for (int x : currentRouteInts) {
            System.out.println("routeints: " + x);
        }
        }
        
        System.out.println();
        System.out.println("Traveling Salesman Route: ");
        for (int cityIndex : currentRouteInts){
            System.out.println(capitals[cityIndex].capital());
        }
        System.out.println(capitals[currentRouteInts[0]].capital());
        System.out.println("Tour length: " + computeTourLength(currentRouteInts));
        
    }
    
    public static void tourComputation(int startingIndex) {
        
        startIndex = startingIndex;
        
        for (int capitalIndex = 0; capitalIndex < capitals.length; capitalIndex++){
            remainingCities[capitalIndex] = capitals[capitalIndex];
        }
        
        
        
        
        // currentRoute[0] = capitals[startIndex]; //init
        currentRouteInts[0] = startIndex; //init 

        for (int z = 1; z < cities; z++) { //Fill index array with -1 to differentiate
            currentRouteInts[z] = -1;
        }

        computeDistanceMatrix();
       // for (int i = 0; i < cities; i++) {
       //     for (int x = 0; x < cities; x++) {
       //         System.out.print(distanceMatrix[i][x] + " ");

       //     }
            System.out.println();
       // }

        //for (int x : currentRouteInts) {
        //    System.out.println("routeints: " + x);

//        }

        while (currentRouteInts[40] == -1) { //Run till route is filled
            remainingCities[startIndex] = null;
            int index = findNextCityIndex();
            insertCityIndex(index);
            remainingCities[index] = null;
           // for (int x : currentRouteInts) {
            //System.out.println("routeints: " + x);
       // }
        }
        
        System.out.println();
        System.out.println("Traveling Salesman Route: ");
        for (int cityIndex : currentRouteInts){
            System.out.println(capitals[cityIndex].capital());
        }
        System.out.println(capitals[currentRouteInts[0]].capital());
        System.out.println("Tour length: " + computeTourLength(currentRouteInts));
        
    }

    public static double distance(EuropeanCapital city1, EuropeanCapital city2) {
        return distance(city1.latitude(), city1.longitude(), city2.latitude(), city2.longitude());
    }

    public static double distance(double lat1, double long1, double lat2, double long2) {
        return Math.sqrt(((lat2 - lat1) * (lat2 - lat1)) + (((long2 - long1) * (long2 - long1))));
    }

    public static void computeDistanceMatrix() {
        distanceMatrix = new double[cities][cities];
        for (int i = 0; i < cities; i++) {
            for (int x = 0; x < cities; x++) {
                distanceMatrix[i][x] = distance(capitals[i], capitals[x]); //Using int to approximate   
            }
        }
    }

    public static EuropeanCapital findNextCity() { // find next index of city to insert (the furthest point) Not using currently, index is more helpful
        double furthestDistance = 0;
        int arrayIndex = 0;
        EuropeanCapital nextCity = null;

        int i = 0;
        while (currentRouteInts[i] != -1) {
            for (int x = 0; x < remainingCities.length; x++) {

                if (remainingCities[x] != null) {
                    if (distanceMatrix[i][x] > furthestDistance) {
                        furthestDistance = distanceMatrix[i][x];
                        nextCity = remainingCities[x];
                        arrayIndex = x;
                    }
                }
            }
            i++;
        }
        remainingCities[arrayIndex] = null;
        return nextCity;
    }

    public static int findNextCityIndex() { // find next index of city to insert (the furthest point)
        double furthestDistance = 0;
        int arrayIndex = 0;
        EuropeanCapital nextCity = null;

        int i = 0;
        while (currentRouteInts[i] != -1) {
            for (int x = 0; x < remainingCities.length; x++) {

                if (remainingCities[x] != null) {
                    if (distanceMatrix[i][x] > furthestDistance) {
                        furthestDistance = distanceMatrix[i][x];
                        nextCity = remainingCities[x];
                        arrayIndex = x;
                    }
                }
            }
            i++;
        }
        //System.out.println("Array Index to be inserted:" + arrayIndex);
        return arrayIndex;
    }
    
    public static int computeLastValidIndex(int[] route){
        int lastValidIndex = 0;
        while (route[lastValidIndex+1] != -1){
            lastValidIndex++;
            if (lastValidIndex == route.length-1){
                return route.length-1;
            }
        }
        return lastValidIndex;
    }

    public static double computeTourLength(int[] route) {
        double distance = 0;
        int lastValidIndex = computeLastValidIndex(route);
        if (route[1] == -1){ //only 1 node
            return 0;
        }
        int i = 1;
        while (route[i] != -1){
            distance += distanceMatrix[route[i - 1]][route[i]];
            i++;
            if (i == 40){
                distance = distance + distanceMatrix[route[0]][route[lastValidIndex]];
                return distance;
            }
        }
        distance = distance + distanceMatrix[route[0]][route[lastValidIndex]];
        return distance;
    }

    public static int[] addPos(int[] a, int pos, int num) {
        int[] result = new int[a.length];
        for (int i = 0; i < pos; i++) {
            result[i] = a[i];
        }
        result[pos] = num;
        for (int i = pos + 1; i < a.length; i++) {
            result[i] = a[i - 1];
        }
        return result;
    }

    public static void insertCityIndex(int cityIndex) {
        double minRouteLength = Integer.MAX_VALUE;
        int[] newPath = currentRouteInts;
        int tourCityCount = 0;
        while (newPath[tourCityCount] != -1){
            tourCityCount++;
        }
        for (int i = 0; i <= tourCityCount; i++) {
            int [] tempSavedPath = permutateIndicies(cityIndex, i, currentRouteInts);
            double currentLength = computeTourLength(tempSavedPath);
            if (currentLength < minRouteLength) {
                minRouteLength = currentLength;
                newPath = tempSavedPath;
            }
        }
        for (int i = 0; i < cities; i ++){
            currentRouteInts[i] = newPath[i];
        }
        //System.out.println("Path Update: ");
        for (int i : newPath) {
        //    System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static int[] permutateIndicies(int cityIndex, int permutationIndex, int[] route) {
        int[] newRoute = new int[cities];
        for (int i = 0; i < cities; i++) {
            newRoute[i] = route[i];
        }
        newRoute[permutationIndex] = cityIndex;
        for (int i = permutationIndex + 1; i < route.length; i++) {
            newRoute[i] = route[i-1];
        }
        
        //System.out.println("Permutation Update: ");
        for (int i : newRoute) {
            System.out.print(i + " ");
        }
        //System.out.println("Tour length: " + computeTourLength(newRoute));
                
        return newRoute;
    }
    
}
