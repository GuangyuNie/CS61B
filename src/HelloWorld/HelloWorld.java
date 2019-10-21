package HelloWorld;

public class HelloWorld{
    public int weight;


    public HelloWorld(int w){
        weight = w;
    }


    public void test(){
        if (weight<10){
        System.out.println("Hello world");
    }else{
        System.out.println("Bye");}
    }


    public static HelloWorld maxNum(HelloWorld a, HelloWorld b){
        if (a.weight < b.weight){
            return b;
        }
        else{
            return a;
        }
    }
    }