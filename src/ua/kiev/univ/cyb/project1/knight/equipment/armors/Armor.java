package ua.kiev.univ.cyb.project1.knight.equipment.armors;

import ua.kiev.univ.cyb.project1.knight.equipment.Equipment;

/**
 *  Armor is type of Equipment. Abstract class extends class <code>Equipment</code>.
 *  @author Anton Babak
 *  @since 07.11.2015
 */
public abstract class Armor extends Equipment {
    /**
     * General parameter for all armor types.
     */
    protected int strength;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * During the fight armor loses it's strength.
     * @param strength Armor lose such quantity of strength.
     */
    public void loseStrength(int strength){
        this.strength -= strength;
        if (this.strength <= 0) {
            System.out.println("Repair your armor or die next time.");
        }
    }

    /**
     * Repair armor between fights
     * @param strength Armor add such quantity of strength
     */
    public void repairArmor(int strength){
        this.strength += strength;
    }
}
