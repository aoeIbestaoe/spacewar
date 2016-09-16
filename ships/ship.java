package ships;

public class ship {

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
    
    public ship(String name, int cost, int buildTime, int maintenanceCost, int bombStrength, int attackStrength, int defence, int hitpoints, int capacity) {
        currentHp = hitpoints;
    }
}
