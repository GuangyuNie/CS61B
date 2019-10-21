package HelloWorld;

public class HelloWorldLauncher {
    public static void main(String[] args){
        HelloWorld b = new HelloWorld(12);
        b.test();
        HelloWorld[] array1= new HelloWorld[2];
        array1[0] = new HelloWorld(8);
        array1[1] = new HelloWorld(12);
        array1[0].test();

        HelloWorld a = new HelloWorld(8);
        HelloWorld big = HelloWorld.maxNum(a,b);
        big.test();



    }
}
