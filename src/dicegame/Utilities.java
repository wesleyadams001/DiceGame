/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 * A Utilities class to hold simple helper functions related to currency
 * @author Wesley
 */
public class Utilities {
    
    /**
     * converts units to currency
     * @param units
     * @return AcctValue with dollars and cents
     */
    public static AcctValue convertUnitsToCurrency(long units){
        int dollars = (int) units/100;
        int cents = (int) units%100;
        AcctValue val = new AcctValue(dollars,cents);
        return val;
    }
    
    /**
     * converts currency to units
     * @param val
     * @return long with pennies
     */
    public static long convertCurrencyToUnits(AcctValue val){
        long units = (val.getDollars()*100)+val.getCents();
        return units;
    }
    
    /**
     * converts currency to units
     * @param dollars
     * @param cents
     * @return long with pennies
     */
    public static long convertCurrencyToUnits(int dollars, int cents){
        long units = (dollars*100)+cents;
        return units;
    }
    
        /*
    * calculates an average of two values
    * @return double
    */
    public static double calculateAverage(long x, long y){
        double avg = (x+y)/2;
        return avg;
    }
    
     /*
    * calculates a percentile from number of values min and max
    * @return long as a percentile
    */
    public static long calculatePercentile(int valuesCnt, int min, double targetPercentile)
    {
        double index = ((double)targetPercentile/100) * (double)valuesCnt;
        double increment = Math.floor(index);
        long percentile = min + (long)increment;
        return percentile;
    }
    
    /*
    * calculates a standard deviation dynamically
    * @return long standard deviation
    */
    public static double calculateStandardDev(double cnt, int min){
        double sum1 = 0;
        double sum2 = 0;
        double n = min;
        for (int i = 1; i <= cnt; i++)
        {
            sum1 += n;
            sum2 += n * n;
            n++;
        }
        double variance = (cnt * sum2 - sum1 * sum1) / (cnt * cnt);
        double stddev = Math.sqrt(variance);
        return stddev;
    }
}
