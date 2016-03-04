package jdbcdemo;

public class StaticInit {

    static int i = 10;
    static int ii = 111 + i;

    static {
        System.out.println("i = " + i);
        i++;
    }

    static {
        System.out.println("i = " + i);
        System.out.println("ii = " + ii);
        System.out.println("last");
    }

    public static void main(String[] args) {
        System.out.println("StaticInit.main");
    }
}
