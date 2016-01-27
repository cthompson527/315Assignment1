package edu.tamu.csce315;


import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;


/**
 * Created by corythompson on 1/20/16.
 */
public class Main {

    public static void main(String[] args) {
        Parser p = new Parser("/Users/corythompson/Documents/OneDrive/Developer/IntelliJ/StatParser/Input File/315Assignment1.txt");
        ArrayList<Team> teams = p.createTeams();
        Collections.sort(teams);
        for (Team team : teams) {
            System.out.println(team);

            
        }


    }

}
