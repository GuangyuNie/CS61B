package Nbody;

public class Calculation {
    public double Fnetx;
    public double Fnety;
    double G = 6.67 * Math.pow(10,-11);
    double dt = 0.03;

    public double calcDistance(Body a, Body b) {
        var Dist = Math.sqrt(Math.pow(a.xxPos - b.xxPos, 2) + Math.pow(a.yyPos - b.yyPos, 2));
        return Dist;
    }

    public double CalcForceExertedBy(Body a, Body b){
        Calculation calc = new Calculation();
        var r = calc.calcDistance(a,b);
        var Force = (G*a.mass*b.mass)/Math.pow(r,2);
        return Force;
    }

    public double CalcForceExertedByX(Body a,Body b){
        Calculation calc = new Calculation();
        var r = calc.calcDistance(a,b);
        var Force = calc.CalcForceExertedBy(a, b);
        var Forcex = Force*(b.xxPos - a.xxPos)/r;
        return Forcex;

    }

    public double CalcForceExertedByY(Body a,Body b){
        Calculation calc = new Calculation();
        var r = calc.calcDistance(a,b);
        var Force = calc.CalcForceExertedBy(a, b);
        var Forcey = Force*(b.yyPos - a.yyPos)/r;
        return Forcey;

    }

    public double CalcNetForceExertedByX(Body a, Body b){
        Calculation calc = new Calculation();
        var Forcex1 = calc.CalcForceExertedByX(a,b);
        //var Forcex2 = calc.CalcForceExertedByX(b,a);
        Fnetx = Forcex1;
        return Fnetx;


    }

    public double CalcNetForceExertedByY(Body a, Body b){
        Calculation calc = new Calculation();
        var Forcey1 = calc.CalcForceExertedByY(a,b);
        //var Forcey2 = calc.CalcForceExertedByY(b,a);
        Fnety = Forcey1;
        return Fnety;
    }

    public Body update(double dt,double Fnetx,double Fnety, Body a){
        var aNetx = Fnetx/a.mass;
        var aNety = Fnety/a.mass;
        var vnewx = a.xxVel+dt*aNetx;
        var vnewy = a.yyVel+dt*aNety;
        var pnewx = a.xxPos+dt*vnewx;
        var pnewy = a.yyPos+dt*vnewy;
        var mass = a.mass;
        String img = a.imgFileName;
        Body a_update = new Body(pnewx,pnewy,vnewx,vnewy,mass,img);
        return a_update.Body(a_update);
    }
}
