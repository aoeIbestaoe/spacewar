package spacewar.database;

import java.util.ArrayList;

import spacewar.buildings.barracks;
import spacewar.buildings.building;
import spacewar.locations.planet;
import spacewar.locations.system;
import spacewar.races.race;

public class database {

    private ArrayList<system> systems;
    private ArrayList<race> races;
    private ArrayList<building> possibleBuildings;
    
    public void initialise() {
        setSystems(new ArrayList<>());
        setRaces(new ArrayList<>());
        possibleBuildings = new ArrayList<>();
        possibleBuildings.add(new building("farm", 500, 2));
        possibleBuildings.add(new building("library", 5000, 4));
        possibleBuildings.add(new barracks());
        
        
    }

    

    public void addRace(race race) {
        getRaces().add(race);
        
    }

    public void addSystem(system system) {
        getSystems().add(system);
        
    }
    
    public system getSystem(int i) {
        system s  = null;
        Boolean found = false;
        for (system sys : getSystems()) {
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
    
    public race getRace(int i) {
        race r  = null;
        Boolean found = false;
        for (race race : getRaces()) {
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



    public planet lookupPlanet(String input, system activeSystem) {
        planet p = null;
        for (planet pla : activeSystem.getPlanets()) {
            if (pla.getName().equals(input)) {
                p = pla;
            }
        }
        return p;
    }



    public building getBuildingById(int i) {
        return possibleBuildings.get(i);
    }



    public ArrayList<system> getSystems() {
        return systems;
    }



    public void setSystems(ArrayList<system> systems) {
        this.systems = systems;
    }



    public ArrayList<race> getRaces() {
        return races;
    }



    public void setRaces(ArrayList<race> races) {
        this.races = races;
    }
}
