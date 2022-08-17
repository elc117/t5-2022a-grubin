package singleton;

public class Boss {
    private static Boss boss;
    private int hp;

    public Boss getBoss() {
        return boss;
    }

    public int getHp() {
        return hp;
    }

    private Boss(int hp) {
        this.hp = hp;
    }

    static Boss getInstance(int hp) {
        if (boss == null) {
            boss = new Boss(hp);
        }
        return boss;
    }
}
