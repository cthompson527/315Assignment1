package edu.tamu.csce315;

/**
 * Created by corythompson on 1/20/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private String file;
    private Scanner scanner;

    public Parser(String file) {
        this.file = file;
        try {
            scanner = new Scanner(new File(this.file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Team> createTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        while (scanner.hasNext()) {
            teams.add(createTeam());
        }
        return teams;
    }

    private Team createTeam() {
        String name = scanner.next();
        int asm     = scanner.nextInt();
        double pya  = scanner.nextDouble();
        double dpya = scanner.nextDouble();
        double rya  = scanner.nextDouble();
        double drya = scanner.nextDouble();
        int to      = scanner.nextInt();
        int dto     = scanner.nextInt();
        int pendif  = scanner.nextInt();
        int rettd   = scanner.nextInt();
        return new Team(name, asm, pya, dpya, rya, drya, to, dto, pendif, rettd);
    }
}
