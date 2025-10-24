
public class Demo1 {
    public static void main(String[] args) {
        CricketPlayer c = new CricketPlayer("Sachin", 20, "Batsman");
        FootballPlayer f = new FootballPlayer("Namrata", 21, "Forward");
        HockeyPlayer h = new HockeyPlayer("Mandeep", 22, "Defender");

        // direct calls
        c.show();
        System.out.println();
        f.show();
        System.out.println();
        h.show();

        // demonstration of polymorphism (upcasting)
        System.out.println("\nPolymorphism example:");
        Player p = new CricketPlayer("Rahul", 27, "All-rounder");
        p.show();  // dynamic dispatch -> CricketPlayer.show()
    }
}

/* Base class for common player fields */
class Player {
    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    // method intended to be overridden
    public void show() {
        System.out.println("Player name: " + name);
        System.out.println("Age: " + age);
    }
}

/* Cricket player subclass */
class CricketPlayer extends Player {
    private String role;

    public CricketPlayer(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Player type : Cricket");
        System.out.println("Role        : " + role);
    }
}

/* Football player subclass */
class FootballPlayer extends Player {
    private String position;

    public FootballPlayer(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Player type : Football");
        System.out.println("Position    : " + position);
    }
}

/* Hockey player subclass */
class HockeyPlayer extends Player {
    private String position;

    public HockeyPlayer(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Player type : Hockey");
        System.out.println("Position    : " + position);
    }
}
