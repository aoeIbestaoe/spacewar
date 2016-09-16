package races;

import java.awt.Color;

public class race {

    private String name;
    private int id;
    private Color color;
    private Integer wealth;
    
    public race(String name, int id, Color color) {
        this.name = name;
        this.id = id;
        this.color = color;
        this.wealth = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getWealth() {
        return wealth;
    }

    public void setWealth(Integer wealth) {
        this.wealth = wealth;
    }

}
