package edu.tamu.csce315;


import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.*;


/**
 * Created by corythompson on 1/20/16.
 */
public class Main {

    public static void main(String[] args) {
        Parser p = new Parser("Input File/315Assignment1.txt");
        SummaryStatistics ssASM = new SummaryStatistics();
        SummaryStatistics ssPSM = new SummaryStatistics();
        ArrayList<Team> teams = p.createTeams();
        Collections.sort(teams);
        for (Team team : teams) {
            System.out.println(team);
            ssASM.addValue(team.getASM());
            ssPSM.addValue(team.getPSM());
        }

        TTest tTest = new TTest();
        double tStatistic;
        tStatistic = tTest.t(ssASM, ssPSM);

        /*System.out.println(Double.toString(ssASM.getN()));
        System.out.println(Double.toString(ssASM.getMean()));
        System.out.println(Double.toString(ssASM))
        System.out.println(Double.toString(tStatistic));*/

        System.out.printf("\n\n%-19s %-7s %-6s\n", "Type", "ASM", "PSM");
        printResult("sample size", ssASM.getN(), ssPSM.getN());
        printResult("mean", ssASM.getMean(), ssPSM.getMean());
        printResult("standard dev", ssASM.getStandardDeviation(), ssPSM.getStandardDeviation());
        printResult("standard error", ssASM.getStandardDeviation()/Math.sqrt(ssASM.getN()), ssASM.getStandardDeviation()/Math.sqrt(ssPSM.getN()));
        printResult("maximum", ssASM.getMax(), ssPSM.getMax());
        printResult("minimum", ssASM.getMin(), ssPSM.getMin());

        System.out.printf("\n%-15s %.6f", "t-Statistic", tStatistic);
    }

    public static void printResult(String type, double asm, double psm) {
        System.out.printf("%-20s", type);
        System.out.printf("%.2f\t", asm);
        System.out.printf("%.2f\n", psm);
    }

}

/*class TTESTStat {
    public static void Main(String[] args){
        double[] sample1 = { 1  , 2  , 3   ,4 , 3, 5, 6.1, 3.4, 2.9, 4.4};
        double[] sample2 = { 5.2, 4.2, 7.24,4 , 5, 6, 4.1, 5.9, 7.0, 8.0};
        double t_statistic;
        TTest ttest = new TTest();
        t_statistic = ttest.t(sample1, sample2);
        System.out.println(Double.toString( t_statistic) );
    }
}*/
