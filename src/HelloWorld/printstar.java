package HelloWorld;

public class printstar {
    public int Number;
    public printstar(int N){
        Number = N;
    }
    public void print() {
        int i = 0;
        int ii = 0;

        while (i <= Number) {
            ii = 0;
            while (ii < i) {
                System.out.print("*");
                ii = ii + 1;
                if (i == ii){
                    System.out.print("\r\n");
                }

            }
            i = i + 1;
        }

    }
    public static void main(String args[]){
        printstar a = new printstar(5);
        a.print();
    }

}