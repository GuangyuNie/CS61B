package Nbody;

public class TestBody {
    public static void main(String args[]){
        Body a = new Body(0,0,0,0,10,"1");
        Body b = new Body(3,4,0,0,10,"1");
        Calculation Dist = new Calculation();

        var a1 = Dist.calcDistance(a,b);
        System.out.println(a1);
    }


}
