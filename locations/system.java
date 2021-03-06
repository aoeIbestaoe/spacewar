package locations;

import java.util.ArrayList;

public class system {

    private String name;
    private int id;
    private ArrayList<planet> planets;
    private int x;
    private int y;
    private int z;
    
    
    public system(String name, int id, int x, int y, int z) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        planets = new ArrayList<>();
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

    public ArrayList<planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<planet> planets) {
        this.planets = planets;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void addPlanet(planet p) {
        planets.add(p);
    }

    public String toString() {
        return getName() + ", with " + planets.size() + " planets.\n      location: (" + x + "," + y + "," + z + ").";
    }
}
