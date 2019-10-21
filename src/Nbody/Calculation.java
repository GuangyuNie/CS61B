package Nbody;

public class Calculation {
    public double Dist;

    public double calcDistance(Body a, Body b) {
        Dist = Math.sqrt(Math.pow(a.xxPos - b.xxPos, 2) + Math.pow(a.yyPos - b.yyPos, 2));
        return Dist;
    }
}
