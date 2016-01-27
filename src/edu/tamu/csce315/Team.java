package edu.tamu.csce315;

/**
 * Created by corythompson on 1/20/16.
 */
public class Team implements Comparable<Team> {
    private String name;
    private int asm, to, dto, pendif, rettd;
    private double pya, dpya, rya, drya, psm;

    public Team(String name, int asm, double pya, double dpya, double rya, double drya, int to, int dto, int pendif, int rettd) {
        this.name   = name;
        this.asm    = asm;
        this.to     = to;
        this.dto    = dto;
        this.pendif = pendif;
        this.rettd  = rettd;
        this.pya    = pya;
        this.dpya   = dpya;
        this.rya    = rya;
        this.drya   = drya;
        this.psm    = ((3.17 * rettd) - (0.06 * pendif) + (61.67 * pya) + (26.44 * rya) - (2.77 * to) - (67.5 * dpya) - (22.79 * drya) + (3.49 * dto));
    }

    public Team(String name) {
        this(name, 0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0);
    }

    public int getASM() {
        return asm;
    }

    public double getPSM() {
        return psm;
    }

    @Override
    public int compareTo(Team o) {
        if (this.equals(o))
            return 0;
        return this.name.compareTo(o.name);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (asm != team.asm) return false;
        if (to != team.to) return false;
        if (dto != team.dto) return false;
        if (pendif != team.pendif) return false;
        if (rettd != team.rettd) return false;
        if (Double.compare(team.pya, pya) != 0) return false;
        if (Double.compare(team.dpya, dpya) != 0) return false;
        if (Double.compare(team.rya, rya) != 0) return false;
        if (Double.compare(team.drya, drya) != 0) return false;
        return name.equals(team.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + asm;
        result = 31 * result + to;
        result = 31 * result + dto;
        result = 31 * result + pendif;
        result = 31 * result + rettd;
        temp = Double.doubleToLongBits(pya);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dpya);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rya);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(drya);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-12s %4s\t%.2f", name, asm, getPSM());
    }
}
