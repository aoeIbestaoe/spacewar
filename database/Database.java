package database;

import buildings.Barracks;
import buildings.Building;
import buildings.Farm;
import buildings.Library;
import java.util.ArrayList;
import locations.Planet;
import locations.PlanetarySystem;
import races.Race;

public class Database {

    private ArrayList<PlanetarySystem> systems;
    private ArrayList<Race> races;
    private ArrayList<Building> possibleBuildings;
    
    public void initialise() {
        setSystems(new ArrayList<>());
        setRaces(new ArrayList<>());
        possibleBuildings = new ArrayList<>();
        possibleBuildings.add(new Farm());
        possibleBuildings.add(new Library());
        possibleBuildings.add(new Barracks());
        
        
    }

    

    public void addRace(Race race) {
        getRaces().add(race);
        
    }

    public void addSystem(PlanetarySystem system) {
        getSystems().add(system);
        
    }
    
    public PlanetarySystem getSystem(int i) {
        PlanetarySystem s  = null;
        Boolean found = false;
        for (PlanetarySystem sys : getSystems()) {
            if (sys.getId() == i) {
                found = true;
                s = sys;
            }
        }
        if (!found) {
            throw new Error("Looking for unknown system with id: " + i);
        }
        return s;
    }
    
    public Race getRace(int i) {
        Race r  = null;
        Boolean found = false;
        for (Race race : getRaces()) {
            if (race.getId() == i) {
                found = true;
                r = race;
            }
        }
        if (!found) {
            throw new Error("Looking for unknown race with id: " + i);
        }
        return r;
    }



    public Planet lookupPlanet(String input, PlanetarySystem activeSystem) {
        Planet p = null;
        for (Planet pla : activeSystem.getPlanets()) {
            if (pla.getName().equals(input)) {
                p = pla;
            }
        }
        return p;
    }



    public Building getBuildingById(int i) {
        return possibleBuildings.get(i);
    }



    public ArrayList<PlanetarySystem> getSystems() {
        return systems;
    }



    public void setSystems(ArrayList<PlanetarySystem> systems) {
        this.systems = systems;
    }



    public ArrayList<Race> getRaces() {
        return races;
    }



    public void setRaces(ArrayList<Race> races) {
        this.races = races;
    }
}
