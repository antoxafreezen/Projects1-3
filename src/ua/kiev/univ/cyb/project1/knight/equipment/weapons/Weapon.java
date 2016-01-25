package ua.kiev.univ.cyb.project1.knight.equipment.weapons;

import ua.kiev.univ.cyb.project1.knight.equipment.Equipment;

/**
 *  Weapon is type of Equipment. Abstract class extends class <code>Equipment</code>.
 *  @author Anton Babak
 *  @since 07.11.2015
 */
public abstract class Weapon extends Equipment {
    /**
     * General parameter for all weapons.
     */
    protected int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * During the fight weapon loses it's damage.
     * @param damage Armor lose such quantity of damage.
     */
    public void loseDamage(int damage){
        this.damage -= damage;
        if (this.damage <= 0) System.out.println("Repair your weapon or die next time.");
    }

    /**
     * Improve weapon between fights. Every weapon has own improving methods.
     * @param damage Weapon improve such quantity of damage.
     */
    public abstract void improveWeapon(int damage);
}
