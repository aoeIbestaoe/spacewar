/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings;

/**
 *
 * @author sande
 */
public class PowerPlant extends Building {
   
    int energyProduction = 100;
    
    public PowerPlant() {
        super("power plant", 500, 2, "The blood of a modern civilization.");
        
    }
}
