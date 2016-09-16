package spacewar.general;

import java.awt.Color;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import spacewar.database.database;
import spacewar.locations.planet;
import spacewar.locations.system;
import spacewar.locations.resource.resourceType;
import spacewar.races.race;

public class game {

    database db = new database();
    race player;
    system activeSystem;
    planet activePlanet;
    Scanner in = new Scanner(System.in);
    
    int stage;
    HashMap<Integer, ArrayList<String>> commands;
    
    public game() {
        db.initialise();
        initialise();
        
    }
    
    private void initialise() {
        createRaces();
        createSystems();
        createPlanets();
        createCommands();
        stage = 1;
    }

    private void createSystems() {
        db.addSystem(new system("Solar System", 0, 5, 5, 5));
        
    }

    private void createRaces() {
        db.addRace(new race("neutral", 0, Color.BLACK));
        db.addRace(new race("Terrans", 1, Color.BLUE));
        db.addRace(new race("Borg", 2, Color.RED));
        db.addRace(new race("Insectmen", 3, Color.GREEN));
    }

    private void createPlanets() {
        system s0 = db.getSystem(0);
        s0.addPlanet(new planet("Mercurius", 1, new BigInteger("6000"), resourceType.IRON, db.getRace(0), new BigInteger("57910000")));
        s0.addPlanet(new planet("Venus", 2, new BigInteger("900000"), resourceType.IRON, db.getRace(0), new BigInteger("108200000")));
        s0.addPlanet(new planet("Earth", 3, new BigInteger("60000000000"), resourceType.IRON, db.getRace(1), new BigInteger("149600000")));
        s0.addPlanet(new planet("Mars", 4, new BigInteger("2000000000"), resourceType.SILICON, db.getRace(0), new BigInteger("227940000")));
        s0.addPlanet(new planet("Saturn", 5, new BigInteger("9000"), resourceType.GAS, db.getRace(0), new BigInteger("778330000")));
        s0.addPlanet(new planet("Jupiter", 6, new BigInteger("30000000000"), resourceType.GAS, db.getRace(3), new BigInteger("1424600000")));
        s0.addPlanet(new planet("Uranus", 7, new BigInteger("600"), resourceType.CRYSTAL, db.getRace(0), new BigInteger("2873550000")));
        s0.addPlanet(new planet("Neptune", 8, new BigInteger("400"), resourceType.WATER, db.getRace(0), new BigInteger("4501000000")));
        s0.addPlanet(new planet("Pluto", 9, new BigInteger("7000"), resourceType.ICE, db.getRace(2), new BigInteger("5945900000")));
    }

    private void createCommands() {
        commands = new HashMap<>();
        
        //stage 1: when looking at a system, nothing selected
        ArrayList<String> cS1 = new ArrayList<>();
        cS1.add("Go to another system.");
        cS1.add("Select a planet.");
        cS1.add("Filter own planets.");
        
        //stage 2: when looking at a system, filtered selected
        ArrayList<String> cS2 = new ArrayList<>();
        cS2.add("Go to another system.");
        cS2.add("Select a planet.");
        cS2.add("Show all planets in this system.");
        
        
        //stage 11: when looking at an unowned planet
        ArrayList<String> cS11 = new ArrayList<>();
        cS11.add("Go back.");
        
        //stage 12: when looking at an owned planet
        ArrayList<String> cS12 = new ArrayList<>();
        cS12.add("Go back.");
        cS12.add("Build troops.");
        cS12.add("Build buildings.");
        
        commands.put(1, cS1);
        commands.put(2, cS2);
        commands.put(11, cS11);
        commands.put(12, cS12);
    }
    
    private void executeCommands(int stage, int command) {
        if (stage == 1) {
            if (command == 0) {
                showSystem();
            } else if (command == 1) {
                selectPlanet();
            } else if (command == 2) {
                showOwnedPlanetsInActiveSystem();
            } else {
                System.out.println("Unknown command " + command + " of stage " + stage);
            }
        } else if (stage == 2) {
            if (command == 0) {
                showSystem();
            } else if (command == 1) {
                selectPlanet();
            } else if (command == 2) {
                showPlanetsInActiveSystem();
            } else {
                System.out.println("Unknown command " + command + " of stage " + stage);
            }
        } else if (stage == 12) {
            if (command == 0) {
                showActiveSystem();
            } else {
                System.out.println("Unknown command " + command + " of stage " + stage);
            }
            
        } else if (stage == 11) {
            if (command == 0) {
                showActiveSystem();
            } else if (command == 1) {
                addTroops();
            } else if (command == 2) {
                addBuilding();
            } else {
                System.out.println("Unknown command " + command + " of stage " + stage);
            }
        } else {
            System.out.println("Unknown stage " + stage);
        }
        
        command = 100;
    }
    
    private void addTroops() {
        // TODO Auto-generated method stub
        
    }

    private void addBuilding() {
        // TODO Auto-generated method stub
        int i = 0;
        
        activePlanet.addBuilding(db.getBuildingById(i));
    }

    private void selectPlanet() {
        System.out.println("Give a planet name of the current system:");
        Boolean ok = false;
        while (!ok) {
            String input = in.nextLine();
            planet p = db.lookupPlanet(input, activeSystem);
            if (p != null) {
                activePlanet = p;
                if (p.getOwner() == player) {
                    stage = 11;
                } else {
                    stage = 12;
                }
                ok = true;
            } else {
                System.out.println("There is no such planet in this system! Try again:");
            }
        }
        System.out.println(activePlanet.toString());
    }

    private void showSystem() {
        System.out.println("Select a system:");
        for (int i = 0; i < db.getSystems().size(); i++) {
            System.out.println(i +": " + db.getSystem(i).getName());
        }
        Boolean ok = false;
        while (!ok) {
            String input = in.nextLine();
            Boolean ok2 = false;
            int id = 0;
             while (!ok2) {
                try {
                    id = Integer.parseInt(input);
                    if (id < db.getSystems().size()) {
                        ok2 = true;
                    } else {
                        System.out.println("No matching system found with ID " + id + " ! Try again");
                        input = in.nextLine();
                        
                    }
                    
                } catch (NumberFormatException nfe) {
                    System.out.println("you didn't provide a valid number! Try again");
                    input = in.nextLine();
                    ok2 = false;
                }
             }
            system s = db.getSystem(id);
            if (s != null) {
                activeSystem = s;
                stage = 1;
                ok = true;
            } else {
                System.out.println("There is no such system! Try again:");
            }
        }
        System.out.println(activeSystem.toString());
    }

    public void start(){
        setPlayerRace();
        setActiveSystem(0);
        showActiveSystem();
        showPlanetsInActiveSystem();
        while (true) {
            showCommands();
            processCommand();
        }
        
    }
    
    private void processCommand() {
        String input = in.nextLine();
        if (input.equals("exit")) {
            System.exit(0);
        }
        Boolean ok = false;
        int c = 100;
         while (!ok) {
            try {
                c = Integer.parseInt(input);
                ok = true;
            } catch (NumberFormatException nfe) {
                System.out.println("you didn't provide a valid number! Try again");
                input = in.nextLine();
                ok = false;
            }
         }
         executeCommands(stage, c);
       
    }

    private void showCommands() {
        System.out.println("Your options...");
        
        int max = commands.get(stage).size();
        for (int i = 0; i < max; i++) {
            System.out.println("   " + i + ": " + commands.get(stage).get(i));
        }
    }

    private void setActiveSystem(int i) {
        activeSystem = db.getSystem(i);
        
        
    }

    private void showPlanetsInActiveSystem() {
        for (planet p: db.getSystem(activeSystem.getId()).getPlanets()) {
            System.out.println(p.getName());
        }
        stage = 1;
        activePlanet = null;
    }
    
    private void showOwnedPlanetsInActiveSystem() {
        Boolean output = false;
        for (planet p: db.getSystem(activeSystem.getId()).getPlanets()) {
            if (p.getOwner() == player) {
                System.out.println(p.getName());
                output = true;
            }
        }
        if (!output) {
            System.out.println("You don't have any planet in this system (yet...)!");
        }
        stage = 2;
        
    }

    private void showActiveSystem() {
        if (activeSystem != null) {
            System.out.println("You're looking at system: " + activeSystem.getName());
        } else {
            throw new Error("No active system! Setting it to system with id 1");
            
        }
        
    }

    private void setPlayerRace() {
        String input;
        Boolean ok = false;
        
        System.out.println("Which race do you want to be? Select one of the following:");
        for (race r : db.getRaces()) {
            if (!r.getName().equals("neutral")) {
                System.out.println(r.getName());
            }
        }
        while (!ok) {
            input = in.nextLine();
            for (race r : db.getRaces()) {
                if (r.getName().equals(input) && !r.getName().equals("neutral")) {
                    player = r;
                    ok = true;
                } 
            }
            if (ok) {
                System.out.println("You play as the " + player.getName() + ".");
            } else {
                System.out.println("You didn't give a valid race. Try again.");
            }
        }
        
    }

}
