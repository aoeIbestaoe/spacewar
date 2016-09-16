package buildings;

public class Building {

    String name;
    int cost;
    int buildTime;
    String description;
    
    public Building(String name, int cost, int buildTime, String description) {
        this.name = name;
        this.cost = cost;
        this.buildTime = buildTime;
        this.description = description;
    }
}
