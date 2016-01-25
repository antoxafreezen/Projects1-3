package ua.kiev.univ.cyb.project1.knight.equipment.armors;

import ua.kiev.univ.cyb.project1.knight.equipment.materials.HelmetType;
/**
 * Helmet is type of armor. Class extends <code>Armor</code>
 * and uses field with enum <code>HelmetType</code>.
 * @author Anton Babak
 * @since 07.11.2015
 */
public class Helmet extends Armor {
    /**
     * Breastplate type.
     */
    private HelmetType type;

    public HelmetType getType() {
        return type;
    }

    public void setType(HelmetType type) {
        this.type = type;
    }

    /**
     * Create helmet with price, weight, strength and type.
     * @param price Price extends from <code>Equipment</code>
     * @param weight Weight extends from <code>Equipment</code>
     * @param strength Strength extends from <code>Armor</code>
     * @param type Type of helmet
     */
    public Helmet(int price, int weight, int strength, HelmetType type) {
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.strength = strength;

    }
}
