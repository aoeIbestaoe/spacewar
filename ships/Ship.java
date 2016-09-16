package ships;

public class Ship {

    String name;
    int cost;
    int buildTime;
    int speed;
    int maintenanceCost;
    int bombStrength;
    int attackStrength;
    int defence;
    int hitpoints;
    int capacity;
    int currentHp;
    
    public Ship(String name, int cost, int buildTime, int maintenanceCost, int bombStrength, int attackStrength, int defence, int hitpoints, int capacity) {
        currentHp = hitpoints;
    }
}
