package singleton;

public class Main {
    public static void main(String[] args) {
        // Boss b = new Boss(125);

        Boss b1 = Boss.getInstance(100);
        Boss b2 = Boss.getInstance(200);

        System.out.println("Boss 1: " + b1.getHp());
        System.out.println("Boss 2: " + b2.getHp());

        // System.out.println("Boss 3: " + b3.getHp());
    }

}
