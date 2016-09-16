package locations;

import java.math.BigInteger;
import java.util.ArrayList;

import buildings.Building;
import locations.Resource.resourceType;
import races.Race;

public class Planet {

    private String name;
    private int id;
    private BigInteger inhabitans;
    private resourceType rt;
    private Race owner;
    private BigInteger dFS;
    private ArrayList<Building> buildings;
    
    public Planet(String name, int id, BigInteger inhabitans, resourceType rt, Race owner, BigInteger dFS) {
        this.name = name;
        this.id = id;
        this.inhabitans = inhabitans;
        this.rt = rt;
        this.owner = owner;
        this.dFS = dFS;
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

    public BigInteger getInhabitans() {
        return inhabitans;
    }

    public void setInhabitans(BigInteger inhabitans) {
        this.inhabitans = inhabitans;
    }

    public resourceType getRt() {
        return rt;
    }

    public void setRt(resourceType rt) {
        this.rt = rt;
    }

    public Race getOwner() {
        return owner;
    }

    public void setOwner(Race owner) {
        this.owner = owner;
    }

    public BigInteger getdFS() {
        return dFS;
    }

    public void setdFS(BigInteger dFS) {
        this.dFS = dFS;
    }

    public String toString() {
        return getName() + ", owned by " + getOwner().getName() + " with " + getInhabitans().toString() + " inhabitans. \n      "+ getdFS() +  " km from the sun and its resourcetype is " + getRt();
    }
    
    public void addBuilding(Building b) {
        buildings.add(b);
    }
    
    public Building getBuilding(int i) {
        return buildings.get(i);
    }
}
