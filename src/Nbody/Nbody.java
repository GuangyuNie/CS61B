package Nbody;

public class Nbody {

    public String path;
    public double radius;

    public double readr(String path) {
        In in = new In(path);
        int number_of_p = in.readInt();
        double radius = in.readDouble();
        return radius;

    }

    public Body[] readb(String path) {
        In in = new In(path);
        int number_of_p = in.readInt();
        radius = in.readDouble();
        Body PlanetArray[] = new Body[number_of_p];
        int i = 0;
        while (i<number_of_p) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Body a = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            PlanetArray[i] = a;
            i = i + 1;

        }
        return PlanetArray;

    }

    public void draw(Body a,int scale){

        StdDraw.picture(a.xxPos/radius*scale, a.yyPos/radius*scale, "Nbody/images/"+a.imgFileName);
    }

    public static void main(String args[]){
        Calculation calc = new Calculation();
        String path = "./data/renegade.txt";
        double T = 30000000;
        double dt = 1000;
        int scale = 100;
        Nbody test = new Nbody();
        var PlanetA = test.readb(path);


        StdDraw.enableDoubleBuffering();

        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setScale(-scale, scale);
        StdDraw.clear();

        /* Clears the drawing window. */
        for(double ii = 0; ii<T; ii = ii+dt){
            StdDraw.clear();
            StdDraw.picture(0, 0, "Nbody/images/starfield.jpg");
            for(int i=0; i<PlanetA.length; i++){
                //calc F based on all other p
                double Forcex = 0;
                double Forcey = 0;
                for(int j=0; j<PlanetA.length; j++){
                    if (i!=j){
                        double Forcex_temp = calc.CalcNetForceExertedByX(PlanetA[i],PlanetA[j]);
                        Forcex = Forcex+Forcex_temp;
                        double Forcey_temp = calc.CalcNetForceExertedByY(PlanetA[i],PlanetA[j]);
                        Forcey = Forcey+Forcey_temp;

                    }
                    PlanetA[i] = calc.update(dt,Forcex,Forcey,PlanetA[i]);
                }
                test.draw(PlanetA[i],scale);
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", PlanetA.length);
        for (int i = 0; i < PlanetA.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    PlanetA[i].xxPos, PlanetA[i].yyPos, PlanetA[i].xxVel,
                    PlanetA[i].yyVel, PlanetA[i].mass, PlanetA[i].imgFileName);
        }



    }

}
